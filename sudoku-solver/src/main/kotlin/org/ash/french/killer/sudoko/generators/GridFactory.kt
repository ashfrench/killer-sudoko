package org.ash.french.killer.sudoko.generators

import org.ash.french.killer.sudoko.domain.Cell
import org.ash.french.killer.sudoko.domain.SudokuGrid
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
object GridFactory {
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
