package org.ash.french.killer.sudoko.builders

import org.ash.french.killer.sudoko.domain.Cell
import org.ash.french.killer.sudoko.domain.CellUpdate
import org.ash.french.killer.sudoko.domain.SudokuGrid
import kotlin.uuid.ExperimentalUuidApi

@OptIn(ExperimentalUuidApi::class)
class SudokuCellValueBuilder(private var sudokuGrid: SudokuGrid) : SudokuBuilder<CellUpdate> {
    constructor(x: Int, y: Int, value: Int?, sudokuGrid: SudokuGrid) : this(sudokuGrid.copy()) {
        sudokuGrid.cellValue(Cell(x, y), value?.toUByte())
    }

    var x: Int = 1
    var y: Int = 1
    var value: Int? = null

    override fun build(): CellUpdate {
        val grid = sudokuGrid.copy()
        val cell = Cell(x, y)
        grid.cellValue(cell, value?.toUByte())

        return CellUpdate(cell, value!!)
    }
}
