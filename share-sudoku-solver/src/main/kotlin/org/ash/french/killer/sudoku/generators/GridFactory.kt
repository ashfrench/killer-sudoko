package org.ash.french.killer.sudoku.generators

import org.ash.french.killer.sudoku.domain.impl.Cell
import org.ash.french.killer.sudoku.domain.impl.KillerSudokuGrid

internal object GridFactory {
    val xRange = 1..9
    val yRange = 1..9
    val cells =
        xRange
            .flatMap { x ->
                yRange
                    .map { y -> Cell(x, y) }
            }.toSet()

    fun defaultSudokuGrid(): KillerSudokuGrid {
        require(cells.size == 81) { "Missing Cells to create a grid" }
        return KillerSudokuGrid()
    }
}
