package org.ash.french.killer.sudoko.junit5.extensions

import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.TestInstanceFactory
import org.junit.jupiter.api.extension.TestInstanceFactoryContext

object SudokuTestInstanceFactory : TestInstanceFactory {
    override fun createTestInstance(
        factoryContext: TestInstanceFactoryContext,
        extensionContext: ExtensionContext,
    ): Any {
        factoryContext.testClass
        TODO("Not yet implemented")
    }
}
