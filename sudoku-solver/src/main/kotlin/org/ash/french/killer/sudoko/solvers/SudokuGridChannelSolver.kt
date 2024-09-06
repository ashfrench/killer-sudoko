package org.ash.french.killer.sudoko.solvers

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import org.ash.french.killer.sudoko.domain.CellUpdate
import org.ash.french.killer.sudoko.domain.SudokuGrid
import org.ash.french.killer.sudoko.domain.SudokuGridUpdate
import kotlin.time.Duration.Companion.seconds

class SudokuGridChannelSolver(private val sudokuGrid: SudokuGrid) : SudokuGridSolvers {
    private val gridUpdateChannel = Channel<SudokuGridUpdate>()

    fun solveGrid(solvers: List<SudokuGridCoroutineSolvers>) =
        runBlocking {
            val cellUpdateChannel = Channel<CellUpdate>()

            launch {
                for (update in cellUpdateChannel) {
                    sudokuGrid.setCellValue(update.cell, update.value)
                }
            }
            gridUpdates(sudokuGrid, solvers, cellUpdateChannel)
        }

    private suspend fun gridUpdates(
        sudokuGrid: SudokuGrid,
        solvers: List<SudokuGridCoroutineSolvers>,
        cellUpdateChannel: Channel<CellUpdate>,
    ) {
        // Timeout after 60 seconds
        withTimeout(60.seconds) {
            solvers.forEach { solver ->
                launch {
                    solver.solve(sudokuGrid, cellUpdateChannel)
                }
            }
        }
    }

    override fun solve(sudokuGrid: SudokuGrid): Collection<CellUpdate> {
        TODO("Not yet implemented")
    }

    override fun solve(
        sudokuGrid: SudokuGrid,
        updates: Collection<CellUpdate>,
    ): SolvedSudokuGridStatus {
        updates.forEach { sudokuGrid.setCellValue(it.cell, it.value) }
        return SolvingSudokuGrid(sudokuGrid, updates)
    }
}
