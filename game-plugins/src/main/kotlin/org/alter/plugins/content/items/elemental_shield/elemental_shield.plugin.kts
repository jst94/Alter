onItemEquip("item.elemental_shield") {
    player.queue {
        player.animate(-1)
        player.graphic(-1)

        player.animate(3996, 3)
        player.graphic(244, 95, 3)
    }
}
