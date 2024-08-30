package org.ash.french.killer.sudoko.junit5.extensions

import org.ash.french.killer.sudoko.generators.SudokuGrid
import org.junit.jupiter.api.extension.ExtensionContext
import java.util.function.Function
import kotlin.test.assertNotNull

data class SudokuNamespaceStore(private val context: ExtensionContext): ExtensionContext.Store, ExtensionContext.Store.CloseableResource {

    private val sudokuNamespace = SudokuNamespace
    val grid: SudokuGrid = SudokuGrid()
    init {
        val namespace = sudokuNamespace.namespace
        val sudokuStore = context.getStore(namespace)?: throw RuntimeException("Sudoku Namespace not initialised")
        assertNotNull(sudokuStore)
        val sudokuNamespaceStore = sudokuStore.getOrComputeIfAbsent(namespace) { this } as SudokuNamespaceStore
        assertNotNull(sudokuNamespaceStore)
    }

    override fun get(key: Any?): Any {
        TODO("Not yet implemented")
    }

    override fun <V : Any?> get(key: Any?, requiredType: Class<V>?): V {
        TODO("Not yet implemented")
    }

    override fun <K : Any?, V : Any?> getOrComputeIfAbsent(key: K, defaultCreator: Function<K, V>?): Any {
        TODO("Not yet implemented")
    }

    override fun <K : Any?, V : Any?> getOrComputeIfAbsent(
        key: K,
        defaultCreator: Function<K, V>?,
        requiredType: Class<V>?
    ): V {
        TODO("Not yet implemented")
    }

    override fun put(key: Any?, value: Any?) {
        TODO("Not yet implemented")
    }

    override fun remove(key: Any?): Any {
        TODO("Not yet implemented")
    }

    override fun <V : Any?> remove(key: Any?, requiredType: Class<V>?): V {
        TODO("Not yet implemented")
    }

    override fun close() {
        TODO("Not yet implemented")
    }
}

fun ExtensionContext.sudokuNamespaceStore() = getStore(SudokuNamespace.namespace)[SudokuNamespace] as SudokuNamespaceStore