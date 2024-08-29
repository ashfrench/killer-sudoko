package org.ash.french.killer.sudoko.junit5.extensions

import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import kotlin.test.assertNotNull

object SudokuBeforeEachCallback : BeforeEachCallback {

    private val namespace = SudokuNamespace.namespace
    override fun beforeEach(context: ExtensionContext?) {
        val sudokuStore = context?.getStore(namespace)?: throw RuntimeException("Sudoku Context Store not initialised")
        assertNotNull(sudokuStore)
    }
}