package org.ash.french.killer.sudoku.builders

import org.junit.jupiter.api.Test

class KillerSudokuGridBuilderTest {
    @Test
    fun `test can build new killer sudoku grid`() {
        val grid =
            killerSudokuGrid {
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
                cage {
                    cell {
                        x = 1
                        y = 2
                    }
                    cell {
                        x = 1
                        y = 3
                    }
                    cell {
                        x = 2
                        y = 3
                    }
                    cell {
                        x = 3
                        y = 3
                    }
                    cell {
                        x = 4
                        y = 3
                    }
                    cageSum = 28
                }
                cage {
                    cell {
                        x = 3
                        y = 2
                    }
                    cageSum = 6
                }
                cage {
                    cell {
                        x = 4
                        y = 2
                    }
                    cageSum = 2
                }
                cage {
                    cell {
                        x = 4
                        y = 1
                    }
                    cell {
                        x = 5
                        y = 1
                    }
                    cageSum = 10
                }
                cage {
                    cell {
                        x = 6
                        y = 1
                    }
                    cell {
                        x = 7
                        y = 1
                    }
                    cageSum = 17
                }
                cage {
                    cell {
                        x = 6
                        y = 2
                    }
                    cell {
                        x = 7
                        y = 2
                    }
                    cageSum = 10
                }
                cage {
                    cell {
                        x = 5
                        y = 2
                    }
                    cell {
                        x = 5
                        y = 3
                    }
                    cell {
                        x = 6
                        y = 3
                    }
                    cageSum = 10
                }

                cage {
                    cell {
                        x = 8
                        y = 1
                    }
                    cell {
                        x = 8
                        y = 2
                    }
                    cell {
                        x = 8
                        y = 3
                    }
                    cell {
                        x = 8
                        y = 4
                    }
                    cageSum = 22
                }
                cage {
                    cell {
                        x = 9
                        y = 1
                    }
                    cell {
                        x = 9
                        y = 2
                    }
                    cageSum = 7
                }
                cage {
                    cell {
                        x = 9
                        y = 3
                    }
                    cell {
                        x = 9
                        y = 4
                    }
                    cageSum = 12
                }
                cage {
                    cell {
                        x = 7
                        y = 3
                    }
                    cell {
                        x = 7
                        y = 4
                    }
                    cageSum = 5
                }
                cage {
                    cell {
                        x = 1
                        y = 4
                    }
                    cell {
                        x = 1
                        y = 5
                    }
                    cageSum = 13
                }
                cage {
                    cell {
                        x = 2
                        y = 4
                    }
                    cell {
                        x = 2
                        y = 5
                    }
                    cageSum = 4
                }
                cage {
                    cell {
                        x = 3
                        y = 4
                    }
                    cell {
                        x = 3
                        y = 5
                    }
                    cell {
                        x = 3
                        y = 6
                    }
                    cageSum = 22
                }
                cage {
                    cell {
                        x = 1
                        y = 6
                    }
                    cell {
                        x = 2
                        y = 6
                    }
                    cageSum = 6
                }
                cage {
                    cell {
                        x = 4
                        y = 4
                    }
                    cell {
                        x = 5
                        y = 4
                    }
                    cageSum = 11
                }
                cage {
                    cell {
                        x = 6
                        y = 4
                    }
                    cell {
                        x = 6
                        y = 5
                    }
                    cageSum = 7
                }
                cage {
                    cell {
                        x = 4
                        y = 5
                    }
                    cell {
                        x = 5
                        y = 5
                    }
                    cell {
                        x = 4
                        y = 6
                    }
                    cageSum = 20
                }
                cage {
                    cell {
                        x = 5
                        y = 6
                    }
                    cell {
                        x = 5
                        y = 7
                    }
                    cageSum = 10
                }
                cage {
                    cell {
                        x = 6
                        y = 6
                    }
                    cell {
                        x = 6
                        y = 7
                    }
                    cell {
                        x = 7
                        y = 7
                    }
                    cageSum = 15
                }
                cage {
                    cell {
                        x = 7
                        y = 5
                    }
                    cell {
                        x = 7
                        y = 6
                    }
                    cageSum = 11
                }
                cage {
                    cell {
                        x = 8
                        y = 5
                    }
                    cell {
                        x = 9
                        y = 5
                    }
                    cell {
                        x = 9
                        y = 6
                    }
                    cageSum = 18
                }
                cage {
                    cell {
                        x = 8
                        y = 6
                    }
                    cell {
                        x = 8
                        y = 7
                    }
                    cell {
                        x = 9
                        y = 7
                    }
                    cell {
                        x = 9
                        y = 8
                    }
                    cageSum = 18
                }
                cage {
                    cell {
                        x = 1
                        y = 7
                    }
                    cell {
                        x = 1
                        y = 8
                    }
                    cell {
                        x = 2
                        y = 8
                    }
                    cageSum = 11
                }
                cage {
                    cell {
                        x = 2
                        y = 7
                    }
                    cell {
                        x = 3
                        y = 7
                    }
                    cell {
                        x = 3
                        y = 8
                    }
                    cageSum = 16
                }
                cage {
                    cell {
                        x = 1
                        y = 9
                    }
                    cell {
                        x = 2
                        y = 9
                    }
                    cell {
                        x = 3
                        y = 9
                    }
                    cageSum = 18
                }
                cage {
                    cell {
                        x = 4
                        y = 7
                    }
                    cageSum = 8
                }
                cage {
                    cell {
                        x = 4
                        y = 8
                    }
                    cell {
                        x = 4
                        y = 9
                    }
                    cell {
                        x = 5
                        y = 9
                    }
                    cageSum = 12
                }
                cage {
                    cell {
                        x = 5
                        y = 8
                    }
                    cell {
                        x = 6
                        y = 8
                    }
                    cageSum = 9
                }
                cage {
                    cell {
                        x = 7
                        y = 8
                    }
                    cell {
                        x = 7
                        y = 9
                    }
                    cell {
                        x = 6
                        y = 9
                    }
                    cageSum = 17
                }
                cage {
                    cell {
                        x = 8
                        y = 8
                    }
                    cell {
                        x = 8
                        y = 9
                    }
                    cell {
                        x = 9
                        y = 9
                    }
                    cageSum = 13
                }
            }.build()
    }
}
