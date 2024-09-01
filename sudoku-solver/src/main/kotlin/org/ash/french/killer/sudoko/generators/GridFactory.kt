package org.ash.french.killer.sudoko.generators

import org.ash.french.killer.sudoko.domain.Cell
import org.ash.french.killer.sudoko.domain.CellSet

@Suppress("unused")
fun defaultSudokuGrid(): SudokuGrid {
    val xRange = 1..9
    val yRange = 1..9

    val cellSet =
        xRange
            .flatMap { x -> yRange.map { y -> Cell(x.toUByte(), y.toUByte()) } }
            .toSet()

    require(cellSet.size == 45) { "Missing Cells to create a grid" }
    return SudokuGrid(cellSet)
}

@Suppress("unused")
fun cageSizeToValueSets(): Map<UByte, CellSet> = emptyMap()

@Suppress("unused")
fun generateEmptySudokuGrid(): SudokuGrid {
    val cells =
        (1..9).flatMap { x ->
            (1..9).map { y -> Cell(x, y) }
        }
             .toSet()

    return SudokuGrid(cells)
}

fun generateSudokuCells() =
    (1..9)
        .flatMap { x ->
            (1..9)
                        .map { y -> Cell(x, y) }
                }
        .toSet()

typealias CellUpdate = Result<Boolean>
