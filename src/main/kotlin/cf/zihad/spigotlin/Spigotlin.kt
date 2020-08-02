package cf.zihad.spigotlin

import org.bukkit.plugin.java.JavaPlugin

@Suppress("UNUSED")
class Spigotlin : JavaPlugin() {
    override fun onEnable() {
        logger.info("Enabled $NAME v$VERSION!")
    }

    override fun onDisable() {
        logger.info("Disabled $NAME=rf  v$VERSION!")
    }

    companion object {
        const val NAME = "Spigotlin"
        const val VERSION = "1.0"
    }
}
