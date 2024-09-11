@file:OptIn(ExperimentalUuidApi::class, ExperimentalUuidApi::class)

package org.ash.french.killer.sudoku.dto

import org.ash.french.killer.sudoku.domain.Cell
import org.ash.french.killer.sudoku.domain.SudokuGrid
import org.ash.french.killer.sudoku.generators.GridFactory.cells
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalUuidApi
data class SudokuGridDto(
    val id: Uuid?,
    val cells: List<CellDto>,
    val cellValues: Map<CellDto, Int?>,
)

internal fun SudokuGrid.toDto(): SudokuGridDto {
    return SudokuGridDto(
        id = this.id,
        cells = cells.map { it.toDto() },
        cellValues = getAllCellValues().mapKeys { it.key.toDto() }.mapValues { it.value.toInt() },
    )
}

private fun Cell.toDto(): CellDto {
    return CellDto(x.toInt(), y.toInt())
}
