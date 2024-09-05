package org.ash.french.killer.sudoko.domain

import org.ash.french.killer.sudoko.generators.GridFactory
import org.ash.french.killer.sudoko.solvers.CageFinder
import org.ash.french.killer.sudoko.solvers.CellUpdate
import org.ash.french.killer.sudoko.solvers.CellValueFinder
import org.ash.french.killer.sudoko.solvers.CellValueSetter
import org.ash.french.killer.sudoko.solvers.ColumnFinder
import org.ash.french.killer.sudoko.solvers.NonetFinder
import org.ash.french.killer.sudoko.solvers.RowFinder

data class SudokuGrid(val cells: Set<Cell> = GridFactory.cells) :
    CellValueFinder,
    CellValueSetter,
    RowFinder,
    ColumnFinder,
    NonetFinder,
    CageFinder {
    private val rows = cells.groupBy { it.y }.mapValues { Row(it.key, it.value.toSet()) }

    private val columns = cells.groupBy { it.x }.mapValues { Column(it.key, it.value.toSet()) }

    private val nonets =
        (1..9 step 3)
            .map { x ->
                val nonetCells =
                    (1..9 step 3)
                        .map { y -> Cell(x, y) }
                        .toSet()
                Nonet(nonetCells)
            }

    private val cellValues: MutableMap<Cell, UByte?> = cells.associateWith { null }.toMutableMap()
    private val cageValues: MutableMap<Cage, UByte> = mutableMapOf()

    override fun getCellValue(cell: Cell): UByte? = cellValues[cell]

    override fun setCellValue(
        cell: Cell,
        value: UByte?,
    ): UByte? = cellValues.compute(cell) { _, _ -> value }

    override fun getRow(cell: Cell) = rows[cell.y] ?: throw RuntimeException("Unexpected Cell: $cell - No row found")

    override fun getColumn(cell: Cell) = columns[cell.x] ?: throw RuntimeException("Unexpected Cell: $cell - No Column found")

    override fun getNonet(cell: Cell) = nonets.find { cell in it } ?: throw RuntimeException("No Nonet for Cell $cell")

    override fun getNonet(nonetPosition: Int): Nonet {
        require(nonetPosition in 1..9)

        return nonets[nonetPosition]
    }

    override fun getCages() = cageValues.keys.toSet()

    override fun getCage(cell: Cell): Cage = getCages().first { cell in it }

    override operator fun contains(cell: Cell) = cells.contains(cell)

    fun withCellValues(cellUpdates: Collection<CellUpdate>): SudokuGrid {
        cellUpdates.forEach { (cell, value) ->
            setCellValue(cell, value)
        }
        return this
    }

    fun withCages(cages: Map<Cage, UByte>): SudokuGrid {
        val sudokuGrid = copy()
        sudokuGrid.cageValues.putAll(cages)

        return sudokuGrid
    }
}
