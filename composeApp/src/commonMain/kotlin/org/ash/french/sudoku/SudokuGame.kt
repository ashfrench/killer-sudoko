package org.ash.french.sudoku

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.min

private const val BOX_COUNT = 3

@Composable
fun sudokuGame(showNotes: Boolean) {
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        val size = min(maxWidth, maxHeight)

        Column(Modifier.size(size = size)) {
            repeat(BOX_COUNT) { row ->
                Row(Modifier.fillMaxWidth()) {
                    repeat(BOX_COUNT) { col ->
                        sudokuBox(showNotes, Dp(size.value / BOX_COUNT))
                    }
                }
            }
        }
    }
}
