package org.ash.french.killer.sudoku.rest

import org.ash.french.killer.sudoku.domain.SudokuGrid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalUuidApi
@RestController
@RequestMapping("/sudoku")
class SudokuGridEndpoints {
    @GetMapping("/{id}")
    fun getSudokuGrid(
        @PathVariable id: Uuid,
    ): SudokuGrid {
        TODO()
    }
}