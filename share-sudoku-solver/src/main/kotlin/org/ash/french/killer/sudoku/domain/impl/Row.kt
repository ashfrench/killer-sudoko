package org.ash.french.killer.sudoku.domain.impl

import kotlinx.serialization.Serializable

@Serializable
data class Row(
    val y: UByte,
    override val cells: Set<Cell>,
) : Region {
    init {
        this.validate().getOrThrow()
    }

    override fun validate(): SudokuValidation =
        try {
            require(y in (1u..9u)) { "Y must be a positive Integer between 1 and 9" }
            require(cells.any { it.y == y }) { "All Cells must be in the Row $y" }
            require(cells.distinct().count() == 9) { "All Cells must be in the Row $y" }

            valid()
        } catch (e: Throwable) {
            validationFailure(e)
        }
}
