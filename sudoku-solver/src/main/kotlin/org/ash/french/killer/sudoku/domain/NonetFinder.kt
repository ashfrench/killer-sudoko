package org.ash.french.killer.sudoku.domain

interface NonetFinder {
    fun getNonet(cell: Cell): Nonet

    fun getNonet(nonetPosition: Int): Nonet

    fun getNonets(): List<Nonet>
}
