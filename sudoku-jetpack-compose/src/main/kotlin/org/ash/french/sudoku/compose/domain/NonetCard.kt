package org.ash.french.sudoku.compose.domain

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Card
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.ash.french.killer.sudoku.domain.Cell
import org.ash.french.killer.sudoku.domain.Nonet
import org.ash.french.killer.sudoku.domain.SudokuGrid

@Composable
fun nonetCard(
    nonet: Nonet,
    sudokuGrid: SudokuGrid,
) {
    Card {
        Box {
            val cells = nonet.cells
            cells.chunked(3).forEach { chunkedCells ->
                Row {
                    Column {
                        createCells(chunkedCells, sudokuGrid)
                    }
                }
            }
        }
    }
}

@Composable
private fun createCells(
    it: List<Cell>,
    sudokuGrid: SudokuGrid,
) {
    it.forEach { cell ->
        var textValue = remember { sudokuGrid.getCellValue(cell)?.toString() ?: " " }
        TextField(
            textValue,
            { newValue ->
                sudokuGrid.setCellValue(
                    cell,
                    newValue.toUByte(),
                )
                textValue = newValue
            },
        )
    }
}
