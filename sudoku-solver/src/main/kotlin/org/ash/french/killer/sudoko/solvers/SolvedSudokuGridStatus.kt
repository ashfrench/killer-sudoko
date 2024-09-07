package org.ash.french.killer.sudoko.solvers

import org.ash.french.killer.sudoko.domain.CellUpdate
import org.ash.french.killer.sudoko.domain.SudokuGrid

sealed class SolvedSudokuGridStatus

data class SolvedSudokuGrid(
    val grid: SudokuGrid,
    val cellUpdates: Collection<CellUpdate>,
) : SolvedSudokuGridStatus()

data class SolvingSudokuGrid(
    val grid: SudokuGrid,
    val cellUpdates: Collection<CellUpdate>,
) : SolvedSudokuGridStatus()

data class UnsolvableSudokuGrid(val sudokuGrid: SudokuGrid) : SolvedSudokuGridStatus()
