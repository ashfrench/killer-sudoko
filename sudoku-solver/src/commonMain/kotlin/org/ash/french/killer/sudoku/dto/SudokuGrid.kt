package org.ash.french.killer.sudoku.dto

import org.ash.french.killer.sudoku.domain.Cell
import org.ash.french.killer.sudoku.domain.SudokuGrid
import java.util.UUID

data class SudokuGrid(
    val id: UUID?,
    val cellValues: Map<org.ash.french.killer.sudoku.dto.Cell, Int?>,
)

fun SudokuGrid.toDto(): org.ash.french.killer.sudoku.dto.SudokuGrid {
    return SudokuGrid(
        id = id,
        cellValues = getAllCellValues().mapKeys { it.key.toDto() }.mapValues { it.value.toInt() },
    )
}

fun Cell.toDto(): org.ash.french.killer.sudoku.dto.Cell {
    return org.ash.french.killer.sudoku.dto.Cell(x.toInt(), y.toInt())
}
