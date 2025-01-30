package org.ash.french.killer.sudoku.builders

import org.ash.french.killer.sudoku.domain.impl.Cage
import org.ash.french.killer.sudoku.domain.impl.KillerSudokuGrid
import org.ash.french.killer.sudoku.domain.impl.cells

data class KillerSudokuGridBuilder(private var sudokuGrid: KillerSudokuGrid = KillerSudokuGrid()) : SudokuBuilder<KillerSudokuGrid> {
    private val cages = mutableListOf<Cage>()

    override fun build(): KillerSudokuGrid = sudokuGrid.also { sudokuGrid.validateCages() }

    fun cage(init: KillerSudokuCageBuilder.() -> Unit) {
        val builder = KillerSudokuCageBuilder()
        builder.init()
        cages.add(builder.build())
    }
}

private fun KillerSudokuGrid.validateCages() {
    cells.all { getCage(it).validate().isSuccess }
    val cageSum = getCages().sumOf { it.sum.toInt() }
    if (cageSum != 405) throw RuntimeException("Invalid Cage Sum: $cageSum")
}
