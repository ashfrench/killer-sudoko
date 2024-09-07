package org.ash.french.killer.sudoko.builders

import org.ash.french.killer.sudoko.domain.Cage
import org.ash.french.killer.sudoko.domain.Cell
import org.ash.french.killer.sudoko.domain.SudokuGrid
import kotlin.uuid.ExperimentalUuidApi

@OptIn(ExperimentalUuidApi::class)
fun sudokuGrid(init: SudokuGrid.() -> Unit): SudokuGridBuilder {
    val sudokuGrid = SudokuGrid()
    sudokuGrid.init()
    return SudokuGridBuilder(sudokuGrid)
}

fun SudokuGrid.cellValue(
    cell: Cell,
    value: UByte?,
) {
    setCellValue(cell, value)
}

fun SudokuGrid.cellValue(init: SudokuCellValueBuilder.() -> Unit) {
    val cellValueBuilder = SudokuCellValueBuilder(this)
    cellValueBuilder.init()

    val cellUpdate = cellValueBuilder.build()
    this.cellValue(cellUpdate.cell, cellUpdate.value)
}

fun SudokuGrid.cellValue(
    cell: Cell,
    value: Int?,
) {
    setCellValue(cell, value?.toUByte())
}

fun SudokuGrid.cellValueBuilder(cellValueMap: Map<Cell, UByte?>) {
    cellValueMap
        .filter { (cell, _) -> cell in this }
        .forEach { (cell, value) ->
            setCellValue(cell, value)
        }
}

fun SudokuGrid.cageBuilder(cageValueMap: Map<Cage, UByte>): CageBuilder {
    val cages =
        cageValueMap
            .filterValues { it !in 1u..45u }
            .filterKeys { it.cells.size in 1..9 }

    return CageBuilder(this, cages)
}

class CageBuilder(val sudokuGrid: SudokuGrid, val cages: Map<Cage, UByte> = emptyMap())
