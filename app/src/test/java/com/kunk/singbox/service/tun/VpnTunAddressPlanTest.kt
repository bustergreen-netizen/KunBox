package com.kunk.singbox.service.tun

import com.kunk.singbox.model.AppSettings
import com.kunk.singbox.model.IpVersionMode
import org.junit.Assert.assertEquals

class VpnTunAddressPlanTest {

    @org.junit.Test
    fun plannerUsesOnlyIpv4WhenIpv4Only() {
        val plan = VpnTunAddressPlanner.build(IpVersionMode.IPV4_ONLY)

        assertEquals(listOf("172.19.0.1" to 30), plan.addresses)
        assertEquals(listOf("0.0.0.0" to 0), plan.globalRoutes)
        assertEquals(listOf("223.5.5.5", "119.29.29.29", "1.1.1.1"), plan.defaultDnsServers)
    }

    @org.junit.Test
    fun plannerUsesDualStackWhenDualStack() {
        val plan = VpnTunAddressPlanner.build(IpVersionMode.DUAL_STACK)

        assertEquals(listOf("172.19.0.1" to 30, "fd00::1" to 126), plan.addresses)
        assertEquals(listOf("0.0.0.0" to 0, "::" to 0), plan.globalRoutes)
        assertEquals(listOf("223.5.5.5", "119.29.29.29", "1.1.1.1", "2606:4700:4700::1111"), plan.defaultDnsServers)
    }

    @org.junit.Test
    fun plannerUsesOnlyIpv6WhenIpv6Only() {
        val plan = VpnTunAddressPlanner.build(IpVersionMode.IPV6_ONLY)

        assertEquals(listOf("fd00::1" to 126), plan.addresses)
        assertEquals(listOf("::" to 0), plan.globalRoutes)
        assertEquals(listOf("2606:4700:4700::1111"), plan.defaultDnsServers)
    }

    @org.junit.Test
    fun vpnDnsResolverUsesTunDnsServerAddressFromLibboxWhenPresent() {
        val settings = AppSettings(
            localDns = "https://dns.alidns.com/dns-query",
            remoteDns = "https://1.1.1.1/dns-query"
        )

        val dnsServers = VpnTunManager.resolveVpnDnsServersForTest(
            settings = settings,
            dnsServerAddress = "1.1.1.1"
        )

        assertEquals(listOf("1.1.1.1"), dnsServers)
    }

    @org.junit.Test
    fun vpnDnsResolverIgnoresDohUrlsAndDoesNotFallbackToHardcodedServers() {
        val settings = AppSettings(
            localDns = "https://dns.alidns.com/dns-query",
            remoteDns = "https://1.1.1.1/dns-query"
        )

        val dnsServers = VpnTunManager.resolveVpnDnsServersForTest(
            settings = settings,
            dnsServerAddress = null,
            tunPlan = VpnTunAddressPlanner.build(IpVersionMode.DUAL_STACK)
        )

        assertEquals(listOf("172.19.0.1", "fd00::1"), dnsServers)
    }

    @org.junit.Test
    fun vpnDnsResolverKeepsExplicitNumericDnsServers() {
        val settings = AppSettings(
            localDns = "223.5.5.5",
            remoteDns = "1.1.1.1"
        )

        val dnsServers = VpnTunManager.resolveVpnDnsServersForTest(
            settings = settings,
            dnsServerAddress = null,
            tunPlan = VpnTunAddressPlanner.build(IpVersionMode.DUAL_STACK)
        )

        assertEquals(listOf("1.1.1.1", "223.5.5.5"), dnsServers)
    }

    @org.junit.Test
    fun vpnDnsResolverFallsBackToTunAddressesWhenNoNumericDnsAvailable() {
        val settings = AppSettings(
            localDns = "https://dns.alidns.com/dns-query",
            remoteDns = "https://1.1.1.1/dns-query",
            ipVersionMode = IpVersionMode.DUAL_STACK
        )

        val dnsServers = VpnTunManager.resolveVpnDnsServersForTest(
            settings = settings,
            dnsServerAddress = null,
            tunPlan = VpnTunAddressPlanner.build(IpVersionMode.DUAL_STACK)
        )

        assertEquals(listOf("172.19.0.1", "fd00::1"), dnsServers)
    }

    @org.junit.Test
    fun httpProxyIsNotAppendedWhenTunModeIsEnabled() {
        val settings = AppSettings(
            tunEnabled = true,
            proxyPort = 2080,
            appendHttpProxy = true
        )

        assertEquals(false, VpnTunManager.shouldAppendHttpProxy(settings))
    }

    @org.junit.Test
    fun httpProxyCanBeAppendedOnlyOutsideTunMode() {
        val settings = AppSettings(
            tunEnabled = false,
            proxyPort = 2080,
            appendHttpProxy = true
        )

        assertEquals(true, VpnTunManager.shouldAppendHttpProxy(settings))
    }
}
