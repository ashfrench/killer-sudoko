package org.ash.french.killer.sudoko.solvers

import org.ash.french.killer.sudoko.domain.Cell

interface CellValueSetter {
    @Suppress("unused")
    fun setCellValue(
        x: Int,
        y: Int,
        value: UByte?,
    ) = setCellValue(Cell(x, y), value)

    @Suppress("unused")
    fun setCellValue(
        x: UByte,
        y: UByte,
        value: UByte?,
    ): UByte? = setCellValue(Cell(x, y), value)

    fun setCellValue(
        cell: Cell,
        value: UByte?,
    ): UByte?

    operator fun contains(cell: Cell): Boolean
}
