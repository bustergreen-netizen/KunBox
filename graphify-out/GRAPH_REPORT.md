# Graph Report - app  (2026-04-12)

## Corpus Check
- 197 files · ~169,979 words
- Verdict: corpus is large enough that graph structure adds value.

## Summary
- 3096 nodes · 2924 edges · 196 communities detected
- Extraction: 99% EXTRACTED · 1% INFERRED · 0% AMBIGUOUS · INFERRED: 23 edges (avg confidence: 0.82)
- Token cost: 0 input · 0 output

## God Nodes (most connected - your core abstractions)
1. `ConfigRepository` - 144 edges
2. `ConfigRepositoryTest` - 82 edges
3. `SingBoxService` - 80 edges
4. `SettingsViewModel` - 74 edges
5. `SettingsRepository` - 64 edges
6. `NodeLinkParserTest` - 46 edges
7. `BoxWrapperManager` - 44 edges
8. `VpnStateStore` - 43 edges
9. `SingBoxRemote` - 39 edges
10. `CommandManager` - 35 edges

## Surprising Connections (you probably didn't know these)
- `SingBoxService` --rationale_for--> `UI and VPN Process Split`  [INFERRED]
  app\src\main\java\com\kunk\singbox\service\SingBoxService.kt → app\src\main\java\com\kunk\singbox\MainActivity.kt
- `ProxyOnlyService` --conceptually_related_to--> `Service Manager Layer`  [INFERRED]
  app\src\main\java\com\kunk\singbox\service\ProxyOnlyService.kt → app\src\main\java\com\kunk\singbox\service\manager\CommandManager.kt
- `Service Manager Test Suite` --references--> `Service Manager Layer`  [INFERRED]
  app\src\test\java\com\kunk\singbox\service\manager\StartupManagerTest.kt → app\src\main\java\com\kunk\singbox\service\manager\CommandManager.kt
- `Model Contracts` --shares_data_with--> `ConfigRepository`  [INFERRED]
  app\src\main\java\com\kunk\singbox\model\SingBoxConfig.kt → app\src\main\java\com\kunk\singbox\repository\ConfigRepository.kt
- `Networking Utilities` --conceptually_related_to--> `ConfigRepository`  [INFERRED]
  app\src\main\java\com\kunk\singbox\utils\NetworkClient.kt → app\src\main\java\com\kunk\singbox\repository\ConfigRepository.kt

## Hyperedges (group relationships)
- **UI Runtime Control Flow** — entry_mainactivity, ui_navigation_module, viewmodel_layer, ipc_client_remote, service_runtime, repository_config [INFERRED 0.87]
- **IPC State Sync Flow** — ipc_client_remote, ipc_hub, ipc_state_store, dual_channel_state_sync, service_runtime [INFERRED 0.90]
- **Config Runtime Flow** — repository_config, repository_config_helpers, repository_store_layer, service_runtime, core_wrapper, runtime_config_generation [INFERRED 0.85]
- **Settings To Restart Flow** — repository_settings, settings_restart_required_flow, viewmodel_layer, service_runtime, ipc_state_store [INFERRED 0.82]
- **Parser And Import Flow** — parser_module, parser_nodelink, repository_config, test_parser_suite, test_config_repo_suite, protocol_parsing_flow [INFERRED 0.84]
- **Traffic And Observability Flow** — repository_traffic, command_manager, utility_updates, ipc_state_store, traffic_persistence_flow [INFERRED 0.74]
- **Regression Test Safety Net** — test_config_repo_suite, test_service_manager_suite, test_parser_suite, repository_config, service_manager_layer, parser_module, test_regression_safety_net [INFERRED 0.86]

## Communities

### Community 0 - "Config Repository / .add Single Node()"
Cohesion: 0.01
Nodes (1): ConfigRepository

### Community 1 - "Sing Box Service.kt / cache Uid To Package()"
Cohesion: 0.02
Nodes (9): ForegroundFallbackState, NetworkTypeChangedFallbackAction, NetworkTypeChangedFallbackState, NetworkTypeChangedRecoverySignal, RecoveryDebounceContext, RecoveryProfile, RecoveryReason, RecoveryRequest (+1 more)

### Community 2 - "Settings View Model.kt / Default Rule Set Download State"
Cohesion: 0.02
Nodes (12): DefaultRuleSetDownloadState, Error, Exporting, ExportState, Idle, Importing, ImportState, PartialSuccess (+4 more)

### Community 3 - "Config Repository Test.kt / Config Repository Test"
Cohesion: 0.02
Nodes (1): ConfigRepositoryTest

### Community 4 - "Sing Box Service / .build Network Type Changed State Skip()"
Cohesion: 0.03
Nodes (1): SingBoxService

### Community 5 - "Command Manager / Core Module"
Cohesion: 0.03
Nodes (41): CommandManager, Core Module, BoxWrapperManager, DashboardViewModel, Quadruple, Room Entity and DAO Layer, AppDatabase, Dual Channel State Sync (+33 more)

