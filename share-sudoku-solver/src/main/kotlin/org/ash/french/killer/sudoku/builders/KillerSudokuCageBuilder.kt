package org.ash.french.killer.sudoku.builders

import org.ash.french.killer.sudoku.domain.impl.Cage

class KillerSudokuCageBuilder : SudokuBuilder<Cage> {

    fun cell(init: SudokuCellBuilder.() -> Unit) {

    }

    override fun build(): Cage {
        TODO("Not yet implemented")
    }
}
