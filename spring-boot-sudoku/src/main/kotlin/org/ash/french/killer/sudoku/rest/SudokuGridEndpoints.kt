package org.ash.french.killer.sudoku.rest

import org.ash.french.killer.sudoko.domain.SudokuGrid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sudoku")
class SudokuGridEndpoints : SudokuEndpointInterface {
    @GetMapping
    override fun getEasySudokuGrid(): SudokuGrid {
        TODO()
    }
}