### Community 6 - "Config Repository.kt / apply Selector Safe Outbounds For Test()"
Cohesion: 0.03
Nodes (20): Block, ConfigGenerationResult, Direct, Failed, FallbackProxy, FetchResult, NodeSwitchResult, NodeTestInfo (+12 more)

### Community 7 - "Settings Repository.kt / get Instance()"
Cohesion: 0.03
Nodes (1): SettingsRepository

### Community 8 - "Platform Interface Impl.kt / .cache Uid To Package()"
Cohesion: 0.03
Nodes (3): Callbacks, PlatformInterfaceImpl, StringIteratorImpl

### Community 9 - "Sing Box Core.kt / Active Connection"
Cohesion: 0.03
Nodes (5): ActiveConnection, SingBoxCore, StringIteratorImpl, TestCommandServerHandler, TestPlatformInterface

### Community 10 - "Startup Manager.kt / apply Prewarmed Domain Ips()"
Cohesion: 0.04
Nodes (8): Callbacks, Cancelled, Failed, NeedPermission, ParallelInitResult, StartResult, StartupManager, Success

### Community 11 - "Settings Store Ext.kt / set Allow Lan()"
Cohesion: 0.04
Nodes (0): 

### Community 12 - "Sing Box Remote.kt / Already Connected"
Cohesion: 0.04
Nodes (6): AlreadyConnected, Failed, HotReloadResult, Recovering, RecoveryResult, SingBoxRemote

### Community 13 - "Box Wrapper Manager.kt / Box Wrapper Manager"
Cohesion: 0.04
Nodes (4): BoxWrapperManager, RecoveryLevel, RecoveryMode, SmartRecoveryResult

### Community 14 - "Node Link Parser Test.kt / Node Link Parser Test"
Cohesion: 0.04
Nodes (1): NodeLinkParserTest

### Community 15 - "Vpn State Store.kt / Core Mode"
Cohesion: 0.04
Nodes (2): CoreMode, VpnStateStore

### Community 16 - "Route Group Selector.kt / .get Command Client()"
Cohesion: 0.05
Nodes (5): Callbacks, FirstValidSelectionDecision, RouteGroupSelector, RouteGroupTarget, SelectionContext

### Community 17 - "Command Manager.kt / .on Service Reload()"
Cohesion: 0.05
Nodes (2): Callbacks, CommandManager

### Community 18 - "Proxy Only Service.kt / auto Detect Interface Control()"
Cohesion: 0.05
Nodes (2): ProxyOnlyService, StringIteratorImpl

### Community 19 - "Shutdown Manager.kt / .cancel Auto Failover Job()"
Cohesion: 0.06
Nodes (3): Callbacks, ShutdownManager, ShutdownOptions

### Community 20 - "Core Manager.kt / Cancelled"
Cohesion: 0.06
Nodes (6): Cancelled, CoreManager, Failed, StartResult, StopResult, Success

### Community 21 - "Traffic Repository.kt / Daily Traffic Record"
Cohesion: 0.06
Nodes (5): DailyTrafficRecord, NodeTrafficStats, TrafficPeriod, TrafficRepository, TrafficSummary

### Community 22 - "Node Link Parser.kt / Node Link Parser"
Cohesion: 0.06
Nodes (1): NodeLinkParser

### Community 23 - "Clash Yaml Parser.kt / Clash Yaml Parser"
Cohesion: 0.07
Nodes (1): ClashYamlParser

### Community 24 - "Recovery Logic Test.kt / Recovery Logic Test"
Cohesion: 0.07
Nodes (1): RecoveryLogicTest

### Community 25 - "Libbox Compat.kt / Libbox Compat"
Cohesion: 0.07
Nodes (1): LibboxCompat

### Community 26 - "Node Dao.kt / Node Dao"
Cohesion: 0.07
Nodes (1): NodeDao

### Community 27 - "Profile Dao.kt / Profile Dao"
Cohesion: 0.07
Nodes (1): ProfileDao

### Community 28 - "Sing Box Config.kt / Cache File Config"
Cohesion: 0.08
Nodes (25): CacheFileConfig, ClashApiConfig, DnsConfig, DnsFakeIpConfig, DnsRule, DnsServer, DomainResolveConfig, EchConfig (+17 more)

### Community 29 - "App Navigation.kt / App Navigation()"
Cohesion: 0.08
Nodes (20): AppRules, ConnectionSettings, CustomRules, Dashboard, Diagnostics, DnsSettings, DomainRules, Logs (+12 more)

### Community 30 - "Route Group Selector Test.kt / Route Group Selector Test"
Cohesion: 0.08
Nodes (1): RouteGroupSelectorTest

### Community 31 - "Sing Box Ipc Hub.kt / Hot Reload Result"
Cohesion: 0.08
Nodes (3): HotReloadResult, SingBoxIpcHub, StateSnapshot

