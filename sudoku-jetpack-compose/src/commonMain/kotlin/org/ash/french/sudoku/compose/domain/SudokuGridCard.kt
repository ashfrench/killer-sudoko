package org.ash.french.sudoku.compose.domain

import androidx.compose.runtime.Composable
import org.ash.french.killer.sudoku.domain.SudokuGrid
import org.ash.french.killer.sudoku.domain.cells
import org.ash.french.killer.sudoku.domain.nonets

@Composable
fun sudokuGridCard(sudokuGrid: SudokuGrid) {
    val cellCards =
        cells.map {
            cellCard(it, sudokuGrid)
        }

    val nonetCards =
        nonets.map {
            nonetCard(it, sudokuGrid)
        }

    val rowCards = sudokuGrid.getRows().map { rowCard(it) }
    val columnsCards = sudokuGrid.getColumns().map { coloumnCard(it) }

    // TODO
}
