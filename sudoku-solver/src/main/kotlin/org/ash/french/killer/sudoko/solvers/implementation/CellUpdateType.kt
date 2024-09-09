package org.ash.french.killer.sudoko.solvers.implementation

import kotlinx.serialization.Serializable
import org.ash.french.killer.sudoko.domain.CellUpdate
import org.ash.french.killer.sudoko.solvers.SudokuSolvingUpdateType
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
@Serializable
data class CellUpdateType(val cellUpdate: CellUpdate, val type: SudokuSolvingUpdateType, val description: String)
