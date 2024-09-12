package org.ash.french.killer.sudoku.solvers

import org.ash.french.killer.sudoku.domain.SudokuGrid
import org.ash.french.killer.sudoku.solvers.implementation.CellUpdateType

/**
 * Docs for <project_root>/docs/Solving_Techniques.md
 */
internal fun interface SudokuGridCellUpdate {
    fun getCellUpdates(grid: SudokuGrid): List<CellUpdateType>
}
