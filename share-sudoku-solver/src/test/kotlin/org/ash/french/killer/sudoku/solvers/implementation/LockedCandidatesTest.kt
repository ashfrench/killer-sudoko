package org.ash.french.killer.sudoku.solvers.implementation

import org.ash.french.killer.sudoku.builders.cellValues
import org.ash.french.killer.sudoku.builders.sudokuGrid
import org.ash.french.killer.sudoku.domain.CellUpdateValueOriginalValue
import org.junit.jupiter.api.Test

class LockedCandidatesTest {
    @Test
    fun `can test locked candidates`() {
        val grid =
            sudokuGrid {
                cellValues {
                    cell {
                        x = 2
                        y = 1
                    }
                    cell {
                        x = 3
                        y = 4
                    }
                    value = 1
                }

                cellValues {
                    cell {
                        x = 2
                        y = 9
                    }
                    cell {
                        x = 3
                        y = 1
                    }
                    value = 2
                }

                cellValues {
                    cell {
                        x = 6
                        y = 2
                    }
                    value = 3
                }

                cellValues {
                    cell {
                        x = 3
                        y = 8
                    }

                    cell {
                        x = 9
                        y = 5
                    }
                    value = 4
                }

                cellValues {
                    cell {
                        x = 2
                        y = 3
                    }

                    cell {
                        x = 3
                        y = 6
                    }
                    value = 5
                }

                cellValues {
                    cell {
                        x = 2
                        y = 5
                    }

                    cell {
                        x = 3
                        y = 6
                    }
                    value = 6
                }

                cellValues {
                    cell {
                        x = 2
                        y = 7
                    }
                    value = 7
                }

                cellValues {
                    cell {
                        x = 3
                        y = 7
                    }

                    cell {
                        x = 5
                        y = 5
                    }
                    value = 8
                }

                cellValues {
                    cell {
                        x = 3
                        y = 9
                    }

                    cell {
                        x = 4
                        y = 5
                    }
                    value = 9
                }
            }.build()

        val updates = LockedCandidates().getCellUpdates(grid)
        val expectedUpdate = CellUpdateValueOriginalValue(x = 2, y = 8, 3)
    }
}
