package org.ash.french.killer.sudoku.domain

internal interface NonetFinder {
    fun getNonet(cell: Cell): Nonet

    fun getNonet(nonetPosition: Int): Nonet
}
