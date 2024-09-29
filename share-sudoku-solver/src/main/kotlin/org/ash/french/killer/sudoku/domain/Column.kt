package org.ash.french.killer.sudoku.domain

import kotlinx.serialization.Serializable

@Serializable
data class Column(val x: UByte, override val cells: Set<Cell>) : Region {
    init {
        validate().getOrThrow()
    }

    override fun validate(): Result<Boolean> {
        return try {
            require(x in (1u..9u)) { "X must be a positive Integer between 1 and 9" }
            require(cells.any { it.x == x }) { "All Cells must be in the Row $x" }
            require(cells.distinct().count() == 9) { "All Cells must be in the Row $x" }

            valid()
        } catch (e: Throwable) {
            validationFailure(e)
        }
    }
}
