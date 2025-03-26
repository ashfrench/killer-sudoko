package org.ash.french

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.ash.french.sudoku.sudokuGame
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun app() {
    MaterialTheme {
        var showNotes by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { showNotes = !showNotes }) {
                Text("Display Available Values!")
            }
            sudokuGame(showNotes)
        }
    }
}
