package org.ash.french.killer.sudoku.domain

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
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
//        require(cellValues.values.all { it.value.inRange1to9() })
    }

    override operator fun contains(cell: Cell) = cells.contains(cell)

    override fun toString() = SudokuStdPrinter.printSudokuString(this)

    fun withOriginalCellValues(cellUpdates: Collection<CellUpdateValue>): SudokuGrid {
        return copy(cellValues = cellValues.toMutableMap())
    }

    fun withCellValues(cellUpdates: Collection<CellUpdate>): SudokuGrid {
        cellUpdates.forEach { update ->
            when (update) {
                is CellRemovePotentialValueFromRegionUpdate -> TODO()
                is CellRemovePotentialValueUpdate -> TODO()
                is CellUpdateValue -> {
                    val cell = update.cell
                    val value = update.value
                    setCellValue(cell, value)
                }
            }
        }
        return this
    }
}

fun UByte?.inRange1to9() = this != null && this in (1u..9u)
