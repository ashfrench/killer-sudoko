package org.ash.french.killer.sudoko.junit5.extensions

import org.junit.jupiter.api.extension.*

class SudokuExtensionCallback :
    BeforeEachCallback by SudokuBeforeEachCallback,
    BeforeAllCallback by SudokuBeforeAllCallback,
    AfterAllCallback by SudokuAfterAllCallback,
    AfterEachCallback by SudokuAfterEachCallback,
    TestInstancePostProcessor by SudokuTestInstancePostProcessor,
    ExecutionCondition by EmptySudokuExecutionCondition