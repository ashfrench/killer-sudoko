package org.ash.french.killer.sudoku.domain

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.StringJoiner
import java.util.UUID

private val xRange = (1..9)
private val yRange = (1..9)
private val cells: Set<Cell> =
    xRange
        .flatMap { x ->
            yRange
                .map { y -> Cell(x, y) }
        }.toSet()

private val nonets =
    (1..9 step 3)
        .map { x ->
            val nonetCells =
                (1..9 step 3)
                    .map { y -> Cell(x, y) }
                    .toSet()
            Nonet(nonetCells)
        }

@Serializable
internal data class SudokuGrid(
    @Contextual var id: UUID? = null,
) :
    CellValueFinder,
        CellValueSetter,
        RowFinder,
        ColumnFinder,
        NonetFinder,
        CageFinder {
    private val rows = cells.groupBy { it.y }.mapValues { Row(it.key, it.value.toSet()) }

    private val columns = cells.groupBy { it.x }.mapValues { Column(it.key, it.value.toSet()) }

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

    override fun toString(): String {
        val stringJoiner = StringJoiner("|| ")
        stringJoiner.add("")
        (1..9)
            .forEach { y ->
                val rowJoiner = StringJoiner(" | ")
                (1..9).forEach { x ->
                    val cell = Cell(x, y)
                    val value = getCellValue(cell)
                    rowJoiner.add(value?.toString() ?: " ")
                }
                stringJoiner.add("$rowJoiner")
                stringJoiner.add(" \n")
            }
        return stringJoiner.toString()
    }

    fun withCellValues(cellUpdates: Collection<CellUpdate>): SudokuGrid {
        cellUpdates.forEach { (cell, value) ->
            setCellValue(cell, value)
        }
        return this
    }
}
