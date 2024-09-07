package org.ash.french.killer.sudoko.solvers

import org.ash.french.killer.sudoko.domain.SudokuGrid
import org.ash.french.killer.sudoko.solvers.implementation.CellUpdateType

/**
 * Docs for <project_root>/docs/Solving_Techniques.md
 */
fun interface SudokuGridCellUpdate {
    fun getCellUpdates(grid: SudokuGrid): List<CellUpdateType>
}
