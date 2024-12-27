package org.ash.french.killer.sudoku.domain.impl

import kotlinx.serialization.Serializable

@Serializable
data class CellState(
    val value: UByte? = null,
    val error: Boolean = false,
    val locked: Boolean = false,
)
