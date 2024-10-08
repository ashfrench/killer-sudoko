package org.ash.french.killer.sudoku.builders

import kotlinx.serialization.PolymorphicSerializer
import org.ash.french.killer.sudoku.domain.SudokuGrid
import org.ash.french.killer.sudoku.domain.TestConstants
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.util.StringJoiner
import kotlin.io.path.Path
import kotlin.test.assertEquals

class SudokuBuildersTest {
    @Test
    fun `can build empty sudoku grid`() {
        val grid = sudokuGrid { }.build()
        assertEquals(SudokuGrid(), grid)

        val gridStringPrint =
            """
            ||-------------------------------------||
            ||-------------------------------------||
            ||   |   |   ||   |   |   ||   |   |   ||
            ||-------------------------------------||
            ||   |   |   ||   |   |   ||   |   |   ||
            ||-------------------------------------||
            ||   |   |   ||   |   |   ||   |   |   ||
            ||-------------------------------------||
            ||-------------------------------------||
            ||   |   |   ||   |   |   ||   |   |   ||
            ||-------------------------------------||
            ||   |   |   ||   |   |   ||   |   |   ||
            ||-------------------------------------||
            ||   |   |   ||   |   |   ||   |   |   ||
            ||-------------------------------------||
            ||-------------------------------------||
            ||   |   |   ||   |   |   ||   |   |   ||
            ||-------------------------------------||
            ||   |   |   ||   |   |   ||   |   |   ||
            ||-------------------------------------||
            ||   |   |   ||   |   |   ||   |   |   ||
            ||-------------------------------------||
            ||-------------------------------------||
            """.trimIndent()
        assertEquals(gridStringPrint, grid.toString())
    }

    @Disabled("Fix up Serialisation")
    @Test
    fun `test kotlin json serialisation`() {
        val grid = TestConstants.grid
        val jsonString = JSON.encodeToString(PolymorphicSerializer(SudokuGrid::class), grid)

        val expectedJsonString = TestConstants.jsonString
        assertEquals(expectedJsonString, jsonString)
    }

    @Disabled("Fix up Serialisation")
    @Test
    fun `test load json from file and compare`() {
        val grid = TestConstants.grid
        val jsonString = JSON.encodeToString(PolymorphicSerializer(SudokuGrid::class), grid)

        val jsonFilePath = Path("src/test/resources/sudoku.grid")
        val stringJoiner = StringJoiner("\n")

        Files.lines(jsonFilePath).forEach { stringJoiner.add(it) }
        val expectedJsonString = stringJoiner.toString()

        assertEquals(expectedJsonString, jsonString)
    }

    @Test
    fun `test expected stdout string`() {
        val gridStringPrint =
            """
            ||-------------------------------------||
            ||-------------------------------------||
            || 2 |   |   || 5 |   | 7 ||   |   |   ||
            ||-------------------------------------||
            ||   |   | 6 || 4 | 3 |   || 1 |   |   ||
            ||-------------------------------------||
            || 7 | 5 | 3 || 6 |   |   ||   | 4 | 8 ||
            ||-------------------------------------||
            ||-------------------------------------||
            ||   |   |   || 8 |   |   || 4 | 5 | 1 ||
            ||-------------------------------------||
            || 3 |   |   ||   | 6 |   || 9 |   | 2 ||
            ||-------------------------------------||
            ||   | 8 | 5 ||   | 2 |   ||   | 3 |   ||
            ||-------------------------------------||
            ||-------------------------------------||
            || 5 |   | 1 ||   |   | 9 || 6 |   |   ||
            ||-------------------------------------||
            ||   | 4 | 9 || 7 |   |   ||   |   | 3 ||
            ||-------------------------------------||
            || 8 | 2 | 7 ||   |   | 6 ||   | 9 |   ||
            ||-------------------------------------||
            ||-------------------------------------||
            """.trimIndent()

        println(TestConstants.grid.toString())
        assertEquals(gridStringPrint, TestConstants.grid.toString())
    }
}
