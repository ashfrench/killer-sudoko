package org.ash.french.killer.sudoku.domain

internal interface CellValueSetter {
    fun setCellValue(
        x: Int,
        y: Int,
        value: UByte?,
    ) = setCellValue(Cell(x, y), value)

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
