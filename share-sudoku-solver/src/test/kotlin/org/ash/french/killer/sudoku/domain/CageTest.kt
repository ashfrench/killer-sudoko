package org.ash.french.killer.sudoku.domain

import org.ash.french.killer.sudoku.domain.impl.Cage
import org.ash.french.killer.sudoku.domain.impl.Cell
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.assertDoesNotThrow
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class CageTest {
    @TestFactory
    fun `test valid cage values`(): List<DynamicTest> {
        val expectedRanges =
            mapOf(
                1 to 1..9,
                2 to 3..17,
                3 to 6..24,
                4 to 10..30,
                5 to 15..35,
                6 to 21..39,
                7 to 28..42,
                8 to 36..44,
                9 to 45..45,
            )

        return expectedRanges.entries.flatMap { (cageSize, cageSumRange) ->
            val yRange = 1..cageSize
            val cells = yRange.map { Cell(1, it) }
            cageSumRange.map { sum ->
                dynamicTest("Test Cage Valid Cage Values for Sum: $sum and Size: $cageSize") {
                    val cage = assertDoesNotThrow { Cage(sum, cells) }
                    val potentialCageValues = cage.potentialCageValues

                    assertTrue(potentialCageValues.isNotEmpty())
                    potentialCageValues.forEach { potentialValues ->
                        val potentialValueSum = potentialValues.sum()
                        assertEquals(sum, potentialValueSum)
                        assertEquals(cageSize, potentialValues.size)
                    }
                }
            }
        }
    }
}
