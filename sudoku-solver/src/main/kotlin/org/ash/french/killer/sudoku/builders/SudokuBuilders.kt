package org.ash.french.killer.sudoku.builders

import org.ash.french.killer.sudoku.domain.Cage
import org.ash.french.killer.sudoku.domain.Cell
import org.ash.french.killer.sudoku.domain.KillerSudokuGrid
import org.ash.french.killer.sudoku.domain.SudokuGrid
import java.util.UUID

fun sudokuGrid(init: SudokuGrid.() -> Unit): SudokuGridBuilder {
    val sudokuGrid = SudokuGrid()
    sudokuGrid.init()
    return SudokuGridBuilder(sudokuGrid)
}

internal fun SudokuGrid.cellValue(
    cell: Cell,
    value: UByte?,
) {
    setCellValue(cell, value)
}

internal fun SudokuGrid.cellValue(init: SudokuCellValueBuilder.() -> Unit) {
    val cellValueBuilder = SudokuCellValueBuilder(this)
    cellValueBuilder.init()

    val cellUpdate = cellValueBuilder.build()
    this.cellValue(cellUpdate.cell, cellUpdate.value)
}

internal fun KillerSudokuGrid.cellValue(
    cell: Cell,
    value: Int?,
) {
    setCellValue(cell, value?.toUByte())
}

internal fun KillerSudokuGrid.cellValueBuilder(cellValueMap: Map<Cell, UByte?>) {
    cellValueMap
        .filter { (cell, _) -> cell in this }
        .forEach { (cell, value) ->
            setCellValue(cell, value)
        }
}

internal fun KillerSudokuGrid.cageBuilder(cageValueMap: Map<Cage, UByte>): CageBuilder {
    val cages =
        cageValueMap
            .filterValues { it !in 1u..45u }
            .filterKeys { it.cells.size in 1..9 }

    return CageBuilder(this, cages)
}

internal class CageBuilder(val sudokuGrid: KillerSudokuGrid, val cages: Map<Cage, UByte> = emptyMap())

fun randomDefaultGrid(uuid: UUID? = UUID.randomUUID()): SudokuGrid {
    val grid =
        sudokuGrid {
            id = uuid
            cellValue {
                x = 1
                y = 1
                value = 2
            }
            cellValue {
                x = 1
                y = 3
                value = 7
            }
            cellValue {
                x = 1
                y = 5
                value = 3
            }
            cellValue {
                x = 1
                y = 7
                value = 5
            }
            cellValue {
                x = 1
                y = 9
                value = 8
            }

            cellValue {
                x = 2
                y = 3
                value = 5
            }
            cellValue {
                x = 2
                y = 6
                value = 8
            }
            cellValue {
                x = 2
                y = 8
                value = 4
            }
            cellValue {
                x = 2
                y = 9
                value = 2
            }

            cellValue {
                x = 3
                y = 2
                value = 6
            }
            cellValue {
                x = 3
                y = 3
                value = 3
            }
            cellValue {
                x = 3
                y = 6
                value = 5
            }
            cellValue {
                x = 3
                y = 7
                value = 1
            }
            cellValue {
                x = 3
                y = 8
                value = 9
            }
            cellValue {
                x = 3
                y = 9
                value = 7
            }

            cellValue {
                x = 4
                y = 1
                value = 5
            }
            cellValue {
                x = 4
                y = 2
                value = 4
            }
            cellValue {
                x = 4
                y = 3
                value = 6
            }
            cellValue {
                x = 4
                y = 4
                value = 8
            }
            cellValue {
                x = 4
                y = 8
                value = 7
            }

            cellValue {
                x = 5
                y = 2
                value = 3
            }
            cellValue {
                x = 5
                y = 5
                value = 6
            }
            cellValue {
                x = 5
                y = 6
                value = 2
            }

            cellValue {
                x = 6
                y = 1
                value = 7
            }
            cellValue {
                x = 6
                y = 7
                value = 9
            }
            cellValue {
                x = 6
                y = 9
                value = 6
            }

            cellValue {
                x = 7
                y = 2
                value = 1
            }
            cellValue {
                x = 7
                y = 4
                value = 4
            }
            cellValue {
                x = 7
                y = 5
                value = 9
            }
            cellValue {
                x = 7
                y = 7
                value = 6
            }

            cellValue {
                x = 8
                y = 3
                value = 4
            }
            cellValue {
                x = 8
                y = 4
                value = 5
            }
            cellValue {
                x = 8
                y = 6
                value = 3
            }
            cellValue {
                x = 8
                y = 9
                value = 9
            }

            cellValue {
                x = 9
                y = 3
                value = 8
            }
            cellValue {
                x = 9
                y = 4
                value = 1
            }
            cellValue {
                x = 9
                y = 5
                value = 2
            }
            cellValue {
                x = 9
                y = 8
                value = 3
            }
        }.build()
    return grid
}
