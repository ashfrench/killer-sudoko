package org.ash.french.sudoku

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min

private const val CELL_COUNT = 3

@Composable
fun sudokuBox(
    showNotes: Boolean,
    size: Dp,
) {
    BoxWithConstraints(
        modifier = Modifier.size(size).border(2.dp, Color.Black),
        contentAlignment = Alignment.Center,
    ) {
        val boxSize = min(maxHeight / CELL_COUNT, maxWidth / CELL_COUNT)
        Column(Modifier.fillMaxSize()) {
            repeat(CELL_COUNT) { row ->
                Row(Modifier.fillMaxWidth()) {
                    repeat(CELL_COUNT) { col ->
                        cellNotesGrid(boxSize, showNotes, (1..9).toSet())
                    }
                }
            }
        }
    }
}
