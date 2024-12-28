package org.ash.french.killer.sudoku.domain.impl

import kotlinx.serialization.Serializable
import org.ash.french.killer.sudoku.domain.Position
import org.ash.french.killer.sudoku.domain.inRange1to9

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
