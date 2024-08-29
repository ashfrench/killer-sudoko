package org.ash.french.killer.sudoko.builders

import org.ash.french.killer.sudoko.domain.Cage
import org.ash.french.killer.sudoko.domain.Cell
import org.ash.french.killer.sudoko.generators.EMPTY_SUDOKU_GRID
import org.ash.french.killer.sudoko.generators.SudokuGrid

fun sudokuGrid(init: SudokuGrid.() -> Unit): SudokuGrid {
    val sudokuGrid = EMPTY_SUDOKU_GRID()
    sudokuGrid.init()
    return sudokuGrid
}

fun SudokuGrid.cellValueBuilder(cellValueMap: Map<Cell, UByte?>){
    cellValueMap
        .filter { (cell, _) -> cell in this }
        .forEach { (cell, value) ->
            updateCell(cell, value)
        }
}

fun SudokuGrid.cageBuilder(cageValueMap: Map<Cage, UByte>): SudokuGrid {
    val cages = cageValueMap
        .filterValues { it !in 1u..45u }
        .filterKeys { it.size in 1..9 }

    return withCages(cages)
}