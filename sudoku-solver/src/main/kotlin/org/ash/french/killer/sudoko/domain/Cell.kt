package org.ash.french.killer.sudoko.domain

data class Cell(val x: UByte, val y: UByte) {

    constructor(x: Int, y: Int): this(x.toUByte(), y.toUByte())

    init {
        require(x in (1u..9u)) { "X must be a positive Integer between 1 and 9" }
        require(y in (1u..9u)) { "Y must be a positive Integer between 1 and 9" }
    }
}