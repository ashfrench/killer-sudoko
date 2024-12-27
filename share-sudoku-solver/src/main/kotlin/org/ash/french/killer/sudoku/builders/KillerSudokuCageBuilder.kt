package org.ash.french.killer.sudoku.builders

import org.ash.french.killer.sudoku.domain.impl.Cage

class KillerSudokuCageBuilder : SudokuBuilder<Cage> {

    var cageSum: Int = 0

    fun cell(init: SudokuCellBuilder.() -> Unit) {

    }

    override fun build(): Cage {
        TODO("Not yet implemented")
    }
}
