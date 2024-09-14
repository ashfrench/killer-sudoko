package org.ash.french.killer.sudoku.builders

import org.ash.french.killer.sudoku.domain.CellUpdate
import org.ash.french.killer.sudoku.domain.KillerSudokuGrid

data class SudokuGridBuilder(private var sudokuGrid: KillerSudokuGrid) :
    SudokuBuilder<KillerSudokuGrid> {
    private var killerSudokuGrid: UByte = 0u
    private val cellUpdates = mutableListOf<CellUpdate>()

    override fun build(): KillerSudokuGrid = sudokuGrid.withCellValues(cellUpdates)

    fun cell(init: SudokuCellValueBuilder.() -> Unit): CellUpdate {
        val builder = SudokuCellValueBuilder(sudokuGrid)
        builder.init()

        val cellUpdate = builder.build()
        cellUpdates.add(cellUpdate)
        return cellUpdate
    }
}
