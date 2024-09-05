package org.ash.french.killer.sudoko.solvers.implementation

import org.ash.french.killer.sudoko.domain.SudokuGrid
import org.ash.french.killer.sudoko.solvers.SudokuGridSolvers
import org.ash.french.killer.sudoko.solvers.SudokuSolvingUpdateType

sealed class SudokuSolver(val solver: SudokuSolvingUpdateType) : SudokuGridSolvers {
    abstract fun possibleUpdates(sudokuGrid: SudokuGrid): Collection<CellUpdateType>
}
