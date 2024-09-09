package org.ash.french.killer.sudoko.junit5.extensions

import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.TestInstancePostProcessor
import kotlin.test.assertNotNull
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
object SudokuTestInstancePostProcessor : TestInstancePostProcessor {
    override fun postProcessTestInstance(
        testInstance: Any,
        context: ExtensionContext,
    ) {
        val contextStore = context.sudokuNamespaceStore()
        assertNotNull(contextStore) { "No Sudoku Store Setup" }

        assertNotNull(testInstance)
        println(testInstance::class.simpleName + " Test instance teardown")
    }
}
