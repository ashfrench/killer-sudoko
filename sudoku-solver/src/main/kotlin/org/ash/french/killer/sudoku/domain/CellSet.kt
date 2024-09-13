package org.ash.french.killer.sudoku.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("CellSet")
internal sealed interface CellSet {
    val cells: Set<Cell>

    fun validate(): SudokuValidation {
        return try {
            require(cells.size == 9) { "${this.javaClass.canonicalName} must contain 9 cells" }
            valid()
        } catch (e: Throwable) {
            validationFailure(e)
        }
    }

    fun cellValues(grid: SudokuGrid): Map<Cell, UByte> = grid.getAllCellValues().filterKeys { it in cells }

    operator fun contains(element: Cell) = cells.contains(element)
}

@Serializable
internal sealed interface Region : CellSet {
    val sum: UByte
        get() = 45u

    override fun validate(): Result<Boolean> {
        return try {
            require(cells.count() in 1..9) { "Number of cells in a cage must be between 1 and 9" }
            valid()
        } catch (e: Throwable) {
            validationFailure(e)
        }
    }
}
