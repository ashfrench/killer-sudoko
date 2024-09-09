package org.ash.french.killer.sudoku.solvers

import org.ash.french.killer.sudoku.domain.SudokuGrid
import org.ash.french.killer.sudoku.solvers.implementation.CellUpdateType
import kotlin.uuid.ExperimentalUuidApi

/**
 * Docs for <project_root>/docs/Solving_Techniques.md
 */
@ExperimentalUuidApi
fun interface SudokuGridCellUpdate {
    fun getCellUpdates(grid: SudokuGrid): List<CellUpdateType>
}
