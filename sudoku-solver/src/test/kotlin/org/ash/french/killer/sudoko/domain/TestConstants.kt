package org.ash.french.killer.sudoko.domain

import org.ash.french.killer.sudoko.builders.cellValue
import org.ash.french.killer.sudoko.builders.sudokuGrid

object TestConstants {
    val grid =
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
