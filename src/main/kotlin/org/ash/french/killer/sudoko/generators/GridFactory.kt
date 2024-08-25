package org.ash.french.killer.sudoko.generators

import org.ash.french.killer.sudoko.domain.*

fun defaultSudokuGrid(): SudokuGrid {

    val xRange = 1..9
    val yRange = 1..9

    val cellSet = xRange.flatMap { x ->
        yRange.map { y -> Cell(x.toUByte(), y.toUByte())  }
    }.toSet()

    require(cellSet.size == 45) { "Missing Cells to create a grid" }
    return SudokuGrid(cellSet)
}

fun cageSizeToValueSets(): Map<UByte, CellSet> = TODO()

fun generateEmptySudokuGrid(): SudokuGrid {
    val cells = (1..9).flatMap { x ->
        (1..9)
            .map { y -> Cell(x, y) }}
        .toSet()

    return SudokuGrid(cells)
}

fun generateSudokuCells() = (1..9).flatMap { x ->
    (1..9)
        .map { y -> Cell(x, y) }}
    .toSet()

data class SudokuGrid(val cells: Set<Cell> = generateSudokuCells()) {

    val rows = cells.groupBy { it.y }.mapValues() { Row(it.key, it.value.toSet()) }
    val columns = cells.groupBy { it.x }.mapValues() { Column(it.key, it.value.toSet()) }

    val nonets = (1..9 step 3).map { x ->
        val nonetCells = (1..9 step 3).map { y ->
            Cell(x, y)
        }.toSet()
        Nonet(nonetCells)
    }.toSet()

    private val cellValues: MutableMap<Cell, UByte?> = cells.associateWith { null }.toMutableMap()
    fun updateCell(cell: Cell, value: UByte?): CellUpdate = TODO()

}

typealias CellUpdate = Result<Boolean>