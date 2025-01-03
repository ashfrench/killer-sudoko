package org.ash.french.killer.sudoku.builders

import org.ash.french.killer.sudoku.domain.SudokuGrid
import org.ash.french.killer.sudoku.domain.impl.Cell
import org.ash.french.killer.sudoku.domain.impl.CellUpdate
import org.ash.french.killer.sudoku.domain.impl.CellUpdateValueOriginalValue

class SudokuCellValuesBuilder(private var sudokuGrid: SudokuGrid) : SudokuBuilder<List<CellUpdate>> {
    var cells = mutableListOf<Cell>()
    var value: Int? = null

    override fun build(): List<CellUpdate> {
        val grid = sudokuGrid.copy()

        val updates =
            cells.distinct().map { cell ->
                CellUpdateValueOriginalValue(cell, value!!)
            }
        grid.setCellValues(updates)

        return updates
    }

    fun cell(init: SudokuCellBuilder.() -> Unit) {
        val cellBuilder = SudokuCellBuilder()
        cellBuilder.init()
        cells.add(cellBuilder.build())
    }
}
