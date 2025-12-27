package org.ash.french.killer.sudoku.domain.impl

import kotlinx.serialization.Serializable
import org.ash.french.killer.sudoku.domain.UpdateID

@Serializable
sealed class CellUpdate : UpdateID

@Serializable
data class CellUpdateValueOriginalValue(
    val cell: Cell,
    val value: UByte,
) : CellUpdate(),
    UpdateID {
    constructor(cell: Cell, value: Int) : this(cell = cell, value = value.toUByte())
    constructor(x: Int, y: Int, value: Int) : this(Cell(x, y), value)
}

@Serializable
data class CellUpdateValue(
    val cell: Cell,
    val value: UByte,
) : CellUpdate(),
    UpdateID {
    constructor(cell: Cell, value: Int) : this(cell = cell, value = value.toUByte())
    constructor(x: Int, y: Int, value: Int) : this(Cell(x, y), value)
}

@Serializable
data class CellRemovePotentialValueUpdate(
    val cell: Cell,
    val value: UByte,
) : CellUpdate(),
    UpdateID {
    constructor(cell: Cell, value: Int) : this(cell = cell, value = value.toUByte())
    constructor(x: Int, y: Int, value: Int) : this(Cell(x, y), value)
}

@Serializable
data class CellRemovePotentialValueFromRegionUpdate(
    val cell: Cell,
    val value: UByte,
) : CellUpdate(),
    UpdateID {
    constructor(cell: Cell, value: Int) : this(cell, value.toUByte())
    constructor(x: Int, y: Int, value: Int) : this(Cell(x, y), value)
}
