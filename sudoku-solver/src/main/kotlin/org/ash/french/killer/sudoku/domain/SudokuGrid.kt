package org.ash.french.killer.sudoku.domain

import java.util.StringJoiner
import java.util.UUID

data class SudokuGrid(var id: UUID? = null) :
    CellValueFinder by CellValueUpdater,
    CellValueSetter by CellValueUpdater,
    RowFinder by SudokuFinder,
    ColumnFinder by SudokuFinder,
    NonetFinder by SudokuFinder {
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