### Community 32 - "Node State Manager.kt / Node State Manager"
Cohesion: 0.08
Nodes (1): NodeStateManager

### Community 33 - "Vpn Tile Service.kt / on Receive()"
Cohesion: 0.08
Nodes (1): VpnTileService

### Community 34 - "Background Power Manager.kt / Background Power Manager"
Cohesion: 0.08
Nodes (3): BackgroundPowerManager, Callbacks, PowerMode

### Community 35 - "Network Switch Manager.kt / .get Connectivity Manager()"
Cohesion: 0.08
Nodes (4): Callbacks, HealthCheckRecoveryDecision, NetworkSwitchManager, NetworkType

### Community 36 - "Selector Manager.kt / Failed"
Cohesion: 0.09
Nodes (5): Failed, NeedRestart, SelectorManager, Success, SwitchResult

### Community 37 - "Connect Manager.kt / Connect Manager"
Cohesion: 0.09
Nodes (2): ConnectManager, NetworkState

### Community 38 - "App Update Checker.kt / App Update Checker"
Cohesion: 0.09
Nodes (7): AppUpdateChecker, Error, GitHubRelease, ReleaseAsset, UpdateAvailable, UpdateCheckResult, UpToDate

### Community 39 - "Precise Latency Tester.kt / Latency Result"
Cohesion: 0.09
Nodes (4): LatencyResult, PreciseLatencyTester, Standard, TimingEventListener

### Community 40 - "Diagnostics View Model.kt / Diagnostics View Model"
Cohesion: 0.09
Nodes (2): DiagnosticsViewModel, MatchResult

### Community 41 - "Log Repository.kt / get Instance()"
Cohesion: 0.1
Nodes (1): LogRepository

### Community 42 - "Outbound Fixer.kt / Outbound Fixer"
Cohesion: 0.1
Nodes (1): OutboundFixer

### Community 43 - "Vpn Tun Manager.kt / Vpn Tun Manager"
Cohesion: 0.1
Nodes (1): VpnTunManager

### Community 44 - "Default Network Listener.kt / Callback"
Cohesion: 0.1
Nodes (10): Callback, DefaultNetworkListener, Get, Lost, NetworkMessage, Put, Reset, Start (+2 more)

### Community 45 - "Probe Manager.kt / Batch Probe Result"
Cohesion: 0.1
Nodes (8): BatchProbeResult, Error, ProbeManager, ProbeResult, ProbeTarget, QuickProbeResult, Success, Timeout

### Community 46 - "Diagnostics Node Line Query.kt / append Exit Portrait Section()"
Cohesion: 0.1
Nodes (5): DiagnosticsNodeLineQueryRunner, IpSbGeoIpResponse, NodeExitPortrait, NodeLineQueryData, NodeLineTarget

### Community 47 - "Ui Models.kt / Batch Update Result"
Cohesion: 0.11
Nodes (17): BatchUpdateResult, ConnectionState, ConnectionStats, Failed, LogEntryUi, LogLevel, NodeUi, ProfileType (+9 more)

### Community 48 - "Dns Resolve Store.kt / Dns Resolve Store"
Cohesion: 0.11
Nodes (3): DnsResolveStore, ResolvedEntry, Stats

### Community 49 - "Data Export Repository.kt / Data Export Repository"
Cohesion: 0.11
Nodes (1): DataExportRepository

### Community 50 - "Rule Set Repository.kt / get Instance()"
Cohesion: 0.11
Nodes (1): RuleSetRepository

### Community 51 - "Node Auto Failover Policy.kt / Budget State"
Cohesion: 0.11
Nodes (6): BudgetState, NodeAutoFailoverPolicy, ProbeEvaluation, ProbeOutcome, QuarantinedNode, TriggerContext

### Community 52 - "Traffic Monitor.kt / Listener"
Cohesion: 0.11
Nodes (3): Listener, TrafficMonitor, TrafficSnapshot

### Community 53 - "State Cache.kt / Network Cache"
Cohesion: 0.11
Nodes (4): NetworkCache, SettingsCache, StateCache, VpnStateCache

### Community 54 - "Nodes View Model.kt / Nodes View Model"
Cohesion: 0.11
Nodes (1): NodesViewModel

### Community 55 - "Vpn Connection Manager.kt / Permission Callback"
Cohesion: 0.11
Nodes (2): PermissionCallback, VpnConnectionManager

### Community 56 - "Config Repository Entry Regression Test.kt / Config Repository Entry Regression Test"
Cohesion: 0.12
Nodes (1): ConfigRepositoryEntryRegressionTest

### Community 57 - "Subscription Parser.kt / Cache Entry"
Cohesion: 0.12
Nodes (4): CacheEntry, DnsResolveCache, SubscriptionManager, SubscriptionParser

### Community 58 - "Profiles View Model.kt / Error"
Cohesion: 0.12
Nodes (6): Error, Idle, ImportState, Loading, ProfilesViewModel, Success

