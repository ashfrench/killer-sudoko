package org.ash.french.killer.sudoku.domain

import kotlinx.serialization.Serializable

@Serializable
data class Cage(override val sum: UByte, override val cells: Set<Cell>) : Region {
    init {
        require(sum in 1u..45u) { "Invalid Sum for Cage of size ${cells.size}" }
        require(cells.size in 1..9) { "A cage must contain between 1 and 9 cells" }
        validateCageSum(sum, cells)
    }

    private fun validateCageSum(sum: UByte, cells: Set<Cell>) {
        val intSum = sum.toInt()
        val valid = when (cells.size) {
            1 -> intSum in 1..9
            2 -> intSum in 2..17
            3 -> intSum in 6..24
            4 -> intSum in 10..30
            5 -> intSum in 15..35
            6 -> intSum in 21..39
            7 -> intSum in 28..42
            8 -> intSum in 36..44
            9 -> intSum in 45..45
            else -> false
        }
        require(valid) { "Invalid cage sum $sum for size ${cells.size}" }
    }

    override fun validate(): Result<Boolean> {
        return validate()
    }
}
