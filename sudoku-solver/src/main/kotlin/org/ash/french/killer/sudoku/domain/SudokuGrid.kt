package org.ash.french.killer.sudoku.domain

import java.util.StringJoiner
import java.util.UUID

data class SudokuGrid(var id: UUID? = null) :
    CellValueFinder by CellValueUpdater,
    CellValueSetter by CellValueUpdater,
    RowFinder,
    ColumnFinder,
    NonetFinder {
    private val rows = cells.groupBy { it.y }.mapValues { Row(it.key, it.value.toSet()) }

    private val columns = cells.groupBy { it.x }.mapValues { Column(it.key, it.value.toSet()) }

    private val cageValues: MutableMap<Cage, UByte> = mutableMapOf()

    override fun getRow(cell: Cell) = rows[cell.y] ?: throw RuntimeException("Unexpected Cell: $cell - No row found")

    override fun getColumn(cell: Cell) = columns[cell.x] ?: throw RuntimeException("Unexpected Cell: $cell - No Column found")

    override fun getNonet(cell: Cell) = nonets.find { cell in it } ?: throw RuntimeException("No Nonet for Cell $cell")

    override fun getNonet(nonetPosition: Int): Nonet {
        require(nonetPosition in 1..9)

        return nonets[nonetPosition]
    }

    override operator fun contains(cell: Cell) = cells.contains(cell)

    override fun toString(): String {
        val columnJoiner = StringJoiner("")
        (1..9)
            .forEach { y ->
                columnJoiner.add("||-------------------------------------||\n")
                if (y % 3 == 1) {
                    columnJoiner.add("||-------------------------------------||\n")
                }
                val rowJoiner = StringJoiner("|")
                columnJoiner.add("||")
                (1..9).forEach { x ->
                    val cell = Cell(x, y)
                    val value = getCellValue(cell)
                    val valueString = value?.toString() ?: " "
                    rowJoiner.add(" $valueString ")

                    if (x % 3 == 0 && x != 9) {
                        rowJoiner.add("")
                    }
                }
                columnJoiner.add("$rowJoiner")
                columnJoiner.add("||\n")
            }
        columnJoiner.add("||-------------------------------------||\n")
        columnJoiner.add("||-------------------------------------||")

        return columnJoiner.toString()
    }

    fun withCellValues(cellUpdates: Collection<CellUpdate>): SudokuGrid {
        cellUpdates.forEach { (cell, value) ->
            setCellValue(cell, value)
        }
        return this
    }
}
