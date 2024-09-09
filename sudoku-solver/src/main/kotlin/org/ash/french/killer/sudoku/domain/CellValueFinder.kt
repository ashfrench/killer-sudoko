package org.ash.french.killer.sudoku.domain

import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
interface CellValueFinder {
    fun getCellValue(cell: Cell): UByte?

    fun getCellValue(
        x: Int,
        y: Int,
    ) = getCellValue(Cell(x, y))

    fun getCellValue(
        x: UByte,
        y: UByte,
    ) = getCellValue(Cell(x, y))

    operator fun contains(cell: Cell): Boolean

    fun getPresetCellValues(): List<CellUpdate>
}
