package org.ash.french.killer.sudoku.domain

import kotlinx.serialization.Serializable

@Serializable
data class Cell(
    val position: GridPosition,
    var error: Boolean = false,
    var locked: Boolean = false,
) : Position by position {
    constructor(x: UByte, y: UByte) : this(GridPosition(x, y))
    constructor(x: Int, y: Int) : this(GridPosition(x.toUByte(), y.toUByte()))
}

private val xRange = (1..9)
private val yRange = (1..9)
val cells: Set<Cell> =
    xRange
        .flatMap { x ->
            yRange
                .map { y -> Cell(x, y) }
        }.toSet()
