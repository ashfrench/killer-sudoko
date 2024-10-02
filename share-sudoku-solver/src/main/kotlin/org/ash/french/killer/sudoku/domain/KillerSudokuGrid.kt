package org.ash.french.killer.sudoku.domain

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class KillerSudokuGrid(
    @Contextual var id: UUID? = null,
    private val cellValues: MutableMap<Cell, CellState> = cells.associateWith { CellState() }.toMutableMap(),
    private val cageValues: MutableMap<Cage, CellState> = mutableMapOf(),
) : KillerSudokuGridInterface,
    CellValueFinder by CellValueUpdater(cellValues),
    CellValueSetter by CellValueUpdater(cellValues),
    RowFinder by SudokuFinder,
    ColumnFinder by SudokuFinder,
    NonetFinder by SudokuFinder {
    override fun getCages() = cageValues.keys.toSet()

    override fun getCage(cell: Cell): Cage = getCages().first { cell in it }

    override operator fun contains(cell: Cell) = cells.contains(cell)

    override fun toString() = SudokuStdPrinter.printSudokuString(this)

    fun withKillerSudokuUpdates(updates: Collection<KillerSudokuUpdate>): KillerSudokuGrid {
        updates.map {
            when (it) {
                is KillerSudokuCellUpdate -> this.setCellValue(it.cell, it.value)
                is RemovePotentialCageValues -> TODO()
                is RemovePotentialCellValue -> TODO()
            }
        }
        return this
    }
}
