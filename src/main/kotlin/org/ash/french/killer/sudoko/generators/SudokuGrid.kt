package org.ash.french.killer.sudoko.generators

import org.ash.french.killer.sudoko.domain.Cell
import org.ash.french.killer.sudoko.domain.Column
import org.ash.french.killer.sudoko.domain.Nonet
import org.ash.french.killer.sudoko.domain.Row

data class SudokuGrid(val cells: Set<Cell> = generateSudokuCells()) {

    val rows = cells.groupBy { it.y }.mapValues() { Row(it.key, it.value.toSet()) }
    val columns = cells.groupBy { it.x }.mapValues() { Column(it.key, it.value.toSet()) }

    val nonets = (1..9 step 3).map { x ->
        val nonetCells = (1..9 step 3).map { y ->
            Cell(x, y)
        }.toSet()
        Nonet(nonetCells)
    }.toSet()

    private val cellValues: MutableMap<Cell, UByte?> = cells.associateWith { null }.toMutableMap()

    fun getCellValue(cell: Cell): UByte? = cellValues[cell]
    fun getCellValue(x: Int, y: Int) = getCellValue(Cell(x, y))
    fun getCellValue(x: UByte, y: UByte) = getCellValue(Cell(x, y))

    fun getRow(cell: Cell) = rows[cell.y]?: throw RuntimeException("Unexpected Cell: $cell - No rows found")
    fun getRow(y: UByte) = rows[y]?: throw RuntimeException("Unexpected Y: $y - No rows found")
    fun getRow(y: Int) = rows[y.toUByte()]?: throw RuntimeException("Unexpected Y: $y - No rows found")

    fun getColumn(cell: Cell) = rows[cell.y]?: throw RuntimeException("Unexpected Cell: $cell - No rows found")
    fun getColumn(x: UByte) = rows[x]?: throw RuntimeException("Unexpected Y: $x - No rows found")
    fun getColumn(x: Int) = rows[x.toUByte()]?: throw RuntimeException("Unexpected Y: $x - No rows found")

    fun updateCell(cell: Cell, value: UByte?): CellUpdate {
        if (cellValues.containsKey(cell) ) {

        } else {
            cellValues.compute(cell) { _, oldValue -> value }
        }
        TODO()
    }

    companion object {
        val EMPTY_SUDOKU_GRID = SudokuGrid()
    }

}