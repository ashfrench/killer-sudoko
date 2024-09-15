package org.ash.french.killer.sudoku.domain

object CellValueUpdater : CellValueFinder, CellValueSetter {
    private val cellValues: MutableMap<Cell, UByte?> = cells.associateWith { null }.toMutableMap()

    override fun getCellValue(cell: Cell): UByte? = cellValues[cell]

    override fun setCellValue(
        cell: Cell,
        value: UByte?,
    ): UByte? = cellValues.compute(cell) { _, _ -> value }

    override operator fun contains(cell: Cell) = cells.contains(cell)

    override fun getAllCellValues(): Map<Cell, UByte> {
        val allCellValues =
            cellValues
                .filterValues { it != null }
                .mapValues { it.value!! }

        return allCellValues
    }

    override fun getPresetCellValues(): List<CellUpdate> {
        TODO("Not yet implemented")
    }
}
