package org.ash.french.killer.sudoku.junit5.extensions

import org.junit.jupiter.api.extension.AfterAllCallback
import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExecutionCondition
import org.junit.jupiter.api.extension.ParameterResolver
import org.junit.jupiter.api.extension.TestInstancePostProcessor
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
object SudokuExtensionCallback :
    EmptySudokuExtensionCallback,
    BeforeEachCallback by SudokuBeforeEachCallback,
    BeforeAllCallback by SudokuBeforeAllCallback,
    AfterAllCallback by SudokuAfterAllCallback,
    AfterEachCallback by SudokuAfterEachCallback,
    TestInstancePostProcessor by SudokuTestInstancePostProcessor,
    ExecutionCondition by EmptySudokuExecutionCondition,
    ParameterResolver by SudokuParameterResolver
