@file:OptIn(ExperimentalUuidApi::class, ExperimentalUuidApi::class)

package org.ash.french.killer.sudoku.dto

import org.ash.french.killer.sudoku.generators.GridFactory.cells
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalUuidApi
data class SudokuGrid(
    val id: Uuid?,
    val cells: List<Cell>,
    val cellValues: Map<Cell, Int?>,
)

fun org.ash.french.killer.sudoku.domain.SudokuGrid.toDto(): SudokuGrid {
    return SudokuGrid(
        id = this.id,
        cells = cells.map { it.toDto() },
        cellValues = getAllCellValues().mapKeys { it.key.toDto() }.mapValues { it.value.toInt() },
    )
}

private fun org.ash.french.killer.sudoku.domain.Cell.toDto(): Cell {
    return Cell(x.toInt(), y.toInt())
}
