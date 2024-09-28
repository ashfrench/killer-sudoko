package org.ash.french.killer.sudoku.dto

import java.util.UUID

data class KillerSudokuGrid(
    val id: UUID?,
    val cells: List<Cell>,
    val cellValues: Map<Cell, Int>,
    val cages: List<Cage>,
)
