package org.ash.french.killer.sudoko.validation

import org.ash.french.killer.sudoko.domain.Cage
import org.ash.french.killer.sudoko.domain.SudokuValidation
import org.ash.french.killer.sudoko.domain.valid
import org.ash.french.killer.sudoko.domain.CellSet as CellSet

class CageValidation {

    fun validateCage(cage: Cage): SudokuValidation {

        return valid()
    }


    companion object {
        val cageLookup: Map<Int, Map<Int, CellSet>> = emptyMap()
    }
}

fun defaultCageSizes(): Map<Int, Map<Int, CellSet>>{

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

fun getCageValues(cageSize: Int, cageSum: Int): Set<CellSet> {

    return when (cageSize) {
        1 -> emptySet()
        2 -> emptySet()
        3 -> emptySet()
        4 -> emptySet()
        5 -> emptySet()
        6 -> emptySet()
        7 -> emptySet()
        8 -> emptySet()
        9 -> emptySet()
        else -> throw RuntimeException("Unexpected Cage Size")
    }
}

fun main() {

}