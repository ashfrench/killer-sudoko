package org.ash.french.killer.sudoku.domain

import kotlinx.serialization.Serializable

val nonets =
    (1..9 step 3)
        .map { x ->
            val nonetCells =
                (1..9 step 3)
                    .map { y -> Cell(x, y) }
                    .toSet()
            Nonet(nonetCells)
        }

@Serializable
data class Nonet(override val cells: Set<Cell>) : Region {
    init {
        this.validate().getOrThrow()
    }

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
