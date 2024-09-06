package org.ash.french.killer.sudoko.domain

import kotlinx.serialization.Serializable

@Serializable
data class Row(val y: UByte, override val cells: Set<Cell>) : Region(cells) {
    override fun validate(): SudokuValidation {
        return try {
            require(y in (1u..9u)) { "Y must be a positive Integer between 1 and 9" }
            require(cells.any { it.y == y }) { "All Cells must be in the Row $y" }
            require(cells.distinct().count() == 9) { "All Cells must be in the Row $y" }

            valid()
        } catch (e: Throwable) {
            validationFailure(e)
        }
    }
}

@Serializable
data class Column(val x: UByte, override val cells: Set<Cell>) : Region(cells) {
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

@Serializable
data class Nonet(override val cells: Set<Cell>) : Region(cells) {
    override fun validate(): Result<Boolean> {
        return try {
            val groupByX = cells.groupBy { it.x }
            val groupByY = cells.groupBy { it.y }

            require(groupByX.all { it.value.count() == 3 }) { "All groups of X cells should only have 3" }
            require(groupByY.all { it.value.count() == 3 }) { "All groups of Y cells should only have 3" }

            valid()
        } catch (e: Throwable) {
            validationFailure(e)
        }
    }
}

@Serializable
data class Cage(override val sum: UByte, override val cells: Set<Cell>) : Region(sum, cells) {
    init {
        require(sum in 1u..45u) { "Invalid Sum for Cage of size ${cells.size}" }
    }

    override fun validate(): Result<Boolean> {
        return validate()
    }
}
