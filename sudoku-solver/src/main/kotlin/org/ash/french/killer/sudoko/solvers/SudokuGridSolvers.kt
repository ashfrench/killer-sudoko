package org.ash.french.killer.sudoko.solvers

import kotlinx.coroutines.channels.Channel
import org.ash.french.killer.sudoko.domain.SudokuGrid

fun interface SudokuGridSolvers {
    fun solve(
        sudokuGrid: SudokuGrid,
        updates: Collection<CellUpdate>,
    ): SolvedSudokuGridStatus
}

fun interface SudokuGridCoroutineSolvers {
    fun solve(
        sudokuGrid: SudokuGrid,
        channel: Channel<CellUpdate>,
    )
}
