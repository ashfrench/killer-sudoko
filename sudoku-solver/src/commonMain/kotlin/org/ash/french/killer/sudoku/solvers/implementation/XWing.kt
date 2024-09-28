package org.ash.french.killer.sudoku.solvers.implementation

import org.ash.french.killer.sudoku.domain.SudokuGridInterface
import org.ash.french.killer.sudoku.solvers.SudokuGridCellUpdate

internal class XWing : SudokuGridCellUpdate {
    override fun getCellUpdates(grid: SudokuGridInterface): List<CellUpdateType> {
        return emptyList()
    }
}
