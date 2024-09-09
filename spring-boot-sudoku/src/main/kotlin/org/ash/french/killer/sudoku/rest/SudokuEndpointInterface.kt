package org.ash.french.killer.sudoku.rest

import org.ash.french.killer.sudoko.domain.SudokuGrid
import org.springframework.web.bind.annotation.GetMapping

interface SudokuEndpointInterface {
    @GetMapping
    fun getEasySudokuGrid(): SudokuGrid
}
