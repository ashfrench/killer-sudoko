package org.ash.french.killer.sudoko.solvers.implementation

import org.ash.french.killer.sudoko.domain.SudokuGrid
import org.ash.french.killer.sudoko.solvers.SudokuGridCellUpdate
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
class LockedCandidates : SudokuGridCellUpdate {
    override fun getCellUpdates(grid: SudokuGrid): List<CellUpdateType> {
        TODO("Not yet implemented")
    }
}
