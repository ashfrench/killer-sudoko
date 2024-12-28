package org.ash.french.killer.sudoku.domain

import org.ash.french.killer.sudoku.domain.impl.Cell
import org.ash.french.killer.sudoku.domain.impl.CellRemovePotentialValueFromRegionUpdate
import org.ash.french.killer.sudoku.domain.impl.CellRemovePotentialValueUpdate
import org.ash.french.killer.sudoku.domain.impl.CellState
import org.ash.french.killer.sudoku.domain.impl.CellUpdate
import org.ash.french.killer.sudoku.domain.impl.CellUpdateValue
import org.ash.french.killer.sudoku.domain.impl.CellUpdateValueOriginalValue

interface CellValueSetter {
    fun setCellValue(
        x: Int,
        y: Int,
        value: UByte?,
    ) = setCellValue(Cell(x, y), CellState(value))

    fun setCellValue(
        x: UByte,
        y: UByte,
        value: UByte?,
    ): Cell = setCellValue(Cell(x, y), CellState(value))

    fun setCellValue(
        cell: Cell,
        value: CellState,
    ): Cell

    fun lockCellValue(
        cell: Cell,
        value: UByte,
    ): Cell

    fun setCellValues(updates: List<CellUpdate>): List<Cell> =
        updates.map {
            when (it) {
                is CellRemovePotentialValueFromRegionUpdate -> TODO()
                is CellRemovePotentialValueUpdate -> TODO()
                is CellUpdateValueOriginalValue -> setCellValue(it.cell, CellState(it.value, locked = true))
                is CellUpdateValue -> TODO()
            }
        }

    operator fun contains(cell: Cell): Boolean
}
