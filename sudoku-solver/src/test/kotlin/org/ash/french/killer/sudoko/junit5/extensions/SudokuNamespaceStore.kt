package org.ash.french.killer.sudoko.junit5.extensions

import org.junit.jupiter.api.extension.ExtensionContext
import kotlin.test.assertNotNull

data class SudokuNamespaceStore(private val context: ExtensionContext) :
    ExtensionContext.Store by SudokuContextStore,
    ExtensionContext.Store.CloseableResource by SudokuContextStore {
    private val sudokuNamespace = SudokuNamespace

    init {
        val namespace = sudokuNamespace.namespace
        val sudokuStore =
            context.getStore(namespace) ?: throw RuntimeException("Sudoku Namespace not initialised")
        assertNotNull(sudokuStore)
        val sudokuNamespaceStore = sudokuStore.getOrComputeIfAbsent(namespace) { this } as SudokuNamespaceStore
        assertNotNull(sudokuNamespaceStore)
    }

    override fun close() {
        return
    }
}

fun ExtensionContext.sudokuNamespaceStore() = getStore(SudokuNamespace.namespace)[SudokuNamespace] as SudokuNamespaceStore
