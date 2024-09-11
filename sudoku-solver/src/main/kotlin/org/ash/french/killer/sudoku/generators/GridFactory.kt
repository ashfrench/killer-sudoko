package org.ash.french.killer.sudoku.generators

import org.ash.french.killer.sudoku.domain.Cell
import org.ash.french.killer.sudoku.domain.SudokuGrid
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
internal object GridFactory {
    val xRange = 1..9
    val yRange = 1..9
    val cells =
        xRange
            .flatMap { x ->
                yRange
                    .map { y -> Cell(x, y) }
            }.toSet()

    fun defaultSudokuGrid(): SudokuGrid {
        require(cells.size == 81) { "Missing Cells to create a grid" }
        return SudokuGrid()
    }
}
