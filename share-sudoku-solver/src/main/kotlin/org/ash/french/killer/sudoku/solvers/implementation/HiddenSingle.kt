package org.ash.french.killer.sudoku.solvers.implementation

import org.ash.french.killer.sudoku.domain.SudokuGridInterface
import org.ash.french.killer.sudoku.domain.impl.Column
import org.ash.french.killer.sudoku.domain.impl.Nonet
import org.ash.french.killer.sudoku.domain.impl.Row

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

private fun Nonet.findHiddenSingle(
    grid: SudokuGridInterface,
    hiddenSingleCheck: Int,
): CellUpdateType? {
    return null
}

private fun Row.findHiddenSingle(
    grid: SudokuGridInterface,
    hiddenSingleCheck: Int,
): CellUpdateType? {
    return null
}

private fun Column.findHiddenSingle(
    grid: SudokuGridInterface,
    hiddenSingleCheck: Int,
): CellUpdateType? {
    return null
}
