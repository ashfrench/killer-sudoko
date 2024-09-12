package org.ash.french.killer.sudoku.junit5.extensions

import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import kotlin.test.assertNotNull

object SudokuAfterEachCallback : AfterEachCallback {
    override fun afterEach(context: ExtensionContext) {
        val contextStore = context.sudokuNamespaceStore()
        assertNotNull(contextStore) { "No Sudoku Store Setup" }
    }
}
