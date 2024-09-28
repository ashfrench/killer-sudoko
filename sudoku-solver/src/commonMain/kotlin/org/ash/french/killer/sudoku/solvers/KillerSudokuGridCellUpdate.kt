package org.ash.french.killer.sudoku.solvers

import org.ash.french.killer.sudoku.domain.KillerSudokuGrid
import org.ash.french.killer.sudoku.solvers.implementation.CellUpdateType

/**
 * Docs for <project_root>/docs/Solving_Techniques.md
 */
internal fun interface KillerSudokuGridCellUpdate {
    fun getCellUpdates(grid: KillerSudokuGrid): List<CellUpdateType>
}
