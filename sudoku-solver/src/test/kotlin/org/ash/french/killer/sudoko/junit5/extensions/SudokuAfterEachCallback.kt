package org.ash.french.killer.sudoko.junit5.extensions

import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import kotlin.test.assertNotNull
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
object SudokuAfterEachCallback : AfterEachCallback {
    override fun afterEach(context: ExtensionContext) {
        val contextStore = context.sudokuNamespaceStore()
        assertNotNull(contextStore) { "No Sudoku Store Setup" }
    }
}
