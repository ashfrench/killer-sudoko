package org.ash.french.killer.sudoku.domain.impl

import kotlinx.serialization.Serializable
import org.ash.french.killer.sudoku.domain.UpdateID

@Serializable
data class SudokuGridUpdate(
    val updates: Collection<CellUpdate>
) : UpdateID
