package org.ash.french.killer.sudoku.compose.cards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import org.ash.french.killer.sudoku.domain.Cell
import org.ash.french.killer.sudoku.domain.SudokuGrid
import org.ash.french.killer.sudoku.domain.cells

class SudokuGridCard(val sudokuGrid: SudokuGrid) {
    private val boxPadding = 0.3f
    @Composable
    fun composableCard() {
        val rowToCellsMap = cells.groupBy { it.x }
        rowToCellsMap.entries.map {
            Column {
                Row {
                    sudokuRowComposable(it.value)
                }
            }
            Column {
                Row {
                    sudokuRowComposable(it.value)
                }
            }
        }
    }

    @Composable
    fun sudokuRowComposable(cells: List<Cell>) {
        cells.map {
            cellCard(it)
        }
    }

    @Composable
    fun cellCard(cell: Cell) {
        OutlinedButton(onClick = {}) {
            Text("$cell")
        }
    }
}
