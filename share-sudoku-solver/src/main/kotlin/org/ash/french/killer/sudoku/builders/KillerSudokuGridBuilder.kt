package org.ash.french.killer.sudoku.builders

import org.ash.french.killer.sudoku.domain.impl.Cage
import org.ash.french.killer.sudoku.domain.impl.CellUpdateValueOriginalValue
import org.ash.french.killer.sudoku.domain.impl.KillerSudokuGrid

data class KillerSudokuGridBuilder(private var sudokuGrid: KillerSudokuGrid = KillerSudokuGrid()) : SudokuBuilder<KillerSudokuGrid> {
    private val cellUpdates = mutableListOf<CellUpdateValueOriginalValue>()
    private val cages = mutableListOf<Cage>()

    override fun build(): KillerSudokuGrid = TODO()

    fun cage(init: KillerSudokuCageBuilder.() -> Unit) {
        val builder = KillerSudokuCageBuilder()
        builder.init()
        cages.add(builder.build())
    }
}
