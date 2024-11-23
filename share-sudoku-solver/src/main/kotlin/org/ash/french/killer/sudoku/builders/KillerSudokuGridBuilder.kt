package org.ash.french.killer.sudoku.builders

import org.ash.french.killer.sudoku.domain.CellUpdateValueOriginalValue
import org.ash.french.killer.sudoku.domain.KillerSudokuGrid

data class KillerSudokuGridBuilder(private var sudokuGrid: KillerSudokuGrid = KillerSudokuGrid()) : SudokuBuilder<KillerSudokuGrid> {
    private val cellUpdates = mutableListOf<CellUpdateValueOriginalValue>()

    override fun build(): KillerSudokuGrid = TODO()
}
