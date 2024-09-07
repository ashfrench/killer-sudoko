package org.ash.french.killer.sudoko.solvers

import org.ash.french.killer.sudoko.domain.SudokuGrid
import org.ash.french.killer.sudoko.solvers.implementation.CellUpdateType

fun interface SudokuGridCellUpdate {
    fun getCellUpdates(grid: SudokuGrid): List<CellUpdateType>
}