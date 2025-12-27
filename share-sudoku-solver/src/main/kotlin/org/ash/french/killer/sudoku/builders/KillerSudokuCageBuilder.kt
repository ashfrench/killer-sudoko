package org.ash.french.killer.sudoku.builders

import org.ash.french.killer.sudoku.domain.impl.Cage
import org.ash.french.killer.sudoku.domain.impl.Cell

class KillerSudokuCageBuilder : SudokuBuilder<Cage> {
    var cageSum: Int = 0
    val cells: MutableSet<Cell> = mutableSetOf()

    fun cell(init: SudokuCellBuilder.() -> Unit) {
        val builder = SudokuCellBuilder()
        builder.init()
        cells.add(builder.build())
    }

    override fun build(): Cage = Cage(cageSum, cells)
}
