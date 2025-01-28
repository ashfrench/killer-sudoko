package org.ash.french.killer.sudoku.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SudokuApp() {
    var board: SudokuBoard by remember { mutableStateOf(SudokuBoard()) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Sudoku", fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(16.dp))

        // Render Sudoku Grid
        SudokuGrid(board) { row, col, value ->
            val newValue = value.toIntOrNull()
            board = board.copy(grid = board.grid.mapIndexed { rIdx, rowData ->
                if (rIdx == row) rowData.mapIndexed { cIdx, cellValue ->
                    if (cIdx == col) newValue else cellValue
                } else rowData
            })
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Optionally, add a button to reset or solve the Sudoku
        Button(onClick = { /* Solve or reset functionality */ }) {
            Text("Reset / Solve")
        }
    }
}

@Composable
fun SudokuGrid(board: SudokuBoard, onValueChange: (Int, Int, String) -> Unit) {
    Column {
        for (row in 0 until 9) {
            Row(horizontalArrangement = Arrangement.Center) {
                for (col in 0 until 9) {
                    SudokuCell(value = board.grid[row][col]?.toString() ?: "",
                        onValueChange = { value -> onValueChange(row, col, value) })
                }
            }
        }
    }
}

@Composable
fun SudokuCell(value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(" ") },
        modifier = Modifier
            .padding(4.dp)
            .size(40.dp),
        textStyle = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
        singleLine = true
    )
}