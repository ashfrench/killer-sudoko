package org.ash.french.killer.sudoko.domain

import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
@Serializable
data class CellUpdate(
    val cell: Cell,
    val value: UByte,
) : UpdateID {
    constructor(cell: Cell, value: Int) : this(cell, value.toUByte())
}
