package org.ash.french.killer.sudoku.solvers

import org.ash.french.killer.sudoku.domain.SudokuGridInterface
import org.ash.french.killer.sudoku.solvers.implementation.CellUpdateType

/**
 * Docs for <project_root>/docs/Solving_Techniques.md
 */
fun interface SudokuGridCellUpdate {
    fun getCellUpdates(grid: SudokuGridInterface): List<CellUpdateType>
}
