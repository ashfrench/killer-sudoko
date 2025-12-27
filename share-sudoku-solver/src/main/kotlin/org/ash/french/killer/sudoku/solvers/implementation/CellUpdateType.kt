package org.ash.french.killer.sudoku.solvers.implementation

import kotlinx.serialization.Serializable
import org.ash.french.killer.sudoku.domain.impl.CellUpdate
import org.ash.french.killer.sudoku.solvers.SudokuSolvingUpdateType

@Serializable
data class CellUpdateType(
    val cellUpdate: CellUpdate,
    val type: SudokuSolvingUpdateType,
    val description: String,
)
