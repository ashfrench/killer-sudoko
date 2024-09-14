package org.ash.french.killer.sudoku.solvers.implementation

import org.ash.french.killer.sudoku.domain.Column
import org.ash.french.killer.sudoku.domain.KillerSudokuGrid
import org.ash.french.killer.sudoku.domain.Nonet
import org.ash.french.killer.sudoku.domain.Row
import org.ash.french.killer.sudoku.solvers.KillerSudokuGridCellUpdate

internal class HiddenSingle : KillerSudokuGridCellUpdate {
    override fun getCellUpdates(grid: KillerSudokuGrid): List<CellUpdateType> {
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
    grid: KillerSudokuGrid,
    hiddenSingleCheck: Int,
): CellUpdateType? {
    return null
}

private fun Row.findHiddenSingle(
    grid: KillerSudokuGrid,
    hiddenSingleCheck: Int,
): CellUpdateType? {
    return null
}

private fun Column.findHiddenSingle(
    grid: KillerSudokuGrid,
    hiddenSingleCheck: Int,
): CellUpdateType? {
    return null
}
