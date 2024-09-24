package org.ash.french.killer.sudoku.domain

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class SudokuGrid(
    @Contextual var id: UUID? = null,
    private val cellValues: MutableMap<Cell, UByte?> = cells.associateWith { null }.toMutableMap(),
) :
    SudokuGridInterface,
        CellValueFinder by CellValueUpdater(cellValues),
        CellValueSetter by CellValueUpdater(cellValues),
        RowFinder by SudokuFinder,
        ColumnFinder by SudokuFinder,
        NonetFinder by SudokuFinder {
    override operator fun contains(cell: Cell) = cells.contains(cell)

    override fun toString() = SudokuStdPrinter.printSudokuString(this)

    fun withCellValues(cellUpdates: Collection<CellUpdate>): SudokuGrid {
        cellUpdates.forEach { update ->
            val cell = update.cell
            val value = update.value
            setCellValue(cell, value)
        }
        return this
    }
}
