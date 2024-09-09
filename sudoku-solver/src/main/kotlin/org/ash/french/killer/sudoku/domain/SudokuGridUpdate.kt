package org.ash.french.killer.sudoku.domain

import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
@Serializable
data class SudokuGridUpdate(val updates: Collection<CellUpdate>) : UpdateID
