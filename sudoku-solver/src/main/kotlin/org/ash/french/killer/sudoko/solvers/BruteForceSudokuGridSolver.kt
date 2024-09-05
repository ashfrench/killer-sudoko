package org.ash.french.killer.sudoko.solvers

import org.ash.french.killer.sudoko.domain.Cell
import org.ash.french.killer.sudoko.domain.SudokuGrid

class BruteForceSudokuGridSolver : SudokuGridSolvers {
    private val cells =
        (1..9)
            .flatMap { x ->
                (1..9)
                    .map { y ->
                        Cell(x, y)
                    }
            }

    override fun solve(sudokuGrid: SudokuGrid) = bruteForceSolve(sudokuGrid)

    override fun solve(
        sudokuGrid: SudokuGrid,
        updates: Collection<CellUpdate>,
    ) = bruteForceSolve(sudokuGrid, updates)

    @Suppress("UNUSED")
    private fun bruteForceSolve(sudokuGrid: SudokuGrid): Collection<CellUpdate> {
        println(sudokuGrid)
        TODO("Not yet implemented")
    }

    @Suppress("UNUSED")
    private fun bruteForceSolve(
        sudokuGrid: SudokuGrid,
        updates: Collection<CellUpdate>,
    ): SolvedSudokuGridStatus {
        println(sudokuGrid)
        println(updates)
        TODO("Not yet implemented")
    }
}
