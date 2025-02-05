package org.ash.french.killer.sudoku.compose.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import org.ash.french.killer.sudoku.compose.SudokuBoard
import org.ash.french.killer.sudoku.domain.impl.Cell

@Composable
fun sudokuGrid(
    board: SudokuBoard,
    onValueChange: (Int, Int, String) -> Unit,
) {
    Column {
        for (row in 0 until 9) {
            Row(horizontalArrangement = Arrangement.Center) {
                for (col in 0 until 9) {
                    sudokuCell(
                        value = board.grid[Cell(row, col)]?.toString() ?: "",
                        onValueChange = { value ->
                            onValueChange(
                                row,
                                col,
                                value,
                            )
                        },
                    )
                }
            }
        }
    }
}
