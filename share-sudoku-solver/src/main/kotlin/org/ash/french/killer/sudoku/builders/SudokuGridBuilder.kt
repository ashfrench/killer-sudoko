package org.ash.french.killer.sudoku.builders

import org.ash.french.killer.sudoku.domain.impl.CellUpdate
import org.ash.french.killer.sudoku.domain.impl.CellUpdateValueOriginalValue
import org.ash.french.killer.sudoku.domain.SudokuGrid

data class SudokuGridBuilder(private var sudokuGrid: SudokuGrid) : SudokuBuilder<SudokuGrid> {
    private val cellUpdates = mutableListOf<CellUpdateValueOriginalValue>()

    override fun build(): SudokuGrid =
        sudokuGrid.withOriginalCellValues(cellUpdates).also {
            println(sudokuGrid)
            println()
        }

    fun cell(init: SudokuCellValueBuilder.() -> Unit): CellUpdate {
        val builder = SudokuCellValueBuilder(sudokuGrid)
        builder.init()

        val cellUpdate = builder.build()
        cellUpdates.add(cellUpdate)
        return cellUpdate
    }
}

val grid = randomDefaultGrid()
