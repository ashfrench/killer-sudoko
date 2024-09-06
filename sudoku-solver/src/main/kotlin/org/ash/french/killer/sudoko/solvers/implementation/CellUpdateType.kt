package org.ash.french.killer.sudoko.solvers.implementation

import org.ash.french.killer.sudoko.domain.CellUpdate
import org.ash.french.killer.sudoko.solvers.SudokuSolvingUpdateType

data class CellUpdateType(val cellUpdate: CellUpdate, val type: SudokuSolvingUpdateType, val description: String)
