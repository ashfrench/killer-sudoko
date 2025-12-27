package org.ash.french.killer.sudoku.builders

import org.ash.french.killer.sudoku.domain.SudokuGrid
import org.ash.french.killer.sudoku.domain.impl.Cell
import org.ash.french.killer.sudoku.domain.impl.CellState
import org.ash.french.killer.sudoku.domain.impl.CellUpdateValueOriginalValue

class SudokuCellValueBuilder(
    private var sudokuGrid: SudokuGrid,
) : SudokuBuilder<CellUpdateValueOriginalValue> {
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
