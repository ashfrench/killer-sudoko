package org.ash.french.killer.sudoko.junit5.extensions

import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext

class SudokuBeforeAllCallback : BeforeAllCallback {

    private val namespace = SudokuNamespace.namespace

    override fun beforeAll(context: ExtensionContext?) {
        val sudokuStore = context?.getStore(namespace)?: throw RuntimeException("Sudoku Namespace not initialised")
    }
}