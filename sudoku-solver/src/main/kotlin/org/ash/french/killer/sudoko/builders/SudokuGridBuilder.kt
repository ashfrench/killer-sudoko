package org.ash.french.killer.sudoko.builders

import org.ash.french.killer.sudoko.domain.SudokuGrid

data class SudokuGridBuilder(private var sudokuGrid: SudokuGrid) : SudokuBuilder<SudokuGrid> {
    private var killerSudokuGrid: UByte = 0u

    override fun build(): SudokuGrid = sudokuGrid.copy()

    fun cell(): SudokuGridBuilder {
        val cellValueBuilder = SudokuCellValueBuilder(sudokuGrid)
        return SudokuGridBuilder(cellValueBuilder.build())
    }
}
