package org.ash.french.killer.sudoko.validation

import org.ash.french.killer.sudoko.domain.Cage
import org.ash.french.killer.sudoko.domain.SudokuValidation
import org.ash.french.killer.sudoko.domain.valid
import org.ash.french.killer.sudoko.domain.CellSet

fun validateCage(cage: Cage): SudokuValidation {
    return valid()
}


fun defaultCageSizes(): Map<UByte, Map<UByte, CellSet>>{

    val availableSums = (1..45)
    val availableCageSizes = (1..9)
    val availableCellValues = (9 downTo 1)

    val lookUpMap = availableCageSizes.flatMap { size ->

        availableSums


    //        availableSums
//            .groupBy({key -> key}, { getCageValues(size, it) })
//            .mapValues { it.value.flatten().toSet() }
    }

    return TODO()
}

fun getCageValues(cageSize: Int, cageSum: Int) =
    getCageValues(cageSize.toUByte(), cageSum.toUByte())

fun getCageValues(cageSize: UByte, cageSum: UByte): Result<Set<CellSet>> {

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

fun calculateCellSetCageSizeOne(cageSum: UByte): Result<Set<CellSet>> {
    TODO("Not yet implemented")
}

fun calculateCellSetCageSizeTwo(cageSum: UByte): Result<Set<CellSet>> {
    TODO("Not yet implemented")
}

fun calculateCellSetCageSizeThree(cageSum: UByte): Result<Set<CellSet>> {
    TODO("Not yet implemented")
}

fun calculateCellSetCageSizeFour(cageSum: UByte): Result<Set<CellSet>> {
    TODO("Not yet implemented")
}

fun calculateCellSetCageSizeFive(cageSum: UByte): Result<Set<CellSet>> {
    TODO("Not yet implemented")
}

fun calculateCellSetCageSizeSix(cageSum: UByte): Result<Set<CellSet>> {
    TODO("Not yet implemented")
}

fun calculateCellSetCageSizeSeven(cageSum: UByte): Result<Set<CellSet>> {
    TODO("Not yet implemented")
}

fun calculateCellSetCageSizeEight(cageSum: UByte): Result<Set<CellSet>> {
    TODO("Not yet implemented")
}

fun calculateCellSetCageSizeNine(cageSum: UByte): Result<Set<CellSet>> {
    TODO("Not yet implemented")
}


fun main() {

}