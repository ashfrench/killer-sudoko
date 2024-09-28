package org.ash.french.sudoku.compose

import org.ash.french.killer.sudoku.builders.randomDefaultGrid
import org.ash.french.killer.sudoku.domain.SudokuGrid

@Composable
fun app() {
    val grid: SudokuGrid =
        remember {
            mutableStateOf<SudokuGrid>(randomDefaultGrid())
        }
    LaunchedEffect(grid) {
        println("Grid changed")
        println(grid)
    }
}
