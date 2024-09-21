package org.ash.french.sudoku.compose

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.ash.french.killer.sudoku.builders.randomDefaultGrid

@Composable
@Preview
fun app() {
    val grid = randomDefaultGrid()
    println(grid)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Sudoku Solver app bar")
                },
            )
        },
        bottomBar = {
            BottomAppBar {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Sudoku Solver Bottom app bar",
                )
            }
        },
    ) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)
        (0..8).forEach { row ->
            val absolutePadding = modifier.absolutePadding(top = (row * 20).dp)
            LazyRow(absolutePadding) {
                items(9) { col ->
                    val cellValue = grid.getCellValue(col + 1, row + 1)
                    val cellString = cellValue ?: " "
                    TextField(" $cellString ", onValueChange = {}, absolutePadding.requiredWidth(50.dp))
                }
            }
        }
    }
}
