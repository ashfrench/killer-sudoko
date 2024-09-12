package org.ash.french.killer.sudoku.domain

import kotlinx.serialization.Serializable

@Serializable
internal data class SudokuGridUpdate(val updates: Collection<CellUpdate>) : UpdateID
