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

}