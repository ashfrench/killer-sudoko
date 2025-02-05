package org.ash.french.killer.sudoku.compose

import org.ash.french.killer.sudoku.domain.impl.Cell

data class SudokuBoard(val grid: MutableMap<Cell, Int?>) {
    fun setCellValue(
        row: Int,
        col: Int,
        value: Int?,
    ) {
        val cell = Cell(row, col)
        grid[cell] = value
    }
}
