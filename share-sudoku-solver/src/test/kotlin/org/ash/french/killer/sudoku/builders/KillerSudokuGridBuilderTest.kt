package org.ash.french.killer.sudoku.builders

import org.junit.jupiter.api.Test

class KillerSudokuGridBuilderTest {

    @Test
    fun `test can build new killer sudoku grid`() {

        val grid = killerSudokuGrid {
            cage {
                cell {
                    x = 1
                    y = 1
                }
                cell {
                    x = 2
                    y = 1
                }
                cell {
                    x = 3
                    y = 1
                }
                cell {
                    x = 2
                    y = 2
                }
                cageSum = 17
            }

        }.build()

    }
}
