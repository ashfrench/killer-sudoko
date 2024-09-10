package org.ash.french.killer.sudoku.dto

data class Cage(
    val cells: Set<Cell>,
    val sum: Int
) {
    init {
        require(cells.size in 1..9) { "Number of cells in a cage must be between 1 and 9" }
        require(sum in 1..45) { "Sum of a cage must be between 1 and 45" }
    }

}
