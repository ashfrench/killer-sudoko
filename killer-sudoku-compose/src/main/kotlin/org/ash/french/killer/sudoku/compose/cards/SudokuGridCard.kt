package org.ash.french.killer.sudoku.compose.cards

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.ash.french.killer.sudoku.domain.SudokuGrid

class SudokuGridCard(private val sudokuGrid: SudokuGrid) {
    @Composable
    fun composableCard() {
        LazyVerticalGrid(columns = GridCells.Fixed(9), modifier = Modifier.padding(2.dp)) {
            items(81) { itemIndex ->
                val x = (itemIndex % 9) + 1
                val y = (itemIndex / 9) + 1

                cellCard(x, y)
            }
        }
    }

    @Composable
    fun cellCard(
        x: Int,
        y: Int,
    ) {
        OutlinedButton(onClick = {}) {
            val cellState = sudokuGrid.getCellValue(x, y)
            val value = cellState.value ?: ""
            Text("$value")
        }
    }
}
