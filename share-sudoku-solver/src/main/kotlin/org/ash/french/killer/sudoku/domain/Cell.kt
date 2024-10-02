package org.ash.french.killer.sudoku.domain

import kotlinx.serialization.Serializable

@Serializable
data class Cell(val position: GridPosition) : Position by position, Comparable<Cell> {
    constructor(x: UByte, y: UByte) : this(GridPosition(x, y))
    constructor(x: Int, y: Int) : this(GridPosition(x.toUByte(), y.toUByte()))

    override fun compareTo(other: Cell): Int {
        val xCompare = position.x.compareTo(other.position.x)
        val yCompare = position.y.compareTo(other.position.y)
        return xCompare.compareTo(yCompare)
    }
}

private val xRange = (1..9)
private val yRange = (1..9)
val cells: Set<Cell> =
    xRange
        .flatMap { x ->
            yRange
                .map { y -> Cell(x, y) }
        }.toSet()
