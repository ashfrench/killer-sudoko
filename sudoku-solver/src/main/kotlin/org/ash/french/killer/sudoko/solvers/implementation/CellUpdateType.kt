package org.ash.french.killer.sudoko.solvers.implementation

import kotlinx.serialization.Serializable
import org.ash.french.killer.sudoko.domain.CellUpdate
import org.ash.french.killer.sudoko.solvers.SudokuSolvingUpdateType

@Serializable
data class CellUpdateType(val cellUpdate: CellUpdate, val type: SudokuSolvingUpdateType, val description: String)
