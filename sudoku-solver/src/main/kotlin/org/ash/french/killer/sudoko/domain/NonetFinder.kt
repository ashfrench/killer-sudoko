package org.ash.french.killer.sudoko.domain

interface NonetFinder {
    fun getNonet(cell: Cell): Nonet

    fun getNonet(nonetPosition: Int): Nonet
}
