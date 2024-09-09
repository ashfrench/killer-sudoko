package org.ash.french.killer.sudoko.junit5.extensions

import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.ParameterContext
import org.junit.jupiter.api.extension.ParameterResolver
import kotlin.test.assertNotNull
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
object SudokuParameterResolver : ParameterResolver {
    override fun supportsParameter(
        parameterContext: ParameterContext,
        extensionContext: ExtensionContext,
    ): Boolean {
        val store = extensionContext.sudokuNamespaceStore()
        val sudokuContextStore = store[SudokuNamespace.namespace]
        assertNotNull(sudokuContextStore) { "Context Store is Null" }
        return sudokuContextStore is SudokuContextStore
    }

    override fun resolveParameter(
        parameterContext: ParameterContext,
        extensionContext: ExtensionContext,
    ): Any {
        return if (parameterContext.parameter::class == SudokuContextStore::class) {
            SudokuContextStore
        } else {
            throw RuntimeException("Unexpected Parameter")
        }
    }
}
