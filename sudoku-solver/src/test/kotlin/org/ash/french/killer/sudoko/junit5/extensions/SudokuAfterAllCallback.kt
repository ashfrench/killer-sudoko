package org.ash.french.killer.sudoko.junit5.extensions

import org.junit.jupiter.api.extension.AfterAllCallback
import org.junit.jupiter.api.extension.ExtensionContext
import kotlin.test.assertNotNull

object SudokuAfterAllCallback : AfterAllCallback {
    override fun afterAll(context: ExtensionContext) {
        val contextStore = context.sudokuNamespaceStore()
        assertNotNull(contextStore) { "No Sudoku Store Setup" }
    }
}
