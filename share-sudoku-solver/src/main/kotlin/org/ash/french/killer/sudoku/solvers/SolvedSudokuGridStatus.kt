package org.ash.french.killer.sudoku.solvers

import org.ash.french.killer.sudoku.domain.CellUpdate
import org.ash.french.killer.sudoku.domain.KillerSudokuGrid

sealed class SolvedSudokuGridStatus

internal data class SolvedSudokuGrid(
    val grid: KillerSudokuGrid,
    val cellUpdates: Collection<CellUpdate>,
) : SolvedSudokuGridStatus()

internal data class SolvingSudokuGrid(
    val grid: KillerSudokuGrid,
    val cellUpdates: Collection<CellUpdate>,
) : SolvedSudokuGridStatus()

internal data class UnsolvableSudokuGrid(val sudokuGrid: KillerSudokuGrid) : SolvedSudokuGridStatus()
