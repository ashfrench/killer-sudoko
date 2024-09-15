package org.ash.french.killer.sudoku.rest

import org.ash.french.killer.sudoku.builders.randomDefaultGrid
import org.ash.french.killer.sudoku.domain.SudokuGrid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/sudoku")
class SudokuGridEndpoints {
    @GetMapping
    fun generateSudokuGrid(): SudokuGrid {
        return randomDefaultGrid()
    }

    @GetMapping("/{id}")
    fun getSudokuGrid(
        @PathVariable id: UUID,
    ): SudokuGrid {
        return randomDefaultGrid(id)
    }
}
