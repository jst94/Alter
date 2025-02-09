import org.alter.game.model.priv.Privilege

/**
 * @author Fritz <frikkipafi@gmail.com>
 */

onCommand("broadcast", Privilege.ADMIN_POWER, description = "Broadcast for everyone") {
    val args = player.getCommandArgs()
    val text = args[0]
    player.world.players.forEach {
        it.message("$text.", ChatMessageType.BROADCAST)
    }
}
