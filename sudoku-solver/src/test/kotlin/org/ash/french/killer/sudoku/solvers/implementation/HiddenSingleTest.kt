package org.ash.french.killer.sudoku.solvers.implementation

import org.ash.french.killer.sudoku.builders.cellValue
import org.ash.french.killer.sudoku.builders.cellValues
import org.ash.french.killer.sudoku.builders.sudokuGrid
import org.ash.french.killer.sudoku.domain.CellUpdate
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
        val expectedUpdate = CellUpdate(x = 2, y = 5, 2)
    }

    @Test
    fun `can test hidden single in row`() {
        val grid =
            sudokuGrid {
                cellValues {
                    cell {
                        x = 1
                        y = 6
                    }
                    cell {
                        x = 3
                        y = 3
                    }
                    cell {
                        x = 4
                        y = 1
                    }
                    cell {
                        x = 7
                        y = 2
                    }
                    cell {
                        x = 8
                        y = 5
                    }
                    value = 1
                }

                cellValues {
                    cell {
                        x = 1
                        y = 7
                    }
                    cell {
                        x = 5
                        y = 3
                    }
                    cell {
                        x = 6
                        y = 9
                    }
                    cell {
                        x = 8
                        y = 2
                    }
                    cell {
                        x = 9
                        y = 5
                    }
                    value = 2
                }

                cellValues {
                    cell {
                        x = 1
                        y = 5
                    }
                    cell {
                        x = 2
                        y = 2
                    }
                    cell {
                        x = 3
                        y = 9
                    }
                    cell {
                        x = 4
                        y = 3
                    }
                    cell {
                        x = 5
                        y = 6
                    }
                    cell {
                        x = 6
                        y = 8
                    }
                    cell {
                        x = 7
                        y = 7
                    }
                    cell {
                        x = 8
                        y = 4
                    }
                    cell {
                        x = 9
                        y = 1
                    }
                    value = 3
                }

                cellValues {
                    cell {
                        x = 1
                        y = 9
                    }
                    cell {
                        x = 2
                        y = 5
                    }
                    cell {
                        x = 6
                        y = 7
                    }
                    cell {
                        x = 9
                        y = 3
                    }
                    value = 4
                }

                cellValues {
                    cell {
                        x = 1
                        y = 8
                    }
                    cell {
                        x = 2
                        y = 3
                    }
                    cell {
                        x = 4
                        y = 9
                    }
                    cell {
                        x = 5
                        y = 2
                    }
                    cell {
                        x = 9
                        y = 4
                    }
                    value = 5
                }

                cellValues {
                    cell {
                        x = 2
                        y = 7
                    }
                    cell {
                        x = 6
                        y = 6
                    }
                    cell {
                        x = 9
                        y = 2
                    }
                    value = 6
                }

                cellValues {
                    cell {
                        x = 1
                        y = 2
                    }
                    cell {
                        x = 4
                        y = 5
                    }
                    cell {
                        x = 8
                        y = 7
                    }
                    value = 7
                }

                cellValues {
                    cell {
                        x = 3
                        y = 8
                    }
                    cell {
                        x = 5
                        y = 5
                    }
                    cell {
                        x = 7
                        y = 6
                    }
                    cell {
                        x = 8
                        y = 2
                    }
                    value = 8
                }

                cellValues {
                    cell {
                        x = 1
                        y = 1
                    }
                    cell {
                        x = 2
                        y = 4
                    }
                    cell {
                        x = 5
                        y = 8
                    }
                    value = 9
                }
            }.build()

        println(grid)
        val updates = HiddenSingle().getCellUpdates(grid)
        val expectedUpdate = CellUpdate(x = 4, y = 7, 5)
    }

    @Test
    fun `can test hidden single in column`() {
        val grid =
            sudokuGrid {
                cellValues {
                    cell {
                        x = 4
                        y = 8
                    }
                    cell {
                        x = 9
                        y = 4
                    }
                    value = 1
                }

                cellValues {
                    cell {
                        x = 6
                        y = 5
                    }
                    cell {
                        x = 7
                        y = 2
                    }
                    value = 2
                }

                cellValues {
                    cell {
                        x = 3
                        y = 6
                    }
                    cell {
                        x = 9
                        y = 2
                    }
                    value = 3
                }

                cellValues {
                    cell {
                        x = 3
                        y = 1
                    }
                    cell {
                        x = 5
                        y = 7
                    }
                    cell {
                        x = 7
                        y = 5
                    }
                    cell {
                        x = 8
                        y = 3
                    }
                    value = 4
                }

                cellValues {
                    cell {
                        x = 1
                        y = 8
                    }
                    cell {
                        x = 5
                        y = 9
                    }
                    value = 5
                }

                cellValues {
                    cell {
                        x = 3
                        y = 5
                    }
                    cell {
                        x = 7
                        y = 7
                    }
                    cell {
                        x = 9
                        y = 1
                    }
                    value = 6
                }

                cellValues {
                    cell {
                        x = 3
                        y = 2
                    }
                    cell {
                        x = 9
                        y = 1
                    }
                    value = 7
                }

                cellValues {
                    cell {
                        x = 6
                        y = 6
                    }
                    value = 8
                }

                cellValues {
                    cell {
                        x = 1
                        y = 1
                    }
                    cell {
                        x = 2
                        y = 5
                    }
                    cell {
                        x = 5
                        y = 3
                    }
                    cell {
                        x = 6
                        y = 4
                    }
                    cell {
                        x = 7
                        y = 8
                    }
                    cell {
                        x = 8
                        y = 2
                    }
                    cell {
                        x = 9
                        y = 6
                    }
                    value = 9
                }
            }.build()

        println(grid)
        val updates = HiddenSingle().getCellUpdates(grid)
        val expectedUpdate = CellUpdate(x = 6, y = 2, 4)
    }
}
