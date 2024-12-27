package org.ash.french.killer.sudoku.domain

import org.ash.french.killer.sudoku.domain.impl.Cell
import org.ash.french.killer.sudoku.domain.impl.CellState
import org.ash.french.killer.sudoku.domain.impl.CellUpdate

interface CellValueFinder {
    fun getCell(
        x: Int,
        y: Int,
    ): Cell = getCell(x.toUByte(), y.toUByte())

    fun getCell(
        x: UByte,
        y: UByte,
    ): Cell

    fun getCellValue(cell: Cell): CellState

    fun getCellValue(
        x: Int,
        y: Int,
    ) = getCellValue(Cell(x, y))

    fun getCellValue(
        x: UByte,
        y: UByte,
    ) = getCellValue(Cell(x, y))

    operator fun contains(cell: Cell): Boolean

    fun getAllCellValues(): Map<Cell, CellState>

    fun getSetCellValues(): List<CellUpdate>
}
