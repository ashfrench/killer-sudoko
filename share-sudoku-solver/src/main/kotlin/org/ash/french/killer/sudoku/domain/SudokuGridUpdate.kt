package org.ash.french.killer.sudoku.domain

import kotlinx.serialization.Serializable

@Serializable
data class SudokuGridUpdate(val updates: Collection<CellUpdate>) : UpdateID
