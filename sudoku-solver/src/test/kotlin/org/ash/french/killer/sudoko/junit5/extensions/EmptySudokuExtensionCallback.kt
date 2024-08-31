package org.ash.french.killer.sudoko.junit5.extensions

import org.junit.jupiter.api.extension.AfterAllCallback
import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExecutionCondition
import org.junit.jupiter.api.extension.TestInstancePostProcessor

interface EmptySudokuExtensionCallback :
    BeforeAllCallback,
    BeforeEachCallback,
    AfterEachCallback,
    AfterAllCallback,
    TestInstancePostProcessor,
    ExecutionCondition
