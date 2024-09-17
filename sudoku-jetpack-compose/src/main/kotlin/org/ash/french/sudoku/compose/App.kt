package org.ash.french.sudoku.compose

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import org.ash.french.killer.sudoku.builders.cellValue
import org.ash.french.killer.sudoku.builders.sudokuGrid
import org.ash.french.sudoku.compose.domain.nonetCard

@Composable
@Preview
fun app() {
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

    val nonets = grid.getNonets()

    var text by remember { mutableStateOf(grid.toString()) }
    println(text)

    MaterialTheme {
        Card {
            Box {
                (0..8).chunked(3).forEach { nonetOrder ->
                    Row {
                        nonetOrder.forEach { position ->
                            val nonet = grid.getNonet(position)
                            Column {
                                nonetCard(nonet, grid)
                            }
                        }
                    }
                }
            }
        }
    }
}
