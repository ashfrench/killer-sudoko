package org.ash.french.killer.sudoko.junit5.extensions

import org.junit.jupiter.api.extension.ConditionEvaluationResult
import org.junit.jupiter.api.extension.ExecutionCondition
import org.junit.jupiter.api.extension.ExtensionContext
import kotlin.test.assertNotNull

object EmptySudokuExecutionCondition : ExecutionCondition {
    override fun evaluateExecutionCondition(context: ExtensionContext): ConditionEvaluationResult {
        val store = context.sudokuNamespaceStore()
        assertNotNull(store)
        return ConditionEvaluationResult.enabled("Sudoku Store is configured correctly")
    }
}