### Community 59 - "Vpn Notification Manager.kt / Notification State"
Cohesion: 0.12
Nodes (2): NotificationState, VpnNotificationManager

### Community 60 - "Structured Logger.kt / Category"
Cohesion: 0.12
Nodes (2): Category, L

### Community 61 - "Node Link Exporter.kt / Node Link Exporter"
Cohesion: 0.13
Nodes (1): NodeLinkExporter

### Community 62 - "Screen State Manager.kt / .notify Remote State Update()"
Cohesion: 0.13
Nodes (2): Callbacks, ScreenStateManager

### Community 63 - "Service State Holder.kt / Connection Owner Stats Snapshot"
Cohesion: 0.13
Nodes (2): ConnectionOwnerStatsSnapshot, ServiceStateHolder

### Community 64 - "Kernel Http Client.kt / error()"
Cohesion: 0.13
Nodes (2): HttpResult, KernelHttpClient

### Community 65 - "Common Parsers.kt / Base64 Parser"
Cohesion: 0.13
Nodes (2): Base64Parser, SingBoxParser

### Community 66 - "Sing Box Ipc Service.kt / get Active Label()"
Cohesion: 0.14
Nodes (1): SingBoxIpcService

### Community 67 - "Settings.kt / App Language"
Cohesion: 0.14
Nodes (13): AppLanguage, AppSettings, AppThemeMode, BackgroundPowerSavingDelay, DefaultRule, DnsStrategy, GhProxyMirror, LatencyTestMethod (+5 more)

### Community 68 - "Profile Persistence.kt / get Instance()"
Cohesion: 0.14
Nodes (2): LoadResult, ProfilePersistence

### Community 69 - "Network Manager.kt / Listener"
Cohesion: 0.14
Nodes (2): Listener, NetworkManager

### Community 70 - "Network Client.kt / Network Client"
Cohesion: 0.14
Nodes (2): NetworkClient, PoolStatus

### Community 71 - "Dns Resolver.kt / create Default Client()"
Cohesion: 0.14
Nodes (2): DnsResolver, DnsResolveResult

### Community 72 - "Dns Prewarmer.kt / Dns Prewarmer"
Cohesion: 0.14
Nodes (3): DnsPrewarmer, PrewarmResult, ResolveResult

### Community 73 - "Settings Store.kt / get Instance()"
Cohesion: 0.15
Nodes (1): SettingsStore

### Community 74 - "Node Switch Manager.kt / .get Config Path()"
Cohesion: 0.15
Nodes (2): Callbacks, NodeSwitchManager

### Community 75 - "Qr Scanner Activity.kt / create Intent()"
Cohesion: 0.15
Nodes (1): QrScannerActivity

### Community 76 - "Perf Tracer.kt / Perf Tracer"
Cohesion: 0.15
Nodes (4): PerfTracer, Phases, TraceInfo, TraceStats

### Community 77 - "Outbound Fixer Test.kt / Outbound Fixer Test"
Cohesion: 0.15
Nodes (1): OutboundFixerTest

### Community 78 - "Node Auto Failover Policy Test.kt / Node Auto Failover Policy Test"
Cohesion: 0.15
Nodes (1): NodeAutoFailoverPolicyTest

### Community 79 - "Clash Config Parser Test.kt / Clash Config Parser"
Cohesion: 0.15
Nodes (2): ClashConfigParser, ClashConfigParserTest

### Community 80 - "Node Latency Dao.kt / Node Latency Dao"
Cohesion: 0.17
Nodes (1): NodeLatencyDao

### Community 81 - "Vpn Service Manager.kt / Vpn Service Manager"
Cohesion: 0.17
Nodes (1): VpnServiceManager

### Community 82 - "Installed Apps Repository.kt / Error"
Cohesion: 0.17
Nodes (6): Error, Idle, InstalledAppsRepository, Loaded, Loading, LoadingState

### Community 83 - "Network Helper.kt / Network Helper"
Cohesion: 0.17
Nodes (1): NetworkHelper

### Community 84 - "Traffic Stats Screen.kt / Chart Legend Item()"
Cohesion: 0.17
Nodes (0): 

### Community 85 - "Safe Latency Tester.kt / get Instance()"
Cohesion: 0.18
Nodes (1): SafeLatencyTester

### Community 86 - "App Database.kt / App Database"
Cohesion: 0.18
Nodes (1): AppDatabase

### Community 87 - "Routing Models.kt / App Group"
Cohesion: 0.18
Nodes (10): AppGroup, AppInfo, AppRule, CustomRule, InstalledApp, OutboundTag, RuleSet, RuleSetOutboundMode (+2 more)

### Community 88 - "Fake Repository.kt / Fake Repository"
Cohesion: 0.18
Nodes (1): FakeRepository

### Community 89 - "App Routing Components.kt / App Group Card()"
Cohesion: 0.18
Nodes (0): 

