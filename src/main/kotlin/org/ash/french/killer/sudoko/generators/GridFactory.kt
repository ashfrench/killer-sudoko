package org.ash.french.killer.sudoko.generators

import org.ash.french.killer.sudoko.domain.*

interface GridFactory {

    fun defaultSudokuGrid(): SudokuGrid
    fun generateKillerSudokuGrid(): SudokuGrid

}

data class SudokuGrid(val cells: Set<Cell>) {

    val rows: Set<Row> = TODO()
    val columns: Set<Column> = TODO()
    val nonets: Set<Nonet> = TODO()

    private val cellValues: MutableMap<Cell, Int?> = cells.associateWith { null }.toMutableMap()
    fun updateCell(cell: Cell, value: Int?): CellUpdate = TODO()

}

typealias CellUpdate = Result<Boolean>