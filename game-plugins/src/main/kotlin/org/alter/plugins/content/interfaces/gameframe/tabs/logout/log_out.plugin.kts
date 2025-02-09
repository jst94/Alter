package org.alter.plugins.content.interfaces.gameframe.tabs.logout

import net.rsprot.protocol.game.outgoing.logout.Logout
import org.alter.game.model.timer.ACTIVE_COMBAT_TIMER

/**
 * Logout button.
 */
onButton(interfaceId = 182, component = 8) {
    if (!player.timers.has(ACTIVE_COMBAT_TIMER)) {
        player.requestLogout()
        player.write(Logout)
        player.session?.requestClose()
        player.channelFlush()
    } else {
        player.message("You can't log out until 10 seconds after the end of combat.")
    }
}
