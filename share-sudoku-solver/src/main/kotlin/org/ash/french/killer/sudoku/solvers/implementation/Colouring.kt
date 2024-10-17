package org.ash.french.killer.sudoku.solvers.implementation

import org.ash.french.killer.sudoku.domain.SudokuGridInterface

internal data object Colouring : SudokuGridCellUpdate {
    override fun getCellUpdates(grid: SudokuGridInterface): List<CellUpdateType> {
        TODO("Not yet implemented")
    }
}
