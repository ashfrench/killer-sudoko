package org.ash.french.killer.sudoko.solvers

import org.ash.french.killer.sudoko.domain.Cell
import org.ash.french.killer.sudoko.domain.Column

interface ColumnFinder {

    fun getColumn(cell: Cell): Column
    fun getColumn(x: UByte) = getColumn(Cell(x, 1u))
    fun getColumn(x: Int) = getColumn(Cell(x, 1))

}