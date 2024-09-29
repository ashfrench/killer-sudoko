package org.ash.french.killer.sudoku.domain

import kotlinx.serialization.Serializable

@Serializable
data class GridPosition(
    override val x: UByte,
    override val y: UByte,
) : Position {
    init {
        require(x.inRange1to9()) { "X must be a positive Integer between 1 and 9" }
        require(y.inRange1to9()) { "Y must be a positive Integer between 1 and 9" }
    }
}

interface Position {
    val x: UByte
    val y: UByte
}

private fun UByte?.inRange1to9() = this != null && this in (1u..9u)
