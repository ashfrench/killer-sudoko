package org.ash.french.sudoku

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp

@Composable
fun cellNotesGrid(
    containerSize: Dp,
    notes: Set<Int>,
    
) {
    val size = containerSize / 3

    Row {
        repeat(3) { row ->
            Column {
                repeat(3) { col ->
                    val number = row * 3 + col + 1
                    Text(
                        text = if (number in notes) number.toString() else "",
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
