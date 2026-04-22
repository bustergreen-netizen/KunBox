package com.kunk.singbox.ipc

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class SingBoxIpcHubStateTest {

    @Test
    fun `binder death preserves terminal error only for manually stopped state`() {
        assertTrue(
            SingBoxIpcHub.shouldPreserveLastErrorOnBinderDied(
                lastError = "VPN revoked by system (another VPN may have started)",
                manuallyStopped = true
            )
        )
        assertFalse(
            SingBoxIpcHub.shouldPreserveLastErrorOnBinderDied(
                lastError = "",
                manuallyStopped = true
            )
        )
        assertFalse(
            SingBoxIpcHub.shouldPreserveLastErrorOnBinderDied(
                lastError = "temporary failure",
                manuallyStopped = false
            )
        )
    }
}
