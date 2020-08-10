package cf.zihad.spigotlin

import org.bukkit.plugin.java.JavaPlugin

/**
 * An example Spigot plugin written in Kotlin that includes docs with Dokka.
 * @author Zihad
 */
@Suppress("UNUSED")
class Spigotlin : JavaPlugin() {
    /**
     * The function that's called when the plugin is enabled by the server.
     */
    override fun onEnable() {
        logger.info("Enabled $NAME v$VERSION!")
    }

    /**
     * The function that's called when the plugin is disabled by the server.
     */
    override fun onDisable() {
        logger.info("Disabled $NAME  v$VERSION!")
    }

    companion object {
        /**
         * The name of the plugin.
         */
        const val NAME = "Spigotlin"

        /**
         * The version of the plugin.
         */
        const val VERSION = "1.0"
    }
}
