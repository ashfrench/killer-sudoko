package org.ash.french.killer.sudoku.builders

import org.ash.french.killer.sudoku.domain.CellUpdate
import org.ash.french.killer.sudoku.domain.SudokuGrid
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
internal data class SudokuGridBuilder(private var sudokuGrid: SudokuGrid) :
    org.ash.french.killer.sudoku.builders.SudokuBuilder<SudokuGrid> {
    private var killerSudokuGrid: UByte = 0u
    private val cellUpdates = mutableListOf<CellUpdate>()

    override fun build(): SudokuGrid = sudokuGrid.withCellValues(cellUpdates)

    fun cell(init: org.ash.french.killer.sudoku.builders.SudokuCellValueBuilder.() -> Unit): CellUpdate {
        val builder = org.ash.french.killer.sudoku.builders.SudokuCellValueBuilder(sudokuGrid)
        builder.init()

        val cellUpdate = builder.build()
        cellUpdates.add(cellUpdate)
        return cellUpdate
    }
}
