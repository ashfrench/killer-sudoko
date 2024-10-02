package org.ash.french.killer.sudoku.domain

import kotlinx.serialization.Serializable

@Serializable
data class CellValueUpdater(private val cellValues: MutableMap<Cell, CellState>) : CellValueFinder, CellValueSetter {
    private val updates = mutableListOf<CellUpdate>()

    override fun getCell(
        x: UByte,
        y: UByte,
    ): Cell {
        return cells.firstOrNull { cell -> cell.x == x && cell.y == y } ?: throw RuntimeException("Cell Not Found")
    }

    override fun getCellValue(cell: Cell): CellState = cellValues[cell] ?: throw RuntimeException("Cell Not Found")

    override fun setCellValue(
        cell: Cell,
        value: CellState,
    ): Cell {
        cellValues.compute(cell) { _, _ ->
            value
        }
        return cell
    }

    override fun lockCellValue(
        cell: Cell,
        value: UByte,
    ): Cell {
        cellValues.compute(cell) { _, cellState ->
            cellState?.copy(value = value, locked = true) ?: CellState(value, locked = true)
        }
        return cell
    }

    override operator fun contains(cell: Cell) = cellValues.contains(cell)

    override fun getAllCellValues(): Map<Cell, CellState> {
        val allCellValues =
            cellValues
                .mapValues { it.value }

        return allCellValues
    }

    override fun getSetCellValues(): List<CellUpdate> {
        return updates.toList()
    }
}
