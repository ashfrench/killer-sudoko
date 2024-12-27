package org.ash.french.killer.sudoku.builders

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class KillerSudokuGridBuilderTest {

    @Test
    fun `test can build new killer sudoku grid`() {

        val grid = killerSudokuGrid {

        }.build()

    }

}