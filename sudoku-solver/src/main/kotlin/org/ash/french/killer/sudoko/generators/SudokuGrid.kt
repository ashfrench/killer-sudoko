package org.ash.french.killer.sudoko.generators

import org.ash.french.killer.sudoko.domain.*
import org.ash.french.killer.sudoko.solvers.CellValueFinder
import org.ash.french.killer.sudoko.solvers.ColumnFinder
import org.ash.french.killer.sudoko.solvers.NonetFinder
import org.ash.french.killer.sudoko.solvers.RowFinder

data class SudokuGrid(val cells: Set<Cell> = generateSudokuCells()): CellValueFinder, RowFinder, ColumnFinder, NonetFinder {

    private val rows = cells.groupBy { it.y }.mapValues() { Row(it.key, it.value.toSet()) }
    private val columns = cells.groupBy { it.x }.mapValues() { Column(it.key, it.value.toSet()) }
    private val nonets = (1..9 step 3).map { x ->
        val nonetCells = (1..9 step 3).map { y ->
            Cell(x, y)
        }.toSet()
        Nonet(nonetCells)
    }

    private val cellValues: MutableMap<Cell, UByte?> = cells.associateWith { null }.toMutableMap()
    private val cageValues: MutableMap<Cage, UByte> = mutableMapOf()

    override fun getCellValue(cell: Cell): UByte? = cellValues[cell]
    override fun getRow(cell: Cell) = rows[cell.y]?: throw RuntimeException("Unexpected Cell: $cell - No row found")
    override fun getColumn(cell: Cell) = columns[cell.x]?: throw RuntimeException("Unexpected Cell: $cell - No Column found")
    override fun getNonet(cell: Cell) = nonets.find { cell in it } ?: throw RuntimeException("No Nonet for Cell $cell")
    override fun getNonet(nonetPosition: Int): Nonet {
        require(nonetPosition in 1..9)
        return nonets[nonetPosition]
    }

    override operator fun contains(cell: Cell) = cells.contains(cell)

    @Suppress("UNUSED")
    fun updateCell(cell: Cell, value: UByte?): CellUpdate {
        if (cell !in this) {
            return CellUpdate.failure(RuntimeException("Cell $cell does not exist in this Grid"))
        }

        cellValues.compute(cell) { _, _ -> value }
        TODO()
    }

    fun withCages(cages: Map<Cage, UByte>): SudokuGrid {
        val sudokuGrid = copy()
        sudokuGrid.cageValues.putAll(cages)

        return sudokuGrid
    }
}