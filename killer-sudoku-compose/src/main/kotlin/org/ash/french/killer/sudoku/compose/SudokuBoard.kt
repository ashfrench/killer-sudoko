package org.ash.french.killer.sudoku.compose

data class SudokuBoard(
    val grid: List<List<Int?>> = List(9) { List(9) { null } }
) {
//    fun setCellValue(row: Int, col: Int, value: Int?) {
//        grid[row][col] = value
//    }
}