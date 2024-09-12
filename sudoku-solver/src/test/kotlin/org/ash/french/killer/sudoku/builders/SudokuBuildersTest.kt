package org.ash.french.killer.sudoku.builders

import kotlinx.serialization.encodeToString
import org.ash.french.killer.sudoku.domain.Cell
import org.ash.french.killer.sudoku.domain.SudokuGrid
import org.ash.french.killer.sudoku.domain.TestConstants
import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.util.StringJoiner
import kotlin.io.path.Path
import kotlin.test.assertEquals

class SudokuBuildersTest {
    private val expectedString: String

    init {
        val grid = TestConstants.grid
        val stringJoiner = StringJoiner("|| ")
        stringJoiner.add("")
        (1..9)
            .forEach { y ->
                val rowJoiner = StringJoiner(" | ")
                (1..9).forEach { x ->
                    val cell = Cell(x, y)
                    val value = grid.getCellValue(cell)
                    rowJoiner.add(value?.toString() ?: " ")
                }
                stringJoiner.add("$rowJoiner")
                stringJoiner.add(" \n")
            }

        expectedString = stringJoiner.toString()
    }

    @Test
    fun `can build empty sudoku grid`() {
        val grid = sudokuGrid { }.build()
        assertEquals(SudokuGrid(), grid)
    }

    @Test
    fun `test kotlin json serialisation`() {
        val grid = TestConstants.grid
        val jsonString = org.ash.french.killer.sudoku.builders.JSON.encodeToString(grid)

        val expectedJsonString = TestConstants.jsonString
        assertEquals(expectedJsonString, jsonString)
    }

    @Test
    fun `test load json from file and compare`() {
        val grid = TestConstants.grid
        val jsonString = JSON.encodeToString(grid)

        val jsonFilePath = Path("src/test/resources/sudoku.grid")
        val stringJoiner = StringJoiner("\n")

        Files.lines(jsonFilePath).forEach { stringJoiner.add(it) }
        val expectedJsonString = stringJoiner.toString()

        assertEquals(expectedJsonString, jsonString)
    }
}
