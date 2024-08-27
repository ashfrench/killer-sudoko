package org.ash.french.killer.sudoko.domain


typealias SudokuValidation = Result<Boolean>
fun validationFailure(t: Throwable): SudokuValidation = Result.failure(t)
fun valid(): SudokuValidation = Result.success(true)