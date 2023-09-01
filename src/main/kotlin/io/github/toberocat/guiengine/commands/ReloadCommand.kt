package io.github.toberocat.guiengine.commands

import io.github.toberocat.guiengine.GuiEngineApi
import io.github.toberocat.guiengine.GuiEngineApiPlugin.Companion.plugin
import io.github.toberocat.guiengine.exception.GuiIORuntimeException
import io.github.toberocat.toberocore.command.SubCommand
import io.github.toberocat.toberocore.command.arguments.Argument
import io.github.toberocat.toberocore.command.exceptions.CommandException
import io.github.toberocat.toberocore.command.options.Options
import org.bukkit.command.CommandSender

class ReloadCommand : SubCommand("reload") {
    override fun options(): Options = Options()

    override fun arguments(): Array<Argument<*>> = emptyArray()

    @Throws(CommandException::class)
    override fun handleCommand(sender: CommandSender, strings: Array<String>): Boolean {
        try {
            plugin.reloadConfig()
            for (api in GuiEngineApi.APIS.values) api.reload()
            sender.sendMessage("§aReloaded GUI APIs.")
        } catch (e: GuiIORuntimeException) {
            sender.sendMessage(e.message)
        }
        return true
    }
}
