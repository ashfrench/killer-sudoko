package org.ash.french.killer.sudoku.domain

import org.ash.french.killer.sudoku.builders.cellValue
import org.ash.french.killer.sudoku.builders.sudokuGrid
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
internal object TestConstants {
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

    val jsonString =
"""{
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
}"""
}
