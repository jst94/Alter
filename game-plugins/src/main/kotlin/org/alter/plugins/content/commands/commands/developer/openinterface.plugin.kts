package org.alter.plugins.content.commands.commands.developer

import org.alter.game.model.priv.Privilege

onCommand("openinterface", Privilege.DEV_POWER, description = "Open interface by id") {
    val values = player.getCommandArgs()
    val component = values[0].toInt()
    val parent = values[1].toIntOrNull() ?: getDisplayComponentId(player.interfaces.displayMode)
    val child = values[2].toInt()
    var clickable = values[3].toIntOrNull() ?: 0
    clickable = if (clickable != 1) 0 else 1
    val modal = values[4].toIntOrNull() ?: 1 == 1
    player.openInterface(parent, child, component, clickable, isModal = modal)
    player.message("Opening interface <col=801700>$component</col> on <col=0000ff>$parent:$child</col>")
}
