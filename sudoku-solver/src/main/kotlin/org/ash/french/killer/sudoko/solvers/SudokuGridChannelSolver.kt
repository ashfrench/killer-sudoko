package org.ash.french.killer.sudoko.solvers

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import org.ash.french.killer.sudoko.domain.Cell
import org.ash.french.killer.sudoko.domain.SudokuGrid

object SudokuGridChannelSolver : SudokuGridSolvers {
    fun solveGrid(
        sudokuGrid: SudokuGrid,
        solvers: List<SudokuGridCoroutineSolvers>,
    ) = runBlocking {
        val channel = Channel<CellUpdate>()

        launch {
            for (update in channel) {
                sudokuGrid.updateCell(update.cell, update.value)
            }
        }

        withTimeout(1300L) {
            solvers.forEach { solver ->
                launch {
                    solver.solve(sudokuGrid, channel)
                }
            }
        }
    }

    override fun solve(
        sudokuGrid: SudokuGrid,
        updates: Collection<CellUpdate>,
    ): SolvedSudokuGrid {
        return sudokuGrid.applyUpdates(updates)
    }
}

data class CellUpdate(
    val cell: Cell,
    val value: UByte,
)
