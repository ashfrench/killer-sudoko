package org.ash.french.killer.sudoko.solvers.implementation

import org.ash.french.killer.sudoko.domain.Cell
import org.ash.french.killer.sudoko.domain.SudokuGrid
import org.ash.french.killer.sudoko.solvers.CellUpdate
import org.ash.french.killer.sudoko.solvers.SolvedSudokuGridStatus
import org.ash.french.killer.sudoko.solvers.SudokuSolvingUpdateType

class BruteForceSolver : SudokuSolver(SudokuSolvingUpdateType.BRUTE_FORCE) {
    private val cells = (1..9).flatMap { row -> (1..9).map { col -> Cell(row, col) } }

    override fun possibleUpdates(sudokuGrid: SudokuGrid): Collection<CellUpdateType> {
        TODO("Not yet implemented")
    }

    override fun solve(sudokuGrid: SudokuGrid): Collection<CellUpdate> {
        TODO("Not yet implemented")
    }

    override fun solve(
        sudokuGrid: SudokuGrid,
        updates: Collection<CellUpdate>,
    ): SolvedSudokuGridStatus {
        TODO("Not yet implemented")
    }
}
