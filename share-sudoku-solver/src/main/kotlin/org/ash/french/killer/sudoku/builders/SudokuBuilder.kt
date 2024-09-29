package org.ash.french.killer.sudoku.builders

import kotlinx.serialization.json.Json

fun interface SudokuBuilder<T> {
    fun build(): T
}

val JSON =
    Json {
        allowStructuredMapKeys = true
        prettyPrint = true
    }
