package org.ash.french.killer.sudoku.domain

import kotlinx.serialization.Serializable

@Serializable
data class CellValueUpdater(private val cellValues: MutableMap<Cell, UByte?>) : CellValueFinder, CellValueSetter {
    private val setCells: MutableMap<Cell, CellUpdate> =
        cellValues
            .filterValues { it != null }
            .mapValues { CellUpdateValue(it.key, it.value!!) }
            .toMutableMap()

    private val potentialCellValues =
        cells
            .associateWith {
                val cellValue = cellValues[it]?.toInt()
                val list =
                    if (cellValue == null) {
                        listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
                    } else {
                        listOf(cellValue)
                    }
                list
            }.toMutableMap()

    private fun updatePotentialValues(
        cell: Cell,
        value: UByte,
    ) {
        updatePotentialValues(cell, value.toInt())
    }

    private fun updatePotentialValues(
        cell: Cell,
        value: Int,
    ) {
        val row = SudokuFinder.getRow(cell)
        val column = SudokuFinder.getColumn(cell)
        val nonet = SudokuFinder.getNonet(cell)

        potentialCellValues[cell] = listOf(value)

        row.updatePotentialValues(cell, value)
        column.updatePotentialValues(cell, value)
        nonet.updatePotentialValues(cell, value)
    }

    private fun Region.updatePotentialValues(
        cell: Cell,
        value: Int,
    ) {
        cells
            .filter { it != cell }
            .mapNotNull {
                val potentialValues = potentialCellValues[it]
                if (potentialValues == null) {
                    null
                } else {
                    it to potentialValues
                }
            }.forEach { (cell, potentialValues) ->
                val filter = potentialValues.filterNot { potentialValue -> potentialValue == value }
                potentialCellValues[cell] = filter
            }
    }

    override fun getCellValue(cell: Cell): UByte? = cellValues[cell]

    override fun setCellValue(
        cell: Cell,
        value: UByte?,
    ): UByte? {
        return cellValues.compute(cell) { _, _ ->
            if (value != null) {
                setCells[cell] = CellUpdateValue(cell, value)
                updatePotentialValues(cell, value)
            }
            value
        }
    }

    override operator fun contains(cell: Cell) = cells.contains(cell)

    override fun getAllCellValues(): Map<Cell, UByte> {
        val allCellValues =
            cellValues
                .filterValues { it != null }
                .mapValues { it.value!! }

        return allCellValues
    }

    override fun getSetCellValues(): List<CellUpdate> {
        return setCells.values.toList()
    }
}
