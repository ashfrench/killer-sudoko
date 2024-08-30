package org.ash.french.killer.sudoko.junit5.extensions

import org.junit.jupiter.api.extension.*

interface EmptySudokuExtensionCallback:
    BeforeAllCallback,
    BeforeEachCallback,
    AfterEachCallback,
    AfterAllCallback,
    TestInstancePostProcessor,
    ExecutionCondition