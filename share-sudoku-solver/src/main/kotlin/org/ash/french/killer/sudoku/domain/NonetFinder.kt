package org.ash.french.killer.sudoku.domain

import org.ash.french.killer.sudoku.domain.impl.Cell
import org.ash.french.killer.sudoku.domain.impl.Nonet

interface NonetFinder {
    fun getNonet(cell: Cell): Nonet

    fun getNonet(nonetPosition: Int): Nonet

    fun getNonets(): List<Nonet>
}
