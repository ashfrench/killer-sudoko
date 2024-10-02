package org.ash.french.killer.sudoku.domain

import kotlinx.serialization.Serializable

@Serializable
data class CellValueUpdater(private val cellValues: MutableMap<Cell, CellState>) : CellValueFinder, CellValueSetter {
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

//        potentialCellValues[cell] = listOf(value)

        row.updatePotentialValues(cell, value)
        column.updatePotentialValues(cell, value)
        nonet.updatePotentialValues(cell, value)
    }

    private fun Region.updatePotentialValues(
        cell: Cell,
        value: Int,
    ) {

    }

    override fun getCell(x: UByte, y: UByte): Cell {
        return cells.firstOrNull { cell -> cell.x == x && cell.y == y }?: throw RuntimeException("Cell Not Found")
    }

    override fun getCellValue(cell: Cell): CellState = cellValues[cell]?: throw RuntimeException("Cell Not Found")

    override fun setCellValue(
        cell: Cell,
        value: UByte?,
    ): Cell {
//        cellValues.compute(cell) { _, _ ->
//            if (value != null) {
//                setCells[cell] = CellUpdateValue(cell, value)
//                updatePotentialValues(cell, value)
//            }
//            value
//        }
        return getCell(cell.x, cell.y)
    }

    override fun lockCellValue(cell: Cell, value: UByte): Cell {
        TODO("Not yet implemented")
    }

    override operator fun contains(cell: Cell) = cells.contains(cell)

    override fun getAllCellValues(): Map<Cell, CellState> {
        val allCellValues =
            cellValues
                .mapValues { it.value }

        return allCellValues
    }

    override fun getSetCellValues(): List<CellUpdate> {
        TODO()
    }
}
