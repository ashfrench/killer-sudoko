package org.ash.french.killer.sudoku.builders

import org.ash.french.killer.sudoku.domain.Cage
import org.ash.french.killer.sudoku.domain.Cell
import org.ash.french.killer.sudoku.domain.KillerSudokuGrid

fun sudokuGrid(init: KillerSudokuGrid.() -> Unit): SudokuGridBuilder {
    val sudokuGrid = KillerSudokuGrid()
    sudokuGrid.init()
    return SudokuGridBuilder(sudokuGrid)
}

internal fun KillerSudokuGrid.cellValue(
    cell: Cell,
    value: UByte?,
) {
    setCellValue(cell, value)
}

internal fun KillerSudokuGrid.cellValue(init: SudokuCellValueBuilder.() -> Unit) {
    val cellValueBuilder = SudokuCellValueBuilder(this)
    cellValueBuilder.init()

    val cellUpdate = cellValueBuilder.build()
    this.cellValue(cellUpdate.cell, cellUpdate.value)
}

internal fun KillerSudokuGrid.cellValue(
    cell: Cell,
    value: Int?,
) {
    setCellValue(cell, value?.toUByte())
}

internal fun KillerSudokuGrid.cellValueBuilder(cellValueMap: Map<Cell, UByte?>) {
    cellValueMap
        .filter { (cell, _) -> cell in this }
        .forEach { (cell, value) ->
            setCellValue(cell, value)
        }
}

internal fun KillerSudokuGrid.cageBuilder(cageValueMap: Map<Cage, UByte>): CageBuilder {
    val cages =
        cageValueMap
            .filterValues { it !in 1u..45u }
            .filterKeys { it.cells.size in 1..9 }

    return CageBuilder(this, cages)
}

internal class CageBuilder(val sudokuGrid: KillerSudokuGrid, val cages: Map<Cage, UByte> = emptyMap())
