package org.ash.french.killer.sudoku.solvers.implementation

import org.ash.french.killer.sudoku.domain.SudokuGrid
import org.ash.french.killer.sudoku.solvers.SudokuGridCellUpdate
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
internal class HiddenSingle : SudokuGridCellUpdate {
    override fun getCellUpdates(grid: SudokuGrid): List<CellUpdateType> {
        TODO("Not yet implemented")
    }
}
