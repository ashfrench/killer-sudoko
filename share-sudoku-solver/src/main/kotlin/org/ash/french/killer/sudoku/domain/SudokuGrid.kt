package org.ash.french.killer.sudoku.domain

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import org.ash.french.killer.sudoku.domain.impl.Cell
import org.ash.french.killer.sudoku.domain.impl.CellRemovePotentialValueFromRegionUpdate
import org.ash.french.killer.sudoku.domain.impl.CellRemovePotentialValueUpdate
import org.ash.french.killer.sudoku.domain.impl.CellState
import org.ash.french.killer.sudoku.domain.impl.CellUpdate
import org.ash.french.killer.sudoku.domain.impl.CellUpdateValue
import org.ash.french.killer.sudoku.domain.impl.CellUpdateValueOriginalValue
import org.ash.french.killer.sudoku.domain.impl.CellValueUpdater
import org.ash.french.killer.sudoku.domain.impl.SudokuFinder
import org.ash.french.killer.sudoku.domain.impl.SudokuStdPrinter
import org.ash.french.killer.sudoku.domain.impl.cells
import java.util.UUID

@Serializable
data class SudokuGrid(
    @Contextual var id: UUID? = null,
    private val cellValues: MutableMap<Cell, CellState> = cells.associateWith { CellState() }.toMutableMap(),
) :
    SudokuGridInterface,
        CellValueFinder by CellValueUpdater(cellValues),
        CellValueSetter by CellValueUpdater(cellValues),
        RowFinder by SudokuFinder,
        ColumnFinder by SudokuFinder,
        NonetFinder by SudokuFinder {
    init {
        require(cellValues.values.all { it.value.inRange1to9() || it.value == null })
    }

    override operator fun contains(cell: Cell) = cells.contains(cell)

    override fun toString() = SudokuStdPrinter.printSudokuString(this)

    fun withOriginalCellValues(cellUpdates: Collection<CellUpdateValueOriginalValue>): SudokuGrid {
        cellUpdates.forEach {
            setCellValue(it.cell, CellState(it.value, locked = true))
        }
        return copy(cellValues = cellValues.toMutableMap())
    }

    fun withCellValues(cellUpdates: Collection<CellUpdate>): SudokuGrid {
        cellUpdates.forEach { update ->
            when (update) {
                is CellRemovePotentialValueFromRegionUpdate -> TODO()
                is CellRemovePotentialValueUpdate -> TODO()
                is CellUpdateValueOriginalValue -> {
                    val cell = update.cell
                    val value = update.value
                    setCellValue(cell, CellState(value, locked = true))
                }

                is CellUpdateValue -> TODO()
            }
        }
        return this
    }
}

fun UByte?.inRange1to9() = this != null && this in (1u..9u)
