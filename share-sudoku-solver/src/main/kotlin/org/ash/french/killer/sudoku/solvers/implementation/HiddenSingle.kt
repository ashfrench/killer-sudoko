package org.ash.french.killer.sudoku.solvers.implementation

import org.ash.french.killer.sudoku.domain.SudokuGridInterface
import org.ash.french.killer.sudoku.domain.impl.CellUpdateValue
import org.ash.french.killer.sudoku.domain.impl.Region
import org.ash.french.killer.sudoku.solvers.SudokuSolvingUpdateType

internal data object HiddenSingle : SudokuGridCellUpdate {
    override fun getCellUpdates(grid: SudokuGridInterface): List<CellUpdateType> {
        val updates =
            (1..9)
                .flatMap { hiddenSingleCheck ->
                    (1..9).flatMap { position ->
                        val nonet = grid.getNonet(position)
                        val row = grid.getRow(position)
                        val column = grid.getColumn(position)

                        val nonetUpdate = nonet.findHiddenSingle(grid, hiddenSingleCheck)
                        val rowUpdate = row.findHiddenSingle(grid, hiddenSingleCheck)
                        val columnUpdate = column.findHiddenSingle(grid, hiddenSingleCheck)

                        listOfNotNull(nonetUpdate, rowUpdate, columnUpdate)
                    }
                }

        return updates
    }
}

private fun Region.findHiddenSingle(
    grid: SudokuGridInterface,
    hiddenSingleCheck: Int,
): CellUpdateType? {
    val hiddenSingleCellsCheck = cells.filter { hiddenSingleCheck in it.getPotentialCellValues() }
    if (hiddenSingleCellsCheck.size == 1) {
        val cell = hiddenSingleCellsCheck[0]
        val cellState = grid.getCellValue(cell)
        if (cellState.value == null) {
            return CellUpdateType(
                CellUpdateValue(cell, hiddenSingleCheck),
                SudokuSolvingUpdateType.HIDDEN_SINGLE,
                "$cell has hidden single $hiddenSingleCheck",
            )
        }
    }
    return null
}
