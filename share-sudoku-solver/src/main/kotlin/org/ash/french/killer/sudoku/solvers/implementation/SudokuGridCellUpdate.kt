package org.ash.french.killer.sudoku.solvers.implementation

import org.ash.french.killer.sudoku.domain.SudokuGridInterface

/**
 * Docs for <project_root>/docs/Solving_Techniques.md
 */
sealed interface SudokuGridCellUpdate {
    fun getCellUpdates(grid: SudokuGridInterface): List<CellUpdateType>
}
