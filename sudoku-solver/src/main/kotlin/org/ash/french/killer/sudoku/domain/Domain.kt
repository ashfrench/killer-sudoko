package org.ash.french.killer.sudoku.domain

internal typealias SudokuValidation = Result<Boolean>

internal fun validationFailure(t: Throwable): SudokuValidation = Result.failure(t)

internal fun valid(): SudokuValidation = Result.success(true)
