package org.ash.french.killer.sudoku.junit5.extensions

import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext
import kotlin.test.assertNotNull

object SudokuBeforeAllCallback : BeforeAllCallback {
    override fun beforeAll(context: ExtensionContext) {
        val contextStore = context.sudokuNamespaceStore()
        assertNotNull(contextStore) { "No Sudoku Store Setup" }
    }
}
