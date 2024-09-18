package org.ash.french.killer.sudoku.solvers.implementation

import org.ash.french.killer.sudoku.builders.cellValue
import org.ash.french.killer.sudoku.builders.sudokuGrid
import org.junit.jupiter.api.Test

class HiddenSingleTest {
    @Test
    fun `can test hidden single in nonet`() {
        val grid =
            sudokuGrid {
                cellValue {
                    x = 1
                    y = 5
                    value = 1
                }

                cellValue {
                    x = 3
                    y = 5
                    value = 3
                }

                cellValue {
                    x = 6
                    y = 4
                    value = 2
                }

                cellValue {
                    x = 8
                    y = 6
                    value = 2
                }
            }.build()

        val updates = HiddenSingle().getCellUpdates(grid)
    }
}
