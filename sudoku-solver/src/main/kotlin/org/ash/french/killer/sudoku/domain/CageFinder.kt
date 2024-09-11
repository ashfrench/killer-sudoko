package org.ash.french.killer.sudoku.domain

internal interface CageFinder {
    fun getCages(): Set<Cage>

    fun getCage(cell: Cell): Cage

    fun getCage(
        x: UByte,
        y: UByte,
    ) = getCage(Cell(x, y))

    fun getCage(
        x: Int,
        y: Int,
    ) = getCage(Cell(x, y))
}
