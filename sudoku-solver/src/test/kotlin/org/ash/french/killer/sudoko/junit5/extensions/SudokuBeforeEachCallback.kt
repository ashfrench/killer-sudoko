package org.ash.french.killer.sudoko.junit5.extensions

import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import kotlin.test.assertNotNull

object SudokuBeforeEachCallback : BeforeEachCallback {
    override fun beforeEach(context: ExtensionContext) {
        val contextStore = context.sudokuNamespaceStore()
        assertNotNull(contextStore) { "No Sudoku Store Setup" }
    }
}
