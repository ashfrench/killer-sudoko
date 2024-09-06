package org.ash.french.killer.sudoko.builders

interface SudokuBuilder<T> {
    fun build(): T
}