### Community 90 - "Sing Box Remote State Test.kt / Sing Box Remote State Test"
Cohesion: 0.18
Nodes (1): SingBoxRemoteStateTest

### Community 91 - "Dns Resolver Test.kt / Dns Resolver Test"
Cohesion: 0.18
Nodes (1): DnsResolverTest

### Community 92 - "Active State Dao.kt / Active State Dao"
Cohesion: 0.2
Nodes (1): ActiveStateDao

### Community 93 - "Settings Dao.kt / Settings Dao"
Cohesion: 0.2
Nodes (1): SettingsDao

### Community 94 - "Common Dialogs.kt / About Dialog()"
Cohesion: 0.2
Nodes (0): 

### Community 95 - "Export Data.kt / Export Data"
Cohesion: 0.22
Nodes (8): ExportData, ExportDataSummary, Failed, ImportOptions, ImportResult, PartialSuccess, ProfileExportData, Success

### Community 96 - "Latency Cache.kt / Latency Cache"
Cohesion: 0.22
Nodes (1): LatencyCache

### Community 97 - "Subscription Fetcher.kt / Fetch Result"
Cohesion: 0.22
Nodes (3): FetchResult, SubscriptionFetcher, SubscriptionUserInfo

### Community 98 - "Foreign Vpn Monitor.kt / Foreign Vpn Monitor"
Cohesion: 0.22
Nodes (2): Callbacks, ForeignVpnMonitor

### Community 99 - "App Logger.kt / App Logger"
Cohesion: 0.22
Nodes (2): AppLogger, Level

### Community 100 - "Url Test Tag Matcher Test.kt / Url Test Tag Matcher Test"
Cohesion: 0.22
Nodes (1): UrlTestTagMatcherTest

### Community 101 - "App Lifecycle Observer.kt / App Lifecycle Observer"
Cohesion: 0.25
Nodes (1): AppLifecycleObserver

### Community 102 - "Url Test Tag Matcher.kt / Resolve Detail"
Cohesion: 0.25
Nodes (2): ResolveDetail, UrlTestTagMatcher

### Community 103 - "Profiles Screen.kt / Import Loading Dialog()"
Cohesion: 0.25
Nodes (1): ProfileImportType

### Community 104 - "Traffic Stats View Model.kt / Traffic Stats Ui State"
Cohesion: 0.25
Nodes (2): TrafficStatsUiState, TrafficStatsViewModel

### Community 105 - "Latency Tester.kt / Latency Tester"
Cohesion: 0.29
Nodes (1): LatencyTester

### Community 106 - "Subscription Auto Update Worker.kt / cancel()"
Cohesion: 0.29
Nodes (1): SubscriptionAutoUpdateWorker

### Community 107 - "Vpn Keepalive Worker.kt / cancel()"
Cohesion: 0.29
Nodes (1): VpnKeepaliveWorker

### Community 108 - "Square View Finder View.kt / Square View Finder View"
Cohesion: 0.29
Nodes (1): SquareViewFinderView

### Community 109 - "Node Detail Screen.kt / create Empty Outbound()"
Cohesion: 0.29
Nodes (0): 

### Community 110 - "Battery Optimization Helper.kt / Battery Optimization Helper"
Cohesion: 0.29
Nodes (1): BatteryOptimizationHelper

### Community 111 - "Locale Helper.kt / Locale Helper"
Cohesion: 0.29
Nodes (1): LocaleHelper

### Community 112 - "Security Utils.kt / Security Utils"
Cohesion: 0.29
Nodes (1): SecurityUtils

### Community 113 - "Platform Interface Impl Test.kt / Platform Interface Impl Test"
Cohesion: 0.29
Nodes (1): PlatformInterfaceImplTest

### Community 114 - "Dns Resolve Store Test.kt / Dns Resolve Store Test"
Cohesion: 0.29
Nodes (1): DnsResolveStoreTest

### Community 115 - "Diagnostics View Model Node Line Test.kt / Diagnostics View Model Node Line Test"
Cohesion: 0.29
Nodes (1): DiagnosticsViewModelNodeLineTest

### Community 116 - "Main Activity.kt / Main Activity"
Cohesion: 0.33
Nodes (1): MainActivity

### Community 117 - "Sing Box Application.kt / Sing Box Application"
Cohesion: 0.33
Nodes (1): SingBoxApplication

### Community 118 - "Converters.kt / Converters"
Cohesion: 0.33
Nodes (1): Converters

### Community 119 - "Node Entity.kt / from Ui Model()"
Cohesion: 0.33
Nodes (1): NodeEntity

### Community 120 - "Node Extractor.kt / Node Extractor"
Cohesion: 0.33
Nodes (1): NodeExtractor

### Community 121 - "Rule Set Auto Update Worker.kt / cancel()"
Cohesion: 0.33
Nodes (1): RuleSetAutoUpdateWorker

### Community 122 - "Export Import Dialogs.kt / Export Progress Dialog()"
Cohesion: 0.33
Nodes (0): 

