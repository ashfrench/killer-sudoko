package org.ash.french.killer.sudoku.compose.cards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.ash.french.killer.sudoku.compose.SudokuBoard
import org.ash.french.killer.sudoku.domain.impl.Cell

@Composable
fun sudokuApp() {
    var board: SudokuBoard by remember { mutableStateOf(SudokuBoard(mutableMapOf())) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Sudoku", fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(16.dp))

        // Render Sudoku Grid
        sudokuGrid(board) { row, col, value ->
            board.grid[Cell(row, col)] = value.toIntOrNull()
            board = board.copy(grid = board.grid)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Optionally, add a button to reset or solve the Sudoku
        Button(onClick = { /* Solve or reset functionality */ }) {
            Text("Reset / Solve")
        }
    }
}
