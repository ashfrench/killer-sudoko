package org.ash.french.killer.sudoku.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomAppBar
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.ash.french.killer.sudoku.builders.randomDefaultGrid
import org.ash.french.killer.sudoku.compose.cards.SudokuGridCard
import org.ash.french.killer.sudoku.compose.cards.sudokuApp

fun main() =
    application {
        val defaultGrid = randomDefaultGrid()
        val sudokuGridCard = SudokuGridCard(defaultGrid)

        Window(onCloseRequest = ::exitApplication, title = "Killer Sudoku Solver") {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text("Top app bar")
                        },
                    )
                },
                bottomBar = {
                    BottomAppBar {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            text = "Bottom app bar",
                        )
                    }
                },
            ) { _ ->
                defaultPreview()
            }
        }
    }

@Composable
fun mainScreen() {
    sudokuApp()
}

@Composable
fun app() {
    MaterialTheme {
        mainScreen()
    }
}

@Composable
fun defaultPreview() {
    app()
}
