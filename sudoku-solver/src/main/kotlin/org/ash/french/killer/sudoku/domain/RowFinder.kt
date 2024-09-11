package org.ash.french.killer.sudoku.domain

internal interface RowFinder {
    fun getRow(cell: Cell): Row

    fun getRow(y: UByte) = getRow(Cell(1u, y))

    fun getRow(y: Int) = getRow(Cell(1, y))
}
