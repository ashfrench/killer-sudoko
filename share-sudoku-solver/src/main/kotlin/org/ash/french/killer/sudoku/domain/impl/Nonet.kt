package org.ash.french.killer.sudoku.domain.impl

import kotlinx.serialization.Serializable

val groupByX = cells.groupBy { it.x }
val groupByY = cells.groupBy { it.y }

val nonets =
    (1..9)
        .chunked(3)
        .flatMap { xList ->
            (1..9)
                .chunked(3)
                .map { yList ->
                    xList.flatMap { x ->
                        yList.map { y ->
                            Cell(x, y)
                        }
                    }
                }
        }
        .map { Nonet(it.toSet()) }

@Serializable
data class Nonet(
    override val cells: Set<Cell>
) : Region {
    init {
        this.validate().getOrThrow()
    }

    override fun validate(): Result<Boolean> =
        try {
            val groupByX = cells.groupBy { it.x }
            val groupByY = cells.groupBy { it.y }

            require(groupByX.all { it.value.count() == 3 }) { "All groups of X cells should only have 3" }
            require(groupByY.all { it.value.count() == 3 }) { "All groups of Y cells should only have 3" }

            valid()
        } catch (e: Throwable) {
            validationFailure(e)
        }
}
