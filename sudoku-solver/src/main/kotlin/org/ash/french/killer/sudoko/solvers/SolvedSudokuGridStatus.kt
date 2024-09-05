package org.ash.french.killer.sudoko.solvers

import org.ash.french.killer.sudoko.generators.SudokuGrid
import java.util.UUID

sealed class SolvedSudokuGridStatus {
    val solvingID: UUID = UUID.randomUUID()
}

data class SolvedSudokuGrid(
    val grid: SudokuGrid,
    val cellUpdates: Collection<CellUpdate>,
) : SolvedSudokuGridStatus()

data class SolvingSudokuGrid(
    val grid: SudokuGrid,
    val cellUpdates: Collection<CellUpdate>,
) : SolvedSudokuGridStatus()

data class UnsolvableSudokuGrid(val sudokuGrid: SudokuGrid) : SolvedSudokuGridStatus()
