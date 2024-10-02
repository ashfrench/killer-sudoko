package org.ash.french.killer.sudoku.builders

import org.ash.french.killer.sudoku.domain.Cell
import org.ash.french.killer.sudoku.domain.CellState
import org.ash.french.killer.sudoku.domain.CellUpdateValueOriginalValue
import org.ash.french.killer.sudoku.domain.SudokuGrid

class SudokuCellValueBuilder(private var sudokuGrid: SudokuGrid) : SudokuBuilder<CellUpdateValueOriginalValue> {
    var x: Int = 1
    var y: Int = 1
    var value: Int? = null

    override fun build(): CellUpdateValueOriginalValue {
        val grid = sudokuGrid.copy()
        val cell = Cell(x, y)
        grid.setCellValue(cell, CellState(value?.toUByte(), locked = true))

        return CellUpdateValueOriginalValue(cell, value!!)
    }
}
