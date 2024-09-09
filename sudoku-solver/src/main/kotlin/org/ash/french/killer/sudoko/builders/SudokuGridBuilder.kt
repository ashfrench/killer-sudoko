package org.ash.french.killer.sudoko.builders

import org.ash.french.killer.sudoko.domain.CellUpdate
import org.ash.french.killer.sudoko.domain.SudokuGrid
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
data class SudokuGridBuilder(private var sudokuGrid: SudokuGrid) : SudokuBuilder<SudokuGrid> {
    private var killerSudokuGrid: UByte = 0u
    private val cellUpdates = mutableListOf<CellUpdate>()

    override fun build(): SudokuGrid = sudokuGrid.withCellValues(cellUpdates)

    fun cell(init: SudokuCellValueBuilder.() -> Unit): CellUpdate {
        val builder = SudokuCellValueBuilder(sudokuGrid)
        builder.init()

        val cellUpdate = builder.build()
        cellUpdates.add(cellUpdate)
        return cellUpdate
    }
}
