package org.ash.french.killer.sudoku.builders

import org.ash.french.killer.sudoku.domain.Cell
import org.ash.french.killer.sudoku.domain.CellUpdate
import org.ash.french.killer.sudoku.domain.SudokuGrid

class SudokuCellValueBuilder(private var sudokuGrid: SudokuGrid) : SudokuBuilder<CellUpdate> {
    var x: Int = 1
    var y: Int = 1
    var value: Int? = null

    override fun build(): CellUpdate {
        val grid = sudokuGrid.copy()
        val cell = Cell(x, y)
        grid.setCellValue(cell, value?.toUByte())

        return CellUpdate(cell, value!!)
    }
}
