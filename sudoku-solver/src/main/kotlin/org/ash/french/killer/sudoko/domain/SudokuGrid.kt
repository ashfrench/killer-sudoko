package org.ash.french.killer.sudoko.domain

import org.ash.french.killer.sudoko.solvers.CellUpdate
import org.ash.french.killer.sudoko.solvers.SolvedSudokuGrid

class SudokuGrid {
    fun updateCell(
        cell: Cell,
        value: UByte,
    ) {
        println("Updating cell $cell with value $value")
    }

    fun isSolved(): Boolean {
        TODO("Not yet implemented")
    }

    fun applyUpdates(updates: Collection<CellUpdate>): SolvedSudokuGrid {
        println(updates)
        TODO("Not yet implemented")
    }

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
