@file:OptIn(ExperimentalUuidApi::class)

package org.ash.french.killer.sudoku.rest

import org.ash.french.killer.sudoko.domain.SudokuGrid
import org.ash.french.killer.sudoko.solvers.implementation.CellUpdateType
import org.springframework.web.bind.annotation.GetMapping
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

interface SudokuEndpointInterface {
    @GetMapping
    fun getEasySudokuGrid(): SudokuGrid

    @GetMapping
    fun getGridUpdates(sudokuGridId: Uuid): List<CellUpdateType>
}
