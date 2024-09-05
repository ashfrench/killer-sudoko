package org.ash.french.killer.sudoko.builders

import org.ash.french.killer.sudoko.domain.Cell
import org.ash.french.killer.sudoko.domain.SudokuGrid

class SudokuCellValueBuilder(private var sudokuGrid: SudokuGrid) {
    var x: Int = 1
    var y: Int = 1
    var value: Int = 1

    fun build(): SudokuGrid {
        val grid = sudokuGrid.copy()
        grid.cellValue(Cell(x, y), value.toUByte())

        return grid
    }
}
