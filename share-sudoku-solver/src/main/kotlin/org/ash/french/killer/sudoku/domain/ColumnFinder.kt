package org.ash.french.killer.sudoku.domain

import org.ash.french.killer.sudoku.domain.impl.Cell
import org.ash.french.killer.sudoku.domain.impl.Column

interface ColumnFinder {
    fun getColumn(cell: Cell): Column

    fun getColumn(x: UByte) = getColumn(Cell(x, 1u))

    fun getColumn(x: Int) = getColumn(Cell(x, 1))

    fun getColumns(): List<Column>
}
