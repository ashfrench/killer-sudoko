package org.ash.french.killer.sudoku.domain

import kotlinx.serialization.Serializable

@Serializable
sealed interface KillerSudokuUpdate : UpdateID

@Serializable
data class KillerSudokuCellUpdate(
    val cell: Cell,
    val value: UByte,
) : KillerSudokuUpdate

@Serializable
data class RemovePotentialCellValue(
    val cell: Cell,
    val value: UByte,
) : KillerSudokuUpdate

@Serializable
data class RemovePotentialCageValues(
    val cage: Cage,
    val value: List<UByte>,
) : KillerSudokuUpdate
