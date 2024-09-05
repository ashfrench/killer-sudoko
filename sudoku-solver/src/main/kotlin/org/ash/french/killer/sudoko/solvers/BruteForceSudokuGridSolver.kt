package org.ash.french.killer.sudoko.solvers

import org.ash.french.killer.sudoko.domain.Cell
import org.ash.french.killer.sudoko.domain.SudokuGrid

class BruteForceSudokuGridSolver : SudokuGridSolvers {
    private val cells = (1..9).flatMap { x ->
        (1..9).map { y ->
            Cell(x, y)
        }
    }

    override fun solve(sudokuGrid: SudokuGrid) = bruteForceSolve(sudokuGrid)

    override fun solve(sudokuGrid: SudokuGrid, updates: Collection<CellUpdate>) =
        bruteForceSolve(sudokuGrid, updates)

    private fun bruteForceSolve(sudokuGrid: SudokuGrid): Collection<CellUpdate> {
        cells.forEach {

        }

        TODO("Not yet implemented")
    }

    private fun bruteForceSolve(sudokuGrid: SudokuGrid, updates: Collection<CellUpdate>): SolvedSudokuGridStatus {
        TODO("Not yet implemented")
    }
}