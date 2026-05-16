package com.kunk.singbox.ui.screens

import com.kunk.singbox.R
import android.content.Intent
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.kunk.singbox.viewmodel.LogViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogsScreen(navController: NavController, viewModel: LogViewModel = viewModel()) {
    val logs by viewModel.filteredLogs.collectAsState()
    val searchKeyword by viewModel.searchKeyword.collectAsState()
    val selectedCategory by viewModel.selectedCategory.collectAsState()
    val context = LocalContext.current
    val listState = rememberLazyListState()

    Scaffold(
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        stringResource(R.string.logs_title),
                        color = MaterialTheme.colorScheme.onBackground
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            Icons.Rounded.ArrowBack,
                            contentDescription = stringResource(R.string.common_back),
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }
                },
                actions = {
                    val exportSubject = "KunBox " + stringResource(R.string.logs_title)
                    val exportTitle = stringResource(R.string.logs_export)
                    IconButton(onClick = {
                        val logsText = viewModel.getLogsForExport()
                        val shareIntent = Intent(Intent.ACTION_SEND).apply {
                            type = "text/plain"
                            putExtra(Intent.EXTRA_SUBJECT, exportSubject)
                            putExtra(Intent.EXTRA_TEXT, logsText)
                        }
                        context.startActivity(
                            Intent.createChooser(shareIntent, exportTitle)
                        )
                    }) {
                        Icon(
                            Icons.Rounded.Share,
                            contentDescription = stringResource(R.string.logs_export),
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }
                    IconButton(onClick = { viewModel.clearLogs() }) {
                        Icon(
                            Icons.Rounded.Delete,
                            contentDescription = stringResource(R.string.logs_clear),
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            OutlinedTextField(
                value = searchKeyword,
                onValueChange = { viewModel.setSearchKeyword(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 4.dp),
                placeholder = {
                    Text(stringResource(R.string.logs_search_hint))
                },
                leadingIcon = {
                    Icon(Icons.Rounded.Search, contentDescription = null)
                },
                trailingIcon = {
                    if (searchKeyword.isNotEmpty()) {
                        IconButton(onClick = { viewModel.setSearchKeyword("") }) {
                            Icon(Icons.Rounded.Clear, contentDescription = null)
                        }
                    }
                },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f)
                )
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                viewModel.categories.forEach { category ->
                    FilterChip(
                        selected = selectedCategory == category,
                        onClick = { viewModel.setCategory(category) },
                        label = { Text(category, fontSize = 12.sp) }
                    )
                }
            }

            LazyColumn(
                state = listState,
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(
                    start = 12.dp,
                    end = 12.dp,
                    bottom = WindowInsets.navigationBars.asPaddingValues()
                        .calculateBottomPadding()
                ),
                reverseLayout = true
            ) {
                items(logs) { log ->
                    Text(
                        text = log,
                        color = when {
                            log.contains("ERROR", ignoreCase = true) ||
                                log.contains("[ERR]") ->
                                MaterialTheme.colorScheme.error

                            log.contains("WARN", ignoreCase = true) ->
                                MaterialTheme.colorScheme.error.copy(alpha = 0.8f)

                            log.contains("dns:", ignoreCase = true) ->
                                MaterialTheme.colorScheme.tertiary

                            log.contains("[CONN]") ||
                                log.contains("outbound/") ||
                                log.contains("inbound/") ->
                                MaterialTheme.colorScheme.primary

                            else -> MaterialTheme.colorScheme.onSurface
                        },
                        fontFamily = FontFamily.Monospace,
                        fontSize = 11.sp,
                        lineHeight = 15.sp,
                        modifier = Modifier.padding(vertical = 1.dp)
                    )
                }
            }
        }
    }
}
