package org.ash.french.killer.sudoko.domain

import org.ash.french.killer.sudoko.builders.cellValue
import org.ash.french.killer.sudoko.builders.sudokuGrid

object TestConstants {
    val grid =
        sudokuGrid {
            cellValue(Cell(1, 1), 2)
            cellValue(Cell(1, 3), 7)
            cellValue(Cell(1, 5), 3)
            cellValue(Cell(1, 7), 5)
            cellValue(Cell(1, 9), 8)

            cellValue(Cell(2, 3), 5)
            cellValue(Cell(2, 6), 8)
            cellValue(Cell(2, 8), 4)
            cellValue(Cell(2, 9), 2)

            cellValue(Cell(3, 2), 6)
            cellValue(Cell(3, 3), 3)
            cellValue(Cell(3, 6), 5)
            cellValue(Cell(3, 7), 1)
            cellValue(Cell(3, 8), 9)
            cellValue(Cell(3, 9), 7)

            cellValue(Cell(4, 1), 5)
            cellValue(Cell(4, 2), 4)
            cellValue(Cell(4, 3), 6)
            cellValue(Cell(4, 4), 8)
            cellValue(Cell(4, 8), 7)

            cellValue(Cell(5, 2), 3)
            cellValue(Cell(5, 5), 6)
            cellValue(Cell(5, 6), 2)

            cellValue(Cell(6, 1), 7)
            cellValue(Cell(6, 7), 9)
            cellValue(Cell(6, 9), 6)

            cellValue(Cell(7, 2), 1)
            cellValue(Cell(7, 4), 4)
            cellValue(Cell(7, 5), 9)
            cellValue(Cell(7, 7), 6)

            cellValue(Cell(8, 3), 4)
            cellValue(Cell(8, 4), 5)
            cellValue(Cell(8, 6), 3)
            cellValue(Cell(8, 9), 9)

            cellValue(Cell(9, 3), 8)
            cellValue(Cell(9, 4), 1)
            cellValue(Cell(9, 5), 2)
            cellValue(Cell(9, 8), 3)
        }.build()

    val grid2 =
        sudokuGrid {
            cellValue {
                x = 1
                y = 1
                value = 2
            }
            cellValue {
                x = 1
                y = 3
                value = 7
            }
            cellValue {
                x = 1
                y = 5
                value = 3
            }
            cellValue {
                x = 1
                y = 7
                value = 5
            }
            cellValue {
                x = 1
                y = 9
                value = 8
            }

            cellValue {
                x = 2
                y = 3
                value = 5
            }
            cellValue {
                x = 2
                y = 6
                value = 8
            }
            cellValue {
                x = 2
                y = 8
                value = 4
            }
            cellValue {
                x = 2
                y = 9
                value = 2
            }

            cellValue {
                x = 3
                y = 2
                value = 6
            }
            cellValue {
                x = 3
                y = 3
                value = 3
            }
            cellValue {
                x = 3
                y = 6
                value = 5
            }
            cellValue {
                x = 3
                y = 7
                value = 1
            }
            cellValue {
                x = 3
                y = 8
                value = 9
            }
            cellValue {
                x = 3
                y = 9
                value = 7
            }

            cellValue {
                x = 4
                y = 1
                value = 5
            }
            cellValue {
                x = 4
                y = 2
                value = 4
            }
            cellValue {
                x = 4
                y = 3
                value = 6
            }
            cellValue {
                x = 4
                y = 4
                value = 8
            }
            cellValue {
                x = 4
                y = 8
                value = 7
            }

            cellValue {
                x = 5
                y = 2
                value = 3
            }
            cellValue {
                x = 5
                y = 5
                value = 6
            }
            cellValue {
                x = 5
                y = 6
                value = 2
            }

            cellValue {
                x = 6
                y = 1
                value = 7
            }
            cellValue {
                x = 6
                y = 7
                value = 9
            }
            cellValue {
                x = 6
                y = 9
                value = 6
            }

            cellValue {
                x = 7
                y = 2
                value = 1
            }
            cellValue {
                x = 7
                y = 4
                value = 4
            }
            cellValue {
                x = 7
                y = 5
                value = 9
            }
            cellValue {
                x = 7
                y = 7
                value = 6
            }

            cellValue {
                x = 8
                y = 3
                value = 4
            }
            cellValue {
                x = 8
                y = 4
                value = 5
            }
            cellValue {
                x = 8
                y = 6
                value = 3
            }
            cellValue {
                x = 8
                y = 9
                value = 9
            }

            cellValue {
                x = 9
                y = 3
                value = 8
            }
            cellValue {
                x = 9
                y = 4
                value = 1
            }
            cellValue {
                x = 9
                y = 5
                value = 2
            }
            cellValue {
                x = 9
                y = 8
                value = 3
            }
        }.build()
}
