package org.ash.french.killer.sudoku.domain

import kotlinx.serialization.Serializable

@Serializable
data class Cage(override val sum: UByte, override val cells: Set<Cell>) : Region {
    init {
        require(sum in 1u..45u) { "Invalid Sum for Cage of size ${cells.size}" }
    }

    override fun validate(): Result<Boolean> {
        return validate()
    }
}
