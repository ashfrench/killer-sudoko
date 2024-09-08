package org.ash.french.killer.sudoku

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SudokuSolverApplication

fun main(args: Array<String>) {
    runApplication<SudokuSolverApplication>(*args)
}
