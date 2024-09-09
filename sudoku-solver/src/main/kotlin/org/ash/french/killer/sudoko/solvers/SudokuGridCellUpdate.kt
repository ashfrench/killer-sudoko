package org.ash.french.killer.sudoko.solvers

import org.ash.french.killer.sudoko.domain.SudokuGrid
import org.ash.french.killer.sudoko.solvers.implementation.CellUpdateType
import kotlin.uuid.ExperimentalUuidApi

/**
 * Docs for <project_root>/docs/Solving_Techniques.md
 */
@ExperimentalUuidApi
fun interface SudokuGridCellUpdate {
    fun getCellUpdates(grid: SudokuGrid): List<CellUpdateType>
}
