package org.ash.french.killer.sudoku.solvers.implementation

import org.ash.french.killer.sudoku.domain.SudokuGridInterface

internal data object XWing : SudokuGridCellUpdate {
    override fun getCellUpdates(grid: SudokuGridInterface): List<CellUpdateType> {
        return emptyList()
    }
}
