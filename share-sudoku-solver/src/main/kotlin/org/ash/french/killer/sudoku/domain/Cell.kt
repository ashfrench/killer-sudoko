package org.ash.french.killer.sudoku.domain

import kotlinx.serialization.Serializable

@Serializable
data class Cell(
    val x: UByte,
    val y: UByte,
    val value: UByte? = null,
    var error: Boolean = false,
    var locked: Boolean = false,
) {
    constructor(x: Int, y: Int) : this(x.toUByte(), y.toUByte())

    init {
        require(x.inRange1to9()) { "X must be a positive Integer between 1 and 9" }
        require(y.inRange1to9()) { "Y must be a positive Integer between 1 and 9" }
        require(value != null && value.inRange1to9()) {"When set value must be between 1 and 9"}
    }
}

private fun UByte.inRange1to9() = this in (1u..9u)

private val xRange = (1..9)
private val yRange = (1..9)
val cells: Set<Cell> =
    xRange
        .flatMap { x ->
            yRange
                .map { y -> Cell(x, y) }
        }.toSet()
