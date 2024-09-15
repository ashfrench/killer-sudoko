package org.ash.french.killer.sudoku.domain

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class KillerSudokuGrid(
    @Contextual var id: UUID? = null,
) : KillerSudokuGridInterface,
    CellValueFinder by CellValueUpdater,
    CellValueSetter by CellValueUpdater,
    RowFinder by SudokuFinder,
    ColumnFinder by SudokuFinder,
    NonetFinder by SudokuFinder {
    private val cageValues: MutableMap<Cage, UByte> = mutableMapOf()

    override fun getCages() = cageValues.keys.toSet()

    override fun getCage(cell: Cell): Cage = getCages().first { cell in it }

    override operator fun contains(cell: Cell) = cells.contains(cell)

    override fun toString() = SudokuStdPrinter.printSudokuString(this)

    fun withCellValues(cellUpdates: Collection<CellUpdate>): KillerSudokuGrid {
        cellUpdates.forEach { (cell, value) ->
            setCellValue(cell, value)
        }
        return this
    }
}
