package org.ash.french.killer.sudoku.validation

import org.ash.french.killer.sudoku.domain.Cage
import org.ash.french.killer.sudoku.domain.CellSet
import org.ash.french.killer.sudoku.domain.SudokuValidation
import org.ash.french.killer.sudoku.domain.valid

internal fun validateCage(cage: Cage): SudokuValidation {
    return valid()
}

internal fun defaultCageSizes(): Map<UByte, Map<UByte, CellSet>> {
    val availableSums = (1..45)
    val availableCageSizes = (1..9)
    val availableCellValues = (9 downTo 1)

    val lookUpMap =
        availableCageSizes.flatMap { _ ->
            availableSums
        }

    return emptyMap()
}

internal fun getCageValues(
    cageSize: Int,
    cageSum: Int,
) = getCageValues(
    cageSize.toUByte(),
    cageSum.toUByte(),
)

internal fun getCageValues(
    cageSize: UByte,
    cageSum: UByte,
): Result<Set<CellSet>> {
    return when (cageSize.toInt()) {
        1 -> calculateCellSetCageSizeOne(cageSum)
        2 -> calculateCellSetCageSizeTwo(cageSum)
        3 -> calculateCellSetCageSizeThree(cageSum)
        4 -> calculateCellSetCageSizeFour(cageSum)
        5 -> calculateCellSetCageSizeFive(cageSum)
        6 -> calculateCellSetCageSizeSix(cageSum)
        7 -> calculateCellSetCageSizeSeven(cageSum)
        8 -> calculateCellSetCageSizeEight(cageSum)
        9 -> calculateCellSetCageSizeNine(cageSum)
        else -> throw RuntimeException("Unexpected Cage Size")
    }
}

internal fun calculateCellSetCageSizeOne(cageSum: UByte): Result<Set<CellSet>> {
    TODO("Not yet implemented")
}

internal fun calculateCellSetCageSizeTwo(cageSum: UByte): Result<Set<CellSet>> {
    TODO("Not yet implemented")
}

internal fun calculateCellSetCageSizeThree(cageSum: UByte): Result<Set<CellSet>> {
    TODO("Not yet implemented")
}

internal fun calculateCellSetCageSizeFour(cageSum: UByte): Result<Set<CellSet>> {
    TODO("Not yet implemented")
}

internal fun calculateCellSetCageSizeFive(cageSum: UByte): Result<Set<CellSet>> {
    TODO("Not yet implemented")
}

internal fun calculateCellSetCageSizeSix(cageSum: UByte): Result<Set<CellSet>> {
    TODO("Not yet implemented")
}

internal fun calculateCellSetCageSizeSeven(cageSum: UByte): Result<Set<CellSet>> {
    TODO("Not yet implemented")
}

internal fun calculateCellSetCageSizeEight(cageSum: UByte): Result<Set<CellSet>> {
    TODO("Not yet implemented")
}

internal fun calculateCellSetCageSizeNine(cageSum: UByte): Result<Set<CellSet>> {
    TODO("Not yet implemented")
}
