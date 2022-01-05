package com.karumi.kotlinsnapshot.core

internal class SystemSnapshottingProperties : SnapshottingProperties {
    override fun isSnapshotPurgingEnabled(): Boolean = isConfigured("purgeSnapshots")

    override fun shouldUpdateSnapshots(): Boolean = isConfigured("updateSnapshots")

    override fun shouldFailOnMissingSnapshots(): Boolean = isConfigured("failOnMissingSnapshots")

    private fun isConfigured(configName: String) = System.getenv(configName) == "1" ||
        System.getProperty(configName) == "1"
}
