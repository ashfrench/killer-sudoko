package org.ash.french.killer.sudoku.solvers.implementation

import org.ash.french.killer.sudoku.builders.cellValues
import org.ash.french.killer.sudoku.builders.sudokuGrid
import org.ash.french.killer.sudoku.domain.CellRemovePotentialValueUpdate
import org.junit.jupiter.api.Test

class XYWingTest {
    // https://www.sudoku9x9.com/techniques/xywing/block_column/
    @Test
    fun `can test xy wing nonet-column`() {
        val grid =
            sudokuGrid {
                cellValues {
                    cell {
                        x = 2
                        y = 3
                    }

                    cell {
                        x = 3
                        y = 7
                    }

                    cell {
                        x = 5
                        y = 2
                    }

                    cell {
                        x = 7
                        y = 6
                    }

                    cell {
                        x = 8
                        y = 8
                    }

                    cell {
                        x = 9
                        y = 1
                    }

                    value = 1
                }

                cellValues {
                    cell {
                        x = 1
                        y = 6
                    }

                    cell {
                        x = 2
                        y = 7
                    }

                    cell {
                        x = 3
                        y = 2
                    }

                    cell {
                        x = 5
                        y = 5
                    }

                    cell {
                        x = 7
                        y = 1
                    }

                    cell {
                        x = 9
                        y = 8
                    }

                    value = 2
                }

                cellValues {
                    cell {
                        x = 1
                        y = 2
                    }

                    cell {
                        x = 2
                        y = 8
                    }

                    cell {
                        x = 4
                        y = 1
                    }

                    cell {
                        x = 7
                        y = 4
                    }

                    cell {
                        x = 9
                        y = 3
                    }
                    value = 3
                }

                cellValues {
                    cell {
                        x = 2
                        y = 5
                    }

                    cell {
                        x = 6
                        y = 2
                    }

                    cell {
                        x = 9
                        y = 6
                    }
                    value = 4
                }

                cellValues {
                    cell {
                        x = 1
                        y = 9
                    }

                    cell {
                        x = 5
                        x = 7
                    }

                    cell {
                        x = 7
                        y = 8
                    }

                    cell {
                        x = 9
                        y = 6
                    }
                    value = 5
                }

                cellValues {
                    cell {
                        x = 5
                        y = 1
                    }

                    cell {
                        x = 6
                        y = 8
                    }

                    value = 6
                }

                cellValues {
                    cell {
                        x = 1
                        y = 3
                    }

                    cell {
                        x = 3
                        y = 8
                    }

                    cell {
                        x = 6
                        y = 1
                    }

                    cell {
                        x = 9
                        y = 2
                    }
                    value = 7
                }

                cellValues {
                    cell {
                        x = 2
                        y = 4
                    }

                    cell {
                        x = 8
                        y = 6
                    }
                    value = 8
                }

                cellValues {
                    cell {
                        x = 4
                        y = 8
                    }

                    cell {
                        x = 9
                        y = 6
                    }
                    value = 9
                }
            }.build()

        val updates = XYWing.getCellUpdates(grid)
        listOf(
            CellRemovePotentialValueUpdate(6, 4, 3),
            CellRemovePotentialValueUpdate(6, 5, 3),
            CellRemovePotentialValueUpdate(5, 9, 3),
        )
    }
}
