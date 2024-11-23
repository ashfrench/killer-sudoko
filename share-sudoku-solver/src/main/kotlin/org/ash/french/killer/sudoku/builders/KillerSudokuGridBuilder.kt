package org.ash.french.killer.sudoku.builders

import org.ash.french.killer.sudoku.domain.*

data class KillerSudokuGridBuilder(private var sudokuGrid: KillerSudokuGrid) : SudokuBuilder<KillerSudokuGrid> {
    private val cellUpdates = mutableListOf<CellUpdateValueOriginalValue>()

    override fun build(): KillerSudokuGrid = TODO()
}
