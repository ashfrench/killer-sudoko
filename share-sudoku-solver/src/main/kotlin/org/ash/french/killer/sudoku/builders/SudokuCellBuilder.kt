package org.ash.french.killer.sudoku.builders

import org.ash.french.killer.sudoku.domain.impl.Cell

class SudokuCellBuilder : SudokuBuilder<Cell> {
    var x: Int = 1
    var y: Int = 1
    var value: Int? = null

    override fun build(): Cell = Cell(x, y)
}
