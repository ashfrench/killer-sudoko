package org.ash.french.killer.sudoku.domain

import kotlinx.serialization.Serializable

@Serializable
data class Cage(override val sum: UByte, override val cells: Set<Cell>) : Region {
    init {
        this.validate().getOrThrow()
    }

    private fun validateCells(cells: Set<Cell>) {
        if (cells.size == 1) {
            return
        }

        val cellRows = cells.associateBy { it.x.toInt() }
        val cellCols = cells.associateBy { it.y.toInt() }

        when (cells.size) {
            2 -> TODO()
            3 -> TODO()
            4 -> TODO()
            5 -> TODO()
            6 -> TODO()
            7 -> TODO()
            8 -> TODO()
            9 -> TODO()
        }
    }

    private fun validateCageSum(
        sum: UByte,
        cells: Set<Cell>,
    ) {
        val intSum = sum.toInt()
        val valid = cells.size.isValidCageSum(intSum)
        require(valid) { "Invalid cage sum $sum for size ${cells.size}" }
    }

    private fun Int.isValidCageSum(sum: Int): Boolean {
        return when (this) {
            1 -> sum in 1..9
            2 -> sum in 2..17
            3 -> sum in 6..24
            4 -> sum in 10..30
            5 -> sum in 15..35
            6 -> sum in 21..39
            7 -> sum in 28..42
            8 -> sum in 36..44
            9 -> sum in 45..45
            else -> false
        }
    }

    override fun validate(): Result<Boolean> {
        return try {
            require(sum in 1u..45u) { "Invalid Sum for Cage of size ${cells.size}" }
            require(cells.size in 1..9) { "A cage must contain between 1 and 9 cells" }
            validateCageSum(sum, cells)
            validateCells(cells)

            valid()
        } catch (e: Throwable) {
            validationFailure(e)
        }
    }
}
