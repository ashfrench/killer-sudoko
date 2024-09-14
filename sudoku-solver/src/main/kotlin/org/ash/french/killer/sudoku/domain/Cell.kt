package org.ash.french.killer.sudoku.domain

import kotlinx.serialization.Serializable

private val xRange = (1..9)
private val yRange = (1..9)
val cells: Set<Cell> =
    xRange
        .flatMap { x ->
            yRange
                .map { y -> Cell(x, y) }
        }.toSet()

@Serializable
data class Cell(val x: UByte, val y: UByte) {
    constructor(x: Int, y: Int) : this(x.toUByte(), y.toUByte())

    init {
        require(x in (1u..9u)) { "X must be a positive Integer between 1 and 9" }
        require(y in (1u..9u)) { "Y must be a positive Integer between 1 and 9" }
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