### Community 123 - "Version Info.kt / Version Info"
Cohesion: 0.33
Nodes (1): VersionInfo

### Community 124 - "Log View Model.kt / Log View Model"
Cohesion: 0.33
Nodes (1): LogViewModel

### Community 125 - "Ping Display Text Test.kt / Ping Display Text Test"
Cohesion: 0.33
Nodes (1): PingDisplayTextTest

### Community 126 - "Settings Store Test.kt / Settings Store Test"
Cohesion: 0.33
Nodes (1): SettingsStoreTest

### Community 127 - "build.gradle.kts / detect Libbox Abis()"
Cohesion: 0.4
Nodes (0): 

### Community 128 - "Libbox Native Support.kt / Libbox Native Support"
Cohesion: 0.4
Nodes (1): LibboxNativeSupport

### Community 129 - "Local Resolver Impl.kt / Local Resolver Impl"
Cohesion: 0.4
Nodes (1): LocalResolverImpl

### Community 130 - "Add Node Dialog.kt / Add Node Dialog()"
Cohesion: 0.4
Nodes (3): AddNodeTarget, ExistingProfile, NewProfile

### Community 131 - "Select Profile Dialog.kt / Existing Profile"
Cohesion: 0.4
Nodes (3): ExistingProfile, NewProfile, SelectProfileTarget

### Community 132 - "Domain Rules Screen.kt / Domain Rule Editor Dialog()"
Cohesion: 0.4
Nodes (0): 

### Community 133 - "Rule Sets Screen.kt / Default Rule Set Progress Dialog()"
Cohesion: 0.4
Nodes (0): 

### Community 134 - "Deep Link Handler.kt / Deep Link Handler"
Cohesion: 0.4
Nodes (2): DeepLinkHandler, SubscriptionImportData

### Community 135 - "String Builder Pool.kt / String Builder Pool"
Cohesion: 0.4
Nodes (1): StringBuilderPool

### Community 136 - "Installed Apps View Model.kt / Installed Apps View Model"
Cohesion: 0.4
Nodes (1): InstalledAppsViewModel

### Community 137 - "Box Wrapper Manager Recovery Policy Test.kt / Box Wrapper Manager Recovery Policy Test"
Cohesion: 0.4
Nodes (1): BoxWrapperManagerRecoveryPolicyTest

### Community 138 - "Vpn State Store Test.kt / Vpn State Store Test"
Cohesion: 0.4
Nodes (1): VpnStateStoreTest

### Community 139 - "Latency Probe Policy Test.kt / Latency Probe Policy Test"
Cohesion: 0.4
Nodes (1): LatencyProbePolicyTest

### Community 140 - "Network Switch Manager Test.kt / Network Switch Manager Test"
Cohesion: 0.4
Nodes (1): NetworkSwitchManagerTest

### Community 141 - "Startup Manager Test.kt / Startup Manager Test"
Cohesion: 0.4
Nodes (1): StartupManagerTest

### Community 142 - "Profile Entity.kt / from Ui Model()"
Cohesion: 0.5
Nodes (1): ProfileEntity

### Community 143 - "Github File.kt / Github File"
Cohesion: 0.5
Nodes (3): GithubFile, GithubTreeItem, GithubTreeResponse

### Community 144 - "Editable Setting Item.kt / Editable Multiline Text Item()"
Cohesion: 0.5
Nodes (0): 

### Community 145 - "App Routing Screen.kt / App Routing Screen()"
Cohesion: 0.5
Nodes (0): 

### Community 146 - "Custom Rules Screen.kt / Custom Rule Editor Dialog()"
Cohesion: 0.5
Nodes (0): 

### Community 147 - "Node Display Settings.kt / clear Instance()"
Cohesion: 0.5
Nodes (1): NodeDisplaySettings

### Community 148 - "Safe Latency Tester Test.kt / Safe Latency Tester Test"
Cohesion: 0.5
Nodes (1): SafeLatencyTesterTest

### Community 149 - "Model Serialization Test.kt / Model Serialization Test"
Cohesion: 0.5
Nodes (1): ModelSerializationTest

### Community 150 - "Inbound Builder Test.kt / Inbound Builder Test"
Cohesion: 0.5
Nodes (1): InboundBuilderTest

### Community 151 - "Node Link Exporter Test.kt / Node Link Exporter Test"
Cohesion: 0.5
Nodes (1): NodeLinkExporterTest

### Community 152 - "Node Filter.kt / Filter Mode"
Cohesion: 0.67
Nodes (2): FilterMode, NodeFilter

### Community 153 - "Ping Display Text.kt / Ping Display Text"
Cohesion: 0.67
Nodes (1): PingDisplayText

### Community 154 - "Latency Probe Policy.kt / Latency Probe Policy"
Cohesion: 0.67
Nodes (1): LatencyProbePolicy

### Community 155 - "Inbound Builder.kt / Inbound Builder"
Cohesion: 0.67
Nodes (1): InboundBuilder

