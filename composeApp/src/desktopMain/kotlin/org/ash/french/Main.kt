package org.ash.french

import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

fun main() =
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Killer Sudoku Solver",
            state = WindowState(size = DpSize(900.dp, 950.dp))
        ) {
            app()
        }
    }
