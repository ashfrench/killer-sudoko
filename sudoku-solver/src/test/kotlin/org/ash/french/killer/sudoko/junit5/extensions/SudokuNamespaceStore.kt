package org.ash.french.killer.sudoko.junit5.extensions

import org.ash.french.killer.sudoko.generators.SudokuGrid

data object SudokuNamespaceStore {
    val grid: SudokuGrid = SudokuGrid()
}


