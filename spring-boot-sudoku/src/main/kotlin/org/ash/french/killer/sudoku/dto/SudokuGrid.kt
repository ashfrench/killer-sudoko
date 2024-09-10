package org.ash.french.killer.sudoku.dto

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalUuidApi
data class SudokuGrid(
    val id: Uuid?,
    val cells: List<Cell>,
    val cellValues: Map<Cell, Int>
)

