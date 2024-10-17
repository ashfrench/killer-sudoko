package org.ash.french.killer.sudoku.solvers.implementation

import org.ash.french.killer.sudoku.builders.cellValues
import org.ash.french.killer.sudoku.builders.sudokuGrid
import org.junit.jupiter.api.Test

class XWingTest {
    // https://www.sudoku9x9.com/techniques/xwing/
    @Test
    fun `can test x wing nonet-column`() {
        val grid =
            sudokuGrid {
                cellValues {
                    cell {
                        x = 1
                        y = 8
                    }

                    cell {
                        x = 3
                        y = 2
                    }

                    cell {
                        x = 4
                        y = 7
                    }

                    cell {
                        x = 5
                        y = 3
                    }

                    cell {
                        x = 6
                        y = 6
                    }

                    cell {
                        x = 8
                        y = 1
                    }
                    value = 1
                }

                cellValues {
                    cell {
                        x = 1
                        y = 4
                    }

                    cell {
                        x = 3
                        y = 3
                    }

                    cell {
                        x = 6
                        y = 9
                    }

                    value = 2
                }

                cellValues {
                    cell {
                        x = 4
                        y = 5
                    }

                    cell {
                        x = 5
                        y = 2
                    }

                    cell {
                        x = 6
                        y = 8
                    }

                    cell {
                        x = 8
                        y = 7
                    }
                    value = 3
                }

                cellValues {
                    cell {
                        x = 2
                        y = 3
                    }

                    cell {
                        x = 5
                        y = 9
                    }

                    cell {
                        x = 6
                        y = 5
                    }
                    value = 4
                }

                cellValues {
                    cell {
                        x = 1
                        y = 2
                    }

                    cell {
                        x = 4
                        y = 6
                    }

                    cell {
                        x = 5
                        y = 7
                    }

                    cell {
                        x = 6
                        y = 1
                    }

                    cell {
                        x = 7
                        y = 3
                    }

                    cell {
                        x = 8
                        y = 4
                    }

                    value = 5
                }

                cellValues {
                    cell {
                        x = 2
                        y = 6
                    }

                    cell {
                        x = 4
                        y = 9
                    }

                    cell {
                        x = 5
                        y = 4
                    }

                    cell {
                        x = 6
                        y = 3
                    }

                    cell {
                        x = 7
                        y = 2
                    }

                    cell {
                        x = 8
                        y = 8
                    }

                    cell {
                        x = 9
                        y = 5
                    }
                    value = 6
                }

                cellValues {
                    cell {
                        x = 2
                        y = 1
                    }

                    cell {
                        x = 4
                        y = 3
                    }

                    cell {
                        x = 5
                        y = 8
                    }

                    cell {
                        x = 6
                        y = 4
                    }

                    cell {
                        x = 8
                        y = 5
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
                        y = 2
                    }

                    cell {
                        x = 4
                        y = 4
                    }

                    cell {
                        x = 5
                        y = 1
                    }

                    cell {
                        x = 6
                        y = 7
                    }

                    cell {
                        x = 7
                        y = 8
                    }

                    cell {
                        x = 9
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
                        x = 6
                        y = 2
                    }

                    cell {
                        x = 7
                        y = 4
                    }

                    cell {
                        x = 8
                        y = 9
                    }

                    value = 9
                }
            }.build()

        val updates = XWing.getCellUpdates(grid)
    }
}
