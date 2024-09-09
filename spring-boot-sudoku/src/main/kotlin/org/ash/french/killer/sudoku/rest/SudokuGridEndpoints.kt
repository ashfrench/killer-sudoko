package org.ash.french.killer.sudoku.rest

import org.ash.french.killer.sudoko.domain.SudokuGrid
import org.ash.french.killer.sudoko.solvers.implementation.CellUpdateType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalUuidApi
@RestController
@RequestMapping("/sudoku")
class SudokuGridEndpoints {

    @GetMapping
    fun getEasySudokuGrid(): SudokuGrid {
        TODO()
    }
}
