package org.ash.french.killer.sudoku.domain

interface CellValueSetter {
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

    fun setCellValue(cellUpdate: CellUpdate): UByte? = setCellValue(cellUpdate.cell, cellUpdate.value)

    fun setCellValues(updates: List<CellUpdate>): List<UByte?> = updates.map { setCellValue(it.cell, it.value) }

    operator fun contains(cell: Cell): Boolean
}
