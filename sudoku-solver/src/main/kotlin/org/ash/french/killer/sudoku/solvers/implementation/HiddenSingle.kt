package org.ash.french.killer.sudoku.solvers.implementation

import org.ash.french.killer.sudoku.domain.Nonet
import org.ash.french.killer.sudoku.domain.SudokuGrid
import org.ash.french.killer.sudoku.solvers.SudokuGridCellUpdate

internal class HiddenSingle : SudokuGridCellUpdate {
    override fun getCellUpdates(grid: SudokuGrid): List<CellUpdateType> {
        val updates =
            (1..9)
                .flatMap { nonetPosition ->
                    (1..9).mapNotNull { hiddenSingleCheck ->
                        val nonet = grid.getNonet(nonetPosition)
                        val update =
                            nonet
                                .findHiddenSingle(
                                    grid,
                                    hiddenSingleCheck,
                                )
                        update
                    }
                }

        return updates
    }
}

private fun Nonet.findHiddenSingle(
    grid: SudokuGrid,
    hiddenSingleCheck: Int,
): CellUpdateType? {
    return null
}
