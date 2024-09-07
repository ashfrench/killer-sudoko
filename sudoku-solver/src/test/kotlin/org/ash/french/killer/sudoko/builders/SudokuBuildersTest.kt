package org.ash.french.killer.sudoko.builders

import kotlinx.serialization.encodeToString
import org.ash.french.killer.sudoko.domain.Cell
import org.ash.french.killer.sudoko.domain.SudokuGrid
import org.ash.french.killer.sudoko.domain.TestConstants
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.StringJoiner
import kotlin.uuid.ExperimentalUuidApi

@OptIn(ExperimentalUuidApi::class)
class SudokuBuildersTest {
    private val expectedString: String

    init {
        val grid = TestConstants().grid
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
        val grid = TestConstants().grid
        val jsonString = JSON.encodeToString(grid)

        val expectedJsonString =
            """
            {
                "cellValues": [
                    {
                        "x": 1,
                        "y": 1
                    },
                    2,
                    {
                        "x": 1,
                        "y": 2
                    },
                    null,
                    {
                        "x": 1,
                        "y": 3
                    },
                    7,
                    {
                        "x": 1,
                        "y": 4
                    },
                    null,
                    {
                        "x": 1,
                        "y": 5
                    },
                    3,
                    {
                        "x": 1,
                        "y": 6
                    },
                    null,
                    {
                        "x": 1,
                        "y": 7
                    },
                    5,
                    {
                        "x": 1,
                        "y": 8
                    },
                    null,
                    {
                        "x": 1,
                        "y": 9
                    },
                    8,
                    {
                        "x": 2,
                        "y": 1
                    },
                    null,
                    {
                        "x": 2,
                        "y": 2
                    },
                    null,
                    {
                        "x": 2,
                        "y": 3
                    },
                    5,
                    {
                        "x": 2,
                        "y": 4
                    },
                    null,
                    {
                        "x": 2,
                        "y": 5
                    },
                    null,
                    {
                        "x": 2,
                        "y": 6
                    },
                    8,
                    {
                        "x": 2,
                        "y": 7
                    },
                    null,
                    {
                        "x": 2,
                        "y": 8
                    },
                    4,
                    {
                        "x": 2,
                        "y": 9
                    },
                    2,
                    {
                        "x": 3,
                        "y": 1
                    },
                    null,
                    {
                        "x": 3,
                        "y": 2
                    },
                    6,
                    {
                        "x": 3,
                        "y": 3
                    },
                    3,
                    {
                        "x": 3,
                        "y": 4
                    },
                    null,
                    {
                        "x": 3,
                        "y": 5
                    },
                    null,
                    {
                        "x": 3,
                        "y": 6
                    },
                    5,
                    {
                        "x": 3,
                        "y": 7
                    },
                    1,
                    {
                        "x": 3,
                        "y": 8
                    },
                    9,
                    {
                        "x": 3,
                        "y": 9
                    },
                    7,
                    {
                        "x": 4,
                        "y": 1
                    },
                    5,
                    {
                        "x": 4,
                        "y": 2
                    },
                    4,
                    {
                        "x": 4,
                        "y": 3
                    },
                    6,
                    {
                        "x": 4,
                        "y": 4
                    },
                    8,
                    {
                        "x": 4,
                        "y": 5
                    },
                    null,
                    {
                        "x": 4,
                        "y": 6
                    },
                    null,
                    {
                        "x": 4,
                        "y": 7
                    },
                    null,
                    {
                        "x": 4,
                        "y": 8
                    },
                    7,
                    {
                        "x": 4,
                        "y": 9
                    },
                    null,
                    {
                        "x": 5,
                        "y": 1
                    },
                    null,
                    {
                        "x": 5,
                        "y": 2
                    },
                    3,
                    {
                        "x": 5,
                        "y": 3
                    },
                    null,
                    {
                        "x": 5,
                        "y": 4
                    },
                    null,
                    {
                        "x": 5,
                        "y": 5
                    },
                    6,
                    {
                        "x": 5,
                        "y": 6
                    },
                    2,
                    {
                        "x": 5,
                        "y": 7
                    },
                    null,
                    {
                        "x": 5,
                        "y": 8
                    },
                    null,
                    {
                        "x": 5,
                        "y": 9
                    },
                    null,
                    {
                        "x": 6,
                        "y": 1
                    },
                    7,
                    {
                        "x": 6,
                        "y": 2
                    },
                    null,
                    {
                        "x": 6,
                        "y": 3
                    },
                    null,
                    {
                        "x": 6,
                        "y": 4
                    },
                    null,
                    {
                        "x": 6,
                        "y": 5
                    },
                    null,
                    {
                        "x": 6,
                        "y": 6
                    },
                    null,
                    {
                        "x": 6,
                        "y": 7
                    },
                    9,
                    {
                        "x": 6,
                        "y": 8
                    },
                    null,
                    {
                        "x": 6,
                        "y": 9
                    },
                    6,
                    {
                        "x": 7,
                        "y": 1
                    },
                    null,
                    {
                        "x": 7,
                        "y": 2
                    },
                    1,
                    {
                        "x": 7,
                        "y": 3
                    },
                    null,
                    {
                        "x": 7,
                        "y": 4
                    },
                    4,
                    {
                        "x": 7,
                        "y": 5
                    },
                    9,
                    {
                        "x": 7,
                        "y": 6
                    },
                    null,
                    {
                        "x": 7,
                        "y": 7
                    },
                    6,
                    {
                        "x": 7,
                        "y": 8
                    },
                    null,
                    {
                        "x": 7,
                        "y": 9
                    },
                    null,
                    {
                        "x": 8,
                        "y": 1
                    },
                    null,
                    {
                        "x": 8,
                        "y": 2
                    },
                    null,
                    {
                        "x": 8,
                        "y": 3
                    },
                    4,
                    {
                        "x": 8,
                        "y": 4
                    },
                    5,
                    {
                        "x": 8,
                        "y": 5
                    },
                    null,
                    {
                        "x": 8,
                        "y": 6
                    },
                    3,
                    {
                        "x": 8,
                        "y": 7
                    },
                    null,
                    {
                        "x": 8,
                        "y": 8
                    },
                    null,
                    {
                        "x": 8,
                        "y": 9
                    },
                    9,
                    {
                        "x": 9,
                        "y": 1
                    },
                    null,
                    {
                        "x": 9,
                        "y": 2
                    },
                    null,
                    {
                        "x": 9,
                        "y": 3
                    },
                    8,
                    {
                        "x": 9,
                        "y": 4
                    },
                    1,
                    {
                        "x": 9,
                        "y": 5
                    },
                    2,
                    {
                        "x": 9,
                        "y": 6
                    },
                    null,
                    {
                        "x": 9,
                        "y": 7
                    },
                    null,
                    {
                        "x": 9,
                        "y": 8
                    },
                    3,
                    {
                        "x": 9,
                        "y": 9
                    },
                    null
                ]
            }
            """.trimIndent()

        assertEquals(expectedJsonString, jsonString)
    }
}
