package org.ash.french.killer.sudoko.junit5.extensions

import org.ash.french.killer.sudoko.generators.SudokuGrid
import org.junit.jupiter.api.extension.ExtensionContext
import kotlin.test.assertNotNull

data class SudokuNamespaceStore(private val context: ExtensionContext) {

    private val sudokuNamespace = SudokuNamespace
    val grid: SudokuGrid = SudokuGrid()
    init {
        val namespace = sudokuNamespace.namespace
        val sudokuStore = context.getStore(namespace)?: throw RuntimeException("Sudoku Namespace not initialised")
        assertNotNull(sudokuStore)
        val sudokuNamespaceStore = sudokuStore.getOrComputeIfAbsent(namespace) { this } as SudokuNamespaceStore
        assertNotNull(sudokuNamespaceStore)
    }
}

fun ExtensionContext.sudokuNamespaceStore() = getStore(SudokuNamespace.namespace)[SudokuNamespace] as SudokuNamespaceStore