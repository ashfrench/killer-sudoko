package org.ash.french.killer.sudoku.domain.impl

import org.ash.french.killer.sudoku.domain.KillerSudokuGridInterface
import org.ash.french.killer.sudoku.domain.SudokuGrid
import org.ash.french.killer.sudoku.domain.SudokuGridInterface
import java.util.StringJoiner

object SudokuStdPrinter {
    fun printSudokuString(gridInterface: SudokuGridInterface): String {
        val printString =
            when (gridInterface) {
                is KillerSudokuGridInterface -> printKillerSudoku(gridInterface)
                is SudokuGrid -> printSudokuGrid(gridInterface)
            }
        return printString
    }

    private fun printKillerSudoku(gridInterface: KillerSudokuGridInterface): String {
        TODO("Not yet implemented")
    }

    private fun printSudokuGrid(grid: SudokuGrid) = grid.toStdString()

    private fun StringJoiner.addRowString(newLine: Boolean = true) =
        add("||-------------------------------------||" + if (newLine) "\n" else "")

    private fun SudokuGrid.toStdString(): String {
        val columnJoiner = StringJoiner("")
        (1..9)
            .forEach { y ->
                columnJoiner.addRowString()
                if (y % 3 == 1) {
                    columnJoiner.addRowString()
                }
                val rowJoiner = StringJoiner("|")
                columnJoiner.add("||")
                (1..9).forEach { x ->
                    val cell = Cell(x, y)
                    val value = getCellValue(cell).value
                    val valueString = value?.toString() ?: " "
                    rowJoiner.add(" $valueString ")

                    if (x % 3 == 0 && x != 9) {
                        rowJoiner.add("")
                    }
                }
                columnJoiner.add("$rowJoiner")
                columnJoiner.add("||\n")
            }
        columnJoiner.addRowString()
        columnJoiner.addRowString(false)

        return columnJoiner.toString()
    }
}
