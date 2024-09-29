package org.ash.french.killer.sudoku.dto

data class Nonet(val cells: Set<Cell>) {
    init {
        require(cells.size == 9) { "Nonet must contain 9 cells" }
        require(cells.map { it.row / 3 to it.column / 3 }.toSet().size == 1) { "Nonet must contain cells with the same nonet" }
    }
}
