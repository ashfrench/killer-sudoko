package org.ash.french.killer.sudoku.domain.impl

import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.Test
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
            cageSumRange.map { sum ->
                dynamicTest("Test Cage Valid Cage Values for Sum: $sum and Size: $cageSize") {
                    val cells = yRange.map { Cell(1, it) }
                    val cage = assertDoesNotThrow { Cage(sum, cells) }
                    val potentialCageValues = cage.getPotentialCageValues()

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

    @Test
    fun `test more stuff`() {
        val cells = listOf(Cell(1, 1))
        Cage(2, cells)
    }

    @Test
    fun `test remove cage values`() {
        val yRange = 1..2
        val cells = yRange.map { Cell(1, it) }
        val cage = Cage(10, cells)

        println(cage.getPotentialCageValues())
        cells.forEach { println(it.getPotentialCellValues()) }

        cage.notContainValue(2)

        println(cage.getPotentialCageValues())
        cells.forEach { println(it.getPotentialCellValues()) }
    }

    @Test
    fun `test contain cage values`() {
        val yRange = 1..3
        val cells = yRange.map { Cell(1, it) }
        val cage = Cage(14, cells)

        println(cage.getPotentialCageValues())
        cells.forEach { println(it.getPotentialCellValues()) }

        cage.mustContainValue(2)

        println(cage.getPotentialCageValues())
        cells.forEach { println(it.getPotentialCellValues()) }

        cage.mustContainValue(4)

        println(cage.getPotentialCageValues())
        cells.forEach { println(it.getPotentialCellValues()) }
    }

    @Test
    fun `test cells not contain values`() {
        val yRange = 1..3
        val cells = yRange.map { Cell(1, it) }
        val cage = Cage(14, cells)

        println(cage.getPotentialCageValues())
        cells.forEach { println(it.getPotentialCellValues()) }

        cells.forEach { it.removePotentialValue(1) }
        cage.potentialCageValuesFromCellPotentials()

        println(cage.getPotentialCageValues())
        cells.forEach { println(it.getPotentialCellValues()) }

        cells.forEach { it.removePotentialValue(2) }
        cage.potentialCageValuesFromCellPotentials()

        println(cage.getPotentialCageValues())
        cells.forEach { println(it.getPotentialCellValues()) }
    }

    @Test
    fun `test stuff`() {
        val yRange = 1..2
        val cells = yRange.map { Cell(1, it) }
        val cage = Cage(3, cells)

        println(cage.getPotentialCageValues())
        cells.forEach { println(it.getPotentialCellValues()) }
    }
}
