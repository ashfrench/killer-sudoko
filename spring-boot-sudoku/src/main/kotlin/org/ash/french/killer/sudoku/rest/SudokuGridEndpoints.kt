package org.ash.french.killer.sudoku.rest

import org.ash.french.killer.sudoku.dto.SudokuGridDto
import org.ash.french.killer.sudoku.dto.randomDefaultDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/sudoku")
class SudokuGridEndpoints {
    @GetMapping
    fun generateSudokuGrid(): SudokuGridDto {
        return randomDefaultDto()
    }

    @GetMapping("/{id}")
    fun getSudokuGrid(
        @PathVariable id: UUID,
    ): SudokuGridDto {
        return randomDefaultDto(id)
    }
}
