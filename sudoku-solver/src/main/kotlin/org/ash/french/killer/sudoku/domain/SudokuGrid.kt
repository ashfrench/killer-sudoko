package org.ash.french.killer.sudoku.domain

import java.util.UUID

data class SudokuGrid(var id: UUID? = null) :
    SudokuGridInterface,
    CellValueFinder by CellValueUpdater,
    CellValueSetter by CellValueUpdater,
    RowFinder by SudokuFinder,
    ColumnFinder by SudokuFinder,
    NonetFinder by SudokuFinder {
    override operator fun contains(cell: Cell) = cells.contains(cell)

    override fun toString() = SudokuStdPrinter.printSudokuString(this)

    fun withCellValues(cellUpdates: Collection<CellUpdate>): SudokuGrid {
        cellUpdates.forEach { (cell, value) ->
            setCellValue(cell, value)
        }
        return this
    }
}
