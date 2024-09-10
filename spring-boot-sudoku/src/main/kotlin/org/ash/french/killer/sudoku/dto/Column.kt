package org.ash.french.killer.sudoku.dto

data class Column(
    val cells: Set<Cell>
) {
    init {
        require(cells.size == 9) { "Column must contain 9 cells" }
        require(cells.map { it.column }.toSet().size == 1) { "Column must contain cells with the same column" }
    }
}
