package org.ash.french.killer.sudoku.solvers.implementation

import org.ash.french.killer.sudoku.builders.sudokuGrid
import org.junit.jupiter.api.Test

class HiddenSingleTest {
    @Test
    fun `can test hidden single in nonet`() {
        val grid = sudokuGrid {}.build()
    }
}
