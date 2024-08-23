package org.ash.french.killer.sudoko.generators

import org.ash.french.killer.sudoko.domain.*

interface GridFactory {

    fun defaultSudokuGrid(): SudokuGrid {

        val xRange = 1..9
        val yRange = 1..9

        val cellSet = xRange.flatMap { x ->
            yRange.map { y -> Cell(x.toUByte(), y.toUByte())  }
        }.toSet()

        require(cellSet.size == 45) { "Missing Cells to create a grid" }
        return SudokuGrid(cellSet)
    }


    fun generateKillerSudokuGrid(): SudokuGrid

}

data class SudokuGrid(val cells: Set<Cell>) {


    val rows = cells.groupBy { it.y }.mapValues() { Row(it.key, it.value.toSet()) }

    val columns: Set<Column> = TODO()
    val nonets: Set<Nonet> = TODO()

    private val cellValues: MutableMap<Cell, UByte?> = cells.associateWith { null }.toMutableMap()
    fun updateCell(cell: Cell, value: UByte?): CellUpdate = TODO()

}

typealias CellUpdate = Result<Boolean>