package org.ash.french.killer.sudoko.solvers

import kotlinx.coroutines.channels.Channel
import org.ash.french.killer.sudoko.domain.SudokuGrid

interface SudokuGridSolvers {
    fun solve(
        sudokuGrid: SudokuGrid,
    ): Collection<CellUpdate>

    fun solve(
        sudokuGrid: SudokuGrid,
        updates: Collection<CellUpdate>,
    ): SolvedSudokuGridStatus
}

abstract class SudokuGridCoroutineSolvers: SudokuGridSolvers {

    val outputChannel = Channel<SudokuGridUpdate>()

    abstract fun solve(
        sudokuGrid: SudokuGrid,
        channel: Channel<CellUpdate>,
    )

}
