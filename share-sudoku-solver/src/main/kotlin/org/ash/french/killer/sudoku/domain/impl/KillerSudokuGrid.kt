package org.ash.french.killer.sudoku.domain.impl

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import org.ash.french.killer.sudoku.domain.CellValueFinder
import org.ash.french.killer.sudoku.domain.CellValueSetter
import org.ash.french.killer.sudoku.domain.ColumnFinder
import org.ash.french.killer.sudoku.domain.KillerSudokuGridInterface
import org.ash.french.killer.sudoku.domain.NonetFinder
import org.ash.french.killer.sudoku.domain.RowFinder
import java.util.UUID

@Serializable
data class KillerSudokuGrid(
    @Contextual var id: UUID? = null,
    private val cellValues: MutableMap<Cell, CellState> = cells.associateWith { CellState() }.toMutableMap(),
    private val cages: MutableSet<Cage> = mutableSetOf(),
) : KillerSudokuGridInterface,
    CellValueFinder by CellValueUpdater(cellValues),
    CellValueSetter by CellValueUpdater(cellValues),
    RowFinder by SudokuFinder,
    ColumnFinder by SudokuFinder,
    NonetFinder by SudokuFinder {
    override fun getCages() = cages.toSet()

    override fun getCage(cell: Cell): Cage =
        getCages()
            .firstOrNull { cell in it }
            ?: throw NoSuchElementException("No Cage for $cell")

    override operator fun contains(cell: Cell) = cells.contains(cell)

    override fun toString() = SudokuStdPrinter.printSudokuString(this)

    fun withKillerSudokuUpdates(updates: Collection<KillerSudokuUpdate>): KillerSudokuGrid {
        updates.map {
            when (it) {
                is KillerSudokuCellUpdate -> this.setCellValue(it.cell, CellState(it.value))
                is RemovePotentialCageValues -> TODO()
                is RemovePotentialCellValue -> TODO()
            }
        }
        return this
    }

    fun withCage(cage: Cage) {
        cages.add(cage)
    }
}
