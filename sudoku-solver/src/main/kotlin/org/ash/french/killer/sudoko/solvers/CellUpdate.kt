package org.ash.french.killer.sudoko.solvers

import org.ash.french.killer.sudoko.domain.SudokuGrid

fun interface CellUpdate {
    fun getCellUpdates(grid: SudokuGrid): List<CellUpdate>
}