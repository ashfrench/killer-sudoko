package org.ash.french.sudoku

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun cellNotesGrid(
    containerSize: Dp,
    displayNotes: Boolean,
    notes: Set<Int>,
) {
    val size = containerSize / 3
    Row(Modifier.border(1.dp, Color.Gray)) {
        repeat(3) { row ->
            Column {
                repeat(3) { col ->
                    val number = row + 1 + col * 3
                    Text(
                        text = if (number in notes && displayNotes) number.toString() else "",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.size(size),
                        fontSize = 10.sp,
                        color = Color.Black,
                    )
                }
            }
        }
    }
}
