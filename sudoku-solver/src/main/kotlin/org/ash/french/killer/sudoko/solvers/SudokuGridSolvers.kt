package org.ash.french.killer.sudoko.solvers

import kotlinx.coroutines.channels.Channel
import org.ash.french.killer.sudoko.domain.CellUpdate
import org.ash.french.killer.sudoko.domain.SudokuGrid
import org.ash.french.killer.sudoko.domain.SudokuGridUpdate

interface SudokuGridSolvers {
    fun solve(sudokuGrid: SudokuGrid): Collection<CellUpdate>

    fun solve(
        sudokuGrid: SudokuGrid,
        updates: Collection<CellUpdate>,
    ): SolvedSudokuGridStatus
}

abstract class SudokuGridCoroutineSolvers : SudokuGridSolvers {
    val outputChannel = Channel<SudokuGridUpdate>()

    abstract fun solve(
        sudokuGrid: SudokuGrid,
        channel: Channel<CellUpdate>,
    )
}
