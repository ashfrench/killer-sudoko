package org.ash.french.killer.sudoku.junit5.extensions

import org.ash.french.killer.sudoku.domain.KillerSudokuGrid
import org.ash.french.killer.sudoku.generators.GridFactory
import org.junit.jupiter.api.extension.ExtensionContext
import kotlin.test.assertNotNull

internal data class SudokuNamespaceStore(private val context: ExtensionContext) :
    ExtensionContext.Store by SudokuContextStore,
    ExtensionContext.Store.CloseableResource by SudokuContextStore {
    private val sudokuNamespace = SudokuNamespace

    val sudokuGrid: KillerSudokuGrid by lazy { GridFactory.defaultSudokuGrid() }

    init {
        val namespace = SudokuNamespace.namespace
        val sudokuStore =
            context.getStore(namespace) ?: throw RuntimeException("Sudoku Namespace not initialised")
        assertNotNull(sudokuStore)
        val sudokuNamespaceStore = sudokuStore.getOrComputeIfAbsent(namespace) { this } as SudokuNamespaceStore
        assertNotNull(sudokuNamespaceStore)
    }

    override fun close() = Unit
}

internal fun ExtensionContext.sudokuNamespaceStore() = getStore(SudokuNamespace.namespace)[SudokuNamespace] as SudokuNamespaceStore
