package org.ash.french.killer.sudoku.solvers

import org.ash.french.killer.sudoku.domain.CellUpdate
import org.ash.french.killer.sudoku.domain.SudokuGrid

sealed class SolvedSudokuGridStatus

internal data class SolvedSudokuGrid(
    val grid: SudokuGrid,
    val cellUpdates: Collection<CellUpdate>,
) : SolvedSudokuGridStatus()

internal data class SolvingSudokuGrid(
    val grid: SudokuGrid,
    val cellUpdates: Collection<CellUpdate>,
) : SolvedSudokuGridStatus()

internal data class UnsolvableSudokuGrid(val sudokuGrid: SudokuGrid) : SolvedSudokuGridStatus()
