package org.ash.french.killer.sudoko.junit5.extensions

import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext
import kotlin.test.assertNotNull

object SudokuBeforeAllCallback : BeforeAllCallback {

    private val sudokuNamespace = SudokuNamespace

    override fun beforeAll(context: ExtensionContext?) {
        val sudokuStore = context?.getStore(sudokuNamespace.namespace)?: throw RuntimeException("Sudoku Context Store not initialised")
        assertNotNull(sudokuStore)
    }
}