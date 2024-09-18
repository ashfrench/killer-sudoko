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
import org.ash.french.killer.sudoku.builders.randomDefaultGrid
import org.ash.french.sudoku.compose.domain.nonetCard

@Composable
@Preview
fun app() {
    val grid = randomDefaultGrid()
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
