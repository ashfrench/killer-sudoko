package org.ash.french.killer.sudoku.dto

data class Row(val cells: Set<Cell>) {
    init {
        require(cells.size == 9) { "Row must contain 9 cells" }
        require(cells.map { it.row }.toSet().size == 1) { "Row must contain cells with the same row" }
    }
}
