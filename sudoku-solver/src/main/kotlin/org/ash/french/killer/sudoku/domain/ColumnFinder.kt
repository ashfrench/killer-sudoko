package org.ash.french.killer.sudoku.domain

interface ColumnFinder {
    fun getColumn(cell: Cell): Column

    fun getColumn(x: UByte) = getColumn(Cell(x, 1u))

    fun getColumn(x: Int) = getColumn(Cell(x, 1))
}
