package org.ash.french.killer.sudoko.domain

class SudokuGrid {
    private val cells: Set<Cell> =
        (1..9)
            .flatMap { x ->
                (1..9)
                    .map { y ->
                        Cell(x, y)
                    }
            }.toSet()

    private val rows: List<Row> = cells.groupBy { it.y }.map { Row(it.key, it.value.toSet()) }

    private val column: List<Column> = cells.groupBy { it.x }.map { Column(it.key, it.value.toSet()) }

    companion object {
        val DEFAULT_EMPTY = SudokuGrid()
    }
}
