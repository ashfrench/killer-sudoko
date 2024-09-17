package org.ash.french.sudoku.compose.domain

import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.ash.french.killer.sudoku.domain.Cell
import org.ash.french.killer.sudoku.domain.SudokuGrid

@Composable
fun cellCard(
    cell: Cell,
    grid: SudokuGrid,
) {
    Card {
        val rememberedCell = remember { cell }
        val rememberedGrid = remember { grid }
        val rememberedCellValue = remember { grid.getCellValue(cell)?.toString() ?: " " }

        OutlinedTextField(rememberedCellValue, { newValue -> handleCellClick(newValue, rememberedCell, rememberedGrid) })
    }
}

fun handleCellClick(
    newValue: String,
    cell: Cell,
    grid: SudokuGrid,
): () -> Unit {
    return {
        grid.setCellValue(cell, newValue.toUByte())
    }
}
