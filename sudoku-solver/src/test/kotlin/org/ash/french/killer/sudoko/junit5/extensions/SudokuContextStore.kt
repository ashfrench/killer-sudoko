@file:Suppress("unused")

package org.ash.french.killer.sudoko.junit5.extensions

import org.ash.french.killer.sudoko.generators.SudokuGrid
import org.junit.jupiter.api.extension.ExtensionContext
import java.util.function.Function

@Suppress("UNUSED")
object SudokuContextStore : ExtensionContext.Store, ExtensionContext.Store.CloseableResource {
    private val sudokuMapStore = mutableMapOf<Any?, Any?>()

    private val grid: SudokuGrid = SudokuGrid()

    override fun get(key: Any?) =
        sudokuMapStore[key]

    @Suppress("UNCHECKED_CAST")
    override fun <V : Any?> get(
        key: Any?,
        requiredType: Class<V>?
    ) =
        sudokuMapStore[key] as V


    override fun <K : Any?, V : Any?> getOrComputeIfAbsent(
        key: K,
        defaultCreator: Function<K, V>
    ) =
        sudokuMapStore.computeIfAbsent(key) { _ -> defaultCreator.apply(key) }


    @Suppress("UNCHECKED_CAST")
    override fun <K : Any?, V : Any?> getOrComputeIfAbsent(
        key: K,
        defaultCreator: Function<K, V>,
        requiredType: Class<V>
    ): V = sudokuMapStore.computeIfAbsent(key) { _ -> defaultCreator.apply(key) } as V

    override fun put(
        key: Any?,
        value: Any?
    ) {
        sudokuMapStore[key] = value
    }

    override fun remove(key: Any?) = sudokuMapStore.remove(key)

    @Suppress("UNCHECKED_CAST")
    override fun <V : Any?> remove(
        key: Any?,
        requiredType: Class<V>?
    ): V {
        sudokuMapStore.remove(key)
        return key as V
    }

    override fun close() {
        println("Close Sudoku Context Store")
    }
}