### Community 156 - "Shortcut Activity.kt / Shortcut Activity"
Cohesion: 0.67
Nodes (1): ShortcutActivity

### Community 157 - "App List Loading Dialog.kt / App List Loading Dialog()"
Cohesion: 0.67
Nodes (0): 

### Community 158 - "App Notification Manager.kt / App Notification Manager"
Cohesion: 0.67
Nodes (1): AppNotificationManager

### Community 159 - "Clickable Dropdown Field.kt / Clickable Dropdown Field()"
Cohesion: 0.67
Nodes (0): 

### Community 160 - "Info Card.kt / Info Card()"
Cohesion: 0.67
Nodes (0): 

### Community 161 - "Setting Item.kt / Setting Item()"
Cohesion: 0.67
Nodes (0): 

### Community 162 - "Status Chip.kt / Mode Chip()"
Cohesion: 0.67
Nodes (0): 

### Community 163 - "App Rules Screen.kt / App Rules Screen()"
Cohesion: 0.67
Nodes (0): 

### Community 164 - "Dashboard Screen.kt / Dashboard Screen()"
Cohesion: 0.67
Nodes (0): 

### Community 165 - "Nodes Screen.kt / Node Search Bar()"
Cohesion: 0.67
Nodes (0): 

### Community 166 - "Rule Set Hub Screen.kt / Hub Rule Set Item()"
Cohesion: 0.67
Nodes (0): 

### Community 167 - "Settings Screen.kt / Settings Group Title()"
Cohesion: 0.67
Nodes (0): 

### Community 168 - "Proxy Aware Ok Http Client.kt / Proxy Aware Ok Http Client"
Cohesion: 0.67
Nodes (1): ProxyAwareOkHttpClient

### Community 169 - "Tcp Ping.kt / Tcp Ping"
Cohesion: 0.67
Nodes (1): TcpPing

### Community 170 - "Rule Set Update Worker.kt / Rule Set Update Worker"
Cohesion: 0.67
Nodes (1): RuleSetUpdateWorker

### Community 171 - "V Mess Clash Test.kt / V Mess Clash Test"
Cohesion: 0.67
Nodes (1): VMessClashTest

### Community 172 - "Active State Entity.kt / Active State Entity"
Cohesion: 1.0
Nodes (1): ActiveStateEntity

### Community 173 - "Node Latency Entity.kt / Node Latency Entity"
Cohesion: 1.0
Nodes (1): NodeLatencyEntity

### Community 174 - "Settings Entity.kt / Settings Entity"
Cohesion: 1.0
Nodes (1): SettingsEntity

### Community 175 - "Hub Rule Set.kt / Hub Rule Set"
Cohesion: 1.0
Nodes (1): HubRuleSet

### Community 176 - "Node Sort Type.kt / Node Sort Type"
Cohesion: 1.0
Nodes (1): NodeSortType

### Community 177 - "Ping Result Code.kt / Ping Result Code"
Cohesion: 1.0
Nodes (1): PingResultCode

### Community 178 - "App Nav Bar.kt / App Nav Bar()"
Cohesion: 1.0
Nodes (0): 

### Community 179 - "Big Toggle.kt / Big Toggle()"
Cohesion: 1.0
Nodes (0): 

### Community 180 - "Node Card.kt / Node Card()"
Cohesion: 1.0
Nodes (0): 

### Community 181 - "Profile Card.kt / Profile Card()"
Cohesion: 1.0
Nodes (0): 

### Community 182 - "Standard Card.kt / Standard Card()"
Cohesion: 1.0
Nodes (0): 

### Community 183 - "App Groups Screen.kt / App Groups Screen()"
Cohesion: 1.0
Nodes (0): 

### Community 184 - "Connection Settings Screen.kt / Connection Settings Screen()"
Cohesion: 1.0
Nodes (0): 

### Community 185 - "Diagnostics Screen.kt / Diagnostics Screen()"
Cohesion: 1.0
Nodes (0): 

### Community 186 - "Dns Settings Screen.kt / Dns Settings Screen()"
Cohesion: 1.0
Nodes (0): 

### Community 187 - "Logs Screen.kt / Logs Screen()"
Cohesion: 1.0
Nodes (0): 

### Community 188 - "Profile Editor Screen.kt / Profile Editor Screen()"
Cohesion: 1.0
Nodes (0): 

### Community 189 - "Routing Settings Screen.kt / Routing Settings Screen()"
Cohesion: 1.0
Nodes (0): 

### Community 190 - "Splash Screen.kt / Splash Screen()"
Cohesion: 1.0
Nodes (0): 

### Community 191 - "Tun Settings Screen.kt / Tun Settings Screen()"
Cohesion: 1.0
Nodes (0): 

### Community 192 - "Theme.kt / Sing Box Theme()"
Cohesion: 1.0
Nodes (0): 

### Community 193 - "Color.kt"
Cohesion: 1.0
Nodes (0): 

### Community 194 - "Type.kt"
Cohesion: 1.0
Nodes (0): 

### Community 195 - "Sing Box Application"
Cohesion: 1.0
Nodes (1): SingBoxApplication

## Knowledge Gaps
- **269 isolated node(s):** `RecoveryMode`, `RecoveryLevel`, `SmartRecoveryResult`, `ProbeTarget`, `ProbeResult` (+264 more)
  These have ≤1 connection - possible missing edges or undocumented components.
- **Thin community `Active State Entity.kt / Active State Entity`** (2 nodes): `ActiveStateEntity.kt`, `ActiveStateEntity`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `Node Latency Entity.kt / Node Latency Entity`** (2 nodes): `NodeLatencyEntity.kt`, `NodeLatencyEntity`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `Settings Entity.kt / Settings Entity`** (2 nodes): `SettingsEntity.kt`, `SettingsEntity`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `Hub Rule Set.kt / Hub Rule Set`** (2 nodes): `HubRuleSet.kt`, `HubRuleSet`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `Node Sort Type.kt / Node Sort Type`** (2 nodes): `NodeSortType.kt`, `NodeSortType`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `Ping Result Code.kt / Ping Result Code`** (2 nodes): `PingResultCode.kt`, `PingResultCode`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `App Nav Bar.kt / App Nav Bar()`** (2 nodes): `AppNavBar.kt`, `AppNavBar()`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `Big Toggle.kt / Big Toggle()`** (2 nodes): `BigToggle.kt`, `BigToggle()`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `Node Card.kt / Node Card()`** (2 nodes): `NodeCard.kt`, `NodeCard()`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `Profile Card.kt / Profile Card()`** (2 nodes): `ProfileCard.kt`, `ProfileCard()`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `Standard Card.kt / Standard Card()`** (2 nodes): `StandardCard.kt`, `StandardCard()`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `App Groups Screen.kt / App Groups Screen()`** (2 nodes): `AppGroupsScreen.kt`, `AppGroupsScreen()`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `Connection Settings Screen.kt / Connection Settings Screen()`** (2 nodes): `ConnectionSettingsScreen.kt`, `ConnectionSettingsScreen()`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `Diagnostics Screen.kt / Diagnostics Screen()`** (2 nodes): `DiagnosticsScreen.kt`, `DiagnosticsScreen()`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `Dns Settings Screen.kt / Dns Settings Screen()`** (2 nodes): `DnsSettingsScreen.kt`, `DnsSettingsScreen()`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `Logs Screen.kt / Logs Screen()`** (2 nodes): `LogsScreen.kt`, `LogsScreen()`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `Profile Editor Screen.kt / Profile Editor Screen()`** (2 nodes): `ProfileEditorScreen.kt`, `ProfileEditorScreen()`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `Routing Settings Screen.kt / Routing Settings Screen()`** (2 nodes): `RoutingSettingsScreen.kt`, `RoutingSettingsScreen()`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `Splash Screen.kt / Splash Screen()`** (2 nodes): `SplashScreen.kt`, `SplashScreen()`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `Tun Settings Screen.kt / Tun Settings Screen()`** (2 nodes): `TunSettingsScreen.kt`, `TunSettingsScreen()`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `Theme.kt / Sing Box Theme()`** (2 nodes): `Theme.kt`, `SingBoxTheme()`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `Color.kt`** (1 nodes): `Color.kt`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `Type.kt`** (1 nodes): `Type.kt`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `Sing Box Application`** (1 nodes): `SingBoxApplication`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.

## Suggested Questions
_Questions this graph is uniquely positioned to answer:_

- **Why does `ConfigRepository` connect `Config Repository / .add Single Node()` to `Config Repository.kt / apply Selector Safe Outbounds For Test()`?**
  _High betweenness centrality (0.004) - this node is a cross-community bridge._
- **Why does `SingBoxService` connect `Sing Box Service / .build Network Type Changed State Skip()` to `Sing Box Service.kt / cache Uid To Package()`?**
  _High betweenness centrality (0.002) - this node is a cross-community bridge._
- **What connects `RecoveryMode`, `RecoveryLevel`, `SmartRecoveryResult` to the rest of the system?**
  _269 weakly-connected nodes found - possible documentation gaps or missing edges._
- **Should `Config Repository / .add Single Node()` be split into smaller, more focused modules?**
  _Cohesion score 0.01 - nodes in this community are weakly interconnected._
- **Should `Sing Box Service.kt / cache Uid To Package()` be split into smaller, more focused modules?**
  _Cohesion score 0.02 - nodes in this community are weakly interconnected._
- **Should `Settings View Model.kt / Default Rule Set Download State` be split into smaller, more focused modules?**
  _Cohesion score 0.02 - nodes in this community are weakly interconnected._
- **Should `Config Repository Test.kt / Config Repository Test` be split into smaller, more focused modules?**
  _Cohesion score 0.02 - nodes in this community are weakly interconnected._