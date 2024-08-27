package org.ash.french.killer.sudoko.solvers

import org.ash.french.killer.sudoko.domain.Cell
import org.ash.french.killer.sudoko.domain.Row

interface RowFinder {

    fun getRow(cell: Cell): Row
    fun getRow(y: UByte) = getRow(Cell(1u, y))
    fun getRow(y: Int) = getRow(Cell(1, y))

}