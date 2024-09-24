package org.ash.french.killer.sudoku.domain

import kotlinx.serialization.Serializable

@Serializable
sealed class CellUpdate(
    open val cell: Cell,
    open val value: UByte,
) : UpdateID {
    constructor(cell: Cell, value: Int) : this(cell, value.toUByte())
    constructor(x: Int, y: Int, value: Int) : this(Cell(x, y), value)
}

data class CellUpdateValue(
    override val cell: Cell,
    override val value: UByte,
) : CellUpdate(cell, value), UpdateID {
    constructor(cell: Cell, value: Int) : this(cell, value.toUByte())
    constructor(x: Int, y: Int, value: Int) : this(Cell(x, y), value)
}

data class CellRemovePotentialValueUpdate(
    override val cell: Cell,
    override val value: UByte,
) : CellUpdate(cell, value), UpdateID {
    constructor(cell: Cell, value: Int) : this(cell, value.toUByte())
    constructor(x: Int, y: Int, value: Int) : this(Cell(x, y), value)
}
