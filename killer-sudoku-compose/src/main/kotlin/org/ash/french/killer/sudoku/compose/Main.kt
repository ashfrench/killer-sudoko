package org.ash.french.killer.sudoku.compose

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.ash.french.killer.sudoku.builders.randomDefaultGrid
import org.ash.french.killer.sudoku.compose.cards.SudokuGridCard

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
                DefaultPreview()
            }
        }
    }


@Composable
fun MainScreen() {
    SudokuApp()
}

@Composable
fun App() {
    MaterialTheme {
        MainScreen()
    }
}

@Composable
fun DefaultPreview() {
    App()
}