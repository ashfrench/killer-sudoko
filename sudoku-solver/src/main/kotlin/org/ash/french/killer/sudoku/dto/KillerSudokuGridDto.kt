package org.ash.french.killer.sudoku.dto

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalUuidApi
data class KillerSudokuGridDto(
    val id: Uuid?,
    val cells: List<CellDto>,
    val cellValues: Map<CellDto, Int>,
    val cages: List<CageDto>,
)
