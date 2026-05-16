package com.kunk.singbox.utils

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.os.LocaleList
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import com.kunk.singbox.model.AppLanguage
import java.util.Locale

object LocaleHelper {

    fun applyLanguage(language: AppLanguage) {
        val tag = when (language) {
            AppLanguage.SYSTEM -> ""
            AppLanguage.CHINESE -> "zh"
            AppLanguage.ENGLISH -> "en"
            AppLanguage.RUSSIAN -> "ru"
        }
        AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(tag))
    }

    fun setLocale(context: Context, language: AppLanguage): Context {
        val locale = when (language) {
            AppLanguage.SYSTEM -> getSystemLocale()
            AppLanguage.CHINESE -> Locale.SIMPLIFIED_CHINESE
            AppLanguage.ENGLISH -> Locale.ENGLISH
            AppLanguage.RUSSIAN -> Locale("ru")
        }

        return updateResources(context, locale)
    }

    private fun getSystemLocale(): Locale {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            LocaleList.getDefault().get(0)
        } else {
            @Suppress("DEPRECATION")
            Locale.getDefault()
        }
    }

    private fun updateResources(context: Context, locale: Locale): Context {
        Locale.setDefault(locale)

        val configuration = Configuration(context.resources.configuration)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            configuration.setLocales(LocaleList(locale))
        }
        configuration.setLocale(locale)

        return context.createConfigurationContext(configuration)
    }

    fun getLanguageDisplayName(language: AppLanguage): String {
        return when (language) {
            AppLanguage.SYSTEM -> "System Default"
            AppLanguage.CHINESE -> "简体中文"
            AppLanguage.ENGLISH -> "English"
            AppLanguage.RUSSIAN -> "Русский"
        }
    }

    fun wrap(context: Context, language: AppLanguage): Context {
        return setLocale(context, language)
    }
}
