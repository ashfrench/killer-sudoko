package org.ash.french.killer.sudoko.generators

import org.junit.jupiter.api.extension.ExtensionContext

data object SudokuNamespace {
    val namespace: ExtensionContext.Namespace = ExtensionContext.Namespace.create(SudokuNamespaceStore)
}