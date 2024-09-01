package org.ash.french.killer.sudoko.solvers

import org.ash.french.killer.sudoko.domain.Cell

interface CellValueFinder {
    fun getCellValue(cell: Cell): UByte?

    @Suppress("unused")
    fun getCellValue(
        x: Int,
        y: Int,
    ) = getCellValue(Cell(x, y))

    @Suppress("unused")
    fun getCellValue(
        x: UByte,
        y: UByte,
    ) = getCellValue(Cell(x, y))

    operator fun contains(cell: Cell): Boolean
}
