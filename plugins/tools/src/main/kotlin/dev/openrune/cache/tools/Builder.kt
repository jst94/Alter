package dev.openrune.cache.tools

import dev.openrune.RSCMHandler
import dev.openrune.cache.tools.tasks.CacheTask
import dev.openrune.cache.tools.tasks.TaskType
import java.io.File
import java.nio.file.Path

val DEFAULT_PATH = Path.of("data", "cache").toFile()

data class Builder(
    var type: TaskType,
    var revision: Int,
    var cacheLocation : File = DEFAULT_PATH,
    var extraTasks: Array<CacheTask> = emptyArray(),
    var js5Ports: List<Int> = listOf(443, 43594, 50000),
    var supportPrefetch: Boolean = true
) {

    fun extraTasks(vararg types: CacheTask) = apply { this.extraTasks = types.toMutableList().toTypedArray() }

    fun registerRSCM(mappingsDir: File) = apply {
        RSCMHandler.load(mappingsDir)
    }

    fun cacheLocation(cacheLocation: File) = apply { this.cacheLocation = cacheLocation }

    fun js5Ports(ports: List<Int>) = apply { this.js5Ports = ports }

    fun supportPrefetch(state: Boolean) = apply { this.supportPrefetch = state }

    fun build() = CacheTool(this)
}