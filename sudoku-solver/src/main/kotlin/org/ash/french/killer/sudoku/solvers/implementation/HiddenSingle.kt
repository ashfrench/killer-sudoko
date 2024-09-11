package org.ash.french.killer.sudoku.solvers.implementation

import org.ash.french.killer.sudoku.domain.Cell
import org.ash.french.killer.sudoku.domain.CellUpdate
import org.ash.french.killer.sudoku.domain.SudokuGrid
import org.ash.french.killer.sudoku.solvers.SudokuGridCellUpdate
import org.ash.french.killer.sudoku.solvers.SudokuSolvingUpdateType
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
internal class HiddenSingle : SudokuGridCellUpdate {
    override fun getCellUpdates(grid: SudokuGrid): List<CellUpdateType> {
        val updated = CellUpdateType(
            CellUpdate(
                Cell(1, 1),
                1
            ),
            SudokuSolvingUpdateType.HIDDEN_SINGLE,
            "Hidden Single"
        )
        return listOf(updated)
    }
}
