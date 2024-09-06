package org.ash.french.killer.sudoko.builders

fun interface SudokuBuilder<T> {
    fun build(): T
}
