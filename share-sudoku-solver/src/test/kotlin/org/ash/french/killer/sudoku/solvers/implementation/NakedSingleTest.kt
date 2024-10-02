package org.ash.french.killer.sudoku.solvers.implementation

import org.ash.french.killer.sudoku.builders.cellValue
import org.ash.french.killer.sudoku.builders.sudokuGrid
import org.ash.french.killer.sudoku.domain.CellUpdateValueOriginalValue
import org.junit.jupiter.api.Test

class NakedSingleTest {
    @Test
    fun `can test naked single`() {
        val grid =
            sudokuGrid {
                cellValue {
                    x = 2
                    y = 2
                    value = 8
                }

                cellValue {
                    x = 4
                    y = 2
                    value = 1
                }

                cellValue {
                    x = 6
                    y = 1
                    value = 2
                }

                cellValue {
                    x = 6
                    y = 3
                    value = 9
                }

                cellValue {
                    x = 7
                    y = 2
                    value = 4
                }

                cellValue {
                    x = 8
                    y = 2
                    value = 5
                }

                cellValue {
                    x = 5
                    y = 5
                    value = 6
                }

                cellValue {
                    x = 6
                    y = 5
                    value = 7
                }
            }.build()

        val updates = NakedSingle().getCellUpdates(grid)
        val expectedUpdate = CellUpdateValueOriginalValue(x = 5, y = 2, 3)
    }
}
