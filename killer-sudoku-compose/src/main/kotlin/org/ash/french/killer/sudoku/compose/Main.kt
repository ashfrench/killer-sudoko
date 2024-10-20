package org.ash.french.killer.sudoku.compose

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.ash.french.killer.sudoku.builders.randomDefaultGrid
import org.ash.french.killer.sudoku.compose.cards.SudokuGridCard

fun main() =
    application {
        val defaultGrid = randomDefaultGrid()
        val sudokuGridCard = SudokuGridCard(defaultGrid)
        Window(onCloseRequest = ::exitApplication) {
            sudokuGridCard.composableCard()
        }
    }
