package org.ash.french.killer.sudoku.domain.impl

import kotlinx.serialization.Serializable

@Serializable
data class Cage(
    override val sum: UByte,
    override val cells: Set<Cell>,
) : Region {
    constructor(sum: Int, cells: Collection<Cell>) : this(sum.toUByte(), cells.toSet())

    private val potentialCageValues: MutableSet<Set<Int>>

    fun getPotentialCageValues() = potentialCageValues.toSet()

    init {
        this.validate().getOrThrow()
        potentialCageValues = generatePotentialCageValues()
        updateCellValues()
    }

    fun mustContainValue(value: Int) {
        potentialCageValues.removeIf { value !in it }
        updateCellValues()
    }

    fun notContainValue(value: Int) {
        potentialCageValues.removeIf { value in it }
        updateCellValues()
    }

    fun potentialCageValuesFromCellPotentials() {
        val unusedVals = (1..9).filter { value -> cells.none { cell -> value in cell.getPotentialCellValues() } }
        unusedVals.forEach { notContainValue(it) }
    }

    private fun updateCellValues() {
        val unusedVals = (1..9).filter { potentialValue -> potentialCageValues.none { potentialValue in it } }
        unusedVals.forEach { unusedValue -> cells.forEach { cell -> cell.removePotentialValue(unusedValue) } }
    }

    private fun generatePotentialCageValues(): MutableSet<Set<Int>> =
        when (cells.size) {
            1 -> mutableSetOf(setOf(sum.toInt()))
            2 ->
                when (sum.toInt()) {
                    3 -> mutableSetOf(setOf(1, 2))
                    4 -> mutableSetOf(setOf(1, 3))
                    5 -> mutableSetOf(setOf(1, 4), setOf(2, 3))
                    6 -> mutableSetOf(setOf(1, 5), setOf(2, 4))
                    7 -> mutableSetOf(setOf(1, 6), setOf(2, 5), setOf(3, 4))
                    8 -> mutableSetOf(setOf(1, 7), setOf(2, 6), setOf(3, 5))
                    9 -> mutableSetOf(setOf(1, 8), setOf(2, 7), setOf(3, 6), setOf(4, 5))
                    10 -> mutableSetOf(setOf(1, 9), setOf(2, 8), setOf(3, 7), setOf(4, 6))
                    11 -> mutableSetOf(setOf(2, 9), setOf(3, 8), setOf(4, 7), setOf(5, 6))
                    12 -> mutableSetOf(setOf(3, 9), setOf(4, 8), setOf(5, 7))
                    13 -> mutableSetOf(setOf(4, 9), setOf(5, 8), setOf(6, 7))
                    14 -> mutableSetOf(setOf(5, 9), setOf(6, 8))
                    15 -> mutableSetOf(setOf(6, 9), setOf(7, 8))
                    16 -> mutableSetOf(setOf(7, 9))
                    17 -> mutableSetOf(setOf(8, 9))
                    else -> throw RuntimeException("Invalid Sum $sum for size ${cells.size}")
                }

            3 ->
                when (sum.toInt()) {
                    6 -> mutableSetOf(setOf(1, 2, 3))
                    7 -> mutableSetOf(setOf(1, 2, 4))
                    8 -> mutableSetOf(setOf(1, 2, 5), setOf(1, 3, 4))
                    9 -> mutableSetOf(setOf(1, 2, 6), setOf(1, 3, 5), setOf(2, 3, 4))
                    10 -> mutableSetOf(setOf(1, 2, 7), setOf(1, 3, 6), setOf(1, 4, 5), setOf(2, 3, 5))
                    11 -> mutableSetOf(setOf(1, 2, 8), setOf(1, 3, 7), setOf(1, 4, 6), setOf(2, 3, 6), setOf(2, 4, 5))
                    12 ->
                        mutableSetOf(
                            setOf(1, 2, 9),
                            setOf(1, 3, 8),
                            setOf(1, 4, 7),
                            setOf(1, 5, 6),
                            setOf(2, 3, 7),
                            setOf(2, 4, 6),
                            setOf(3, 4, 5),
                        )

                    13 ->
                        mutableSetOf(
                            setOf(1, 3, 9),
                            setOf(1, 4, 8),
                            setOf(1, 5, 7),
                            setOf(2, 3, 8),
                            setOf(2, 4, 7),
                            setOf(2, 5, 6),
                            setOf(3, 4, 6),
                        )

                    14 ->
                        mutableSetOf(
                            setOf(1, 4, 9),
                            setOf(1, 5, 8),
                            setOf(1, 6, 7),
                            setOf(2, 3, 9),
                            setOf(2, 4, 8),
                            setOf(2, 5, 7),
                            setOf(3, 4, 7),
                            setOf(3, 5, 6),
                        )

                    15 ->
                        mutableSetOf(
                            setOf(1, 5, 9),
                            setOf(1, 6, 8),
                            setOf(2, 4, 9),
                            setOf(2, 5, 8),
                            setOf(2, 6, 7),
                            setOf(3, 4, 8),
                            setOf(3, 5, 7),
                            setOf(4, 5, 6),
                        )

                    16 ->
                        mutableSetOf(
                            setOf(1, 6, 9),
                            setOf(1, 7, 8),
                            setOf(2, 5, 9),
                            setOf(2, 6, 8),
                            setOf(3, 4, 9),
                            setOf(3, 5, 8),
                            setOf(3, 6, 7),
                            setOf(4, 5, 7),
                        )

                    17 ->
                        mutableSetOf(
                            setOf(1, 7, 9),
                            setOf(2, 6, 9),
                            setOf(2, 7, 8),
                            setOf(3, 5, 9),
                            setOf(3, 6, 8),
                            setOf(4, 5, 8),
                            setOf(4, 6, 7),
                        )

                    18 ->
                        mutableSetOf(
                            setOf(1, 8, 9),
                            setOf(2, 7, 9),
                            setOf(3, 6, 9),
                            setOf(3, 7, 8),
                            setOf(4, 5, 9),
                            setOf(4, 6, 8),
                            setOf(5, 6, 7),
                        )

                    19 -> mutableSetOf(setOf(2, 8, 9), setOf(3, 7, 9), setOf(4, 6, 9), setOf(4, 7, 8), setOf(5, 6, 8))
                    20 -> mutableSetOf(setOf(3, 8, 9), setOf(4, 7, 9), setOf(5, 6, 9), setOf(5, 7, 8))
                    21 -> mutableSetOf(setOf(4, 8, 9), setOf(5, 7, 9), setOf(6, 7, 8))
                    22 -> mutableSetOf(setOf(5, 8, 9), setOf(6, 7, 9))
                    23 -> mutableSetOf(setOf(6, 8, 9))
                    24 -> mutableSetOf(setOf(7, 8, 9))
                    else -> throw RuntimeException("Invalid Sum $sum for size ${cells.size}")
                }

            4 ->
                when (sum.toInt()) {
                    10 -> mutableSetOf(setOf(1, 2, 3, 4))
                    11 -> mutableSetOf(setOf(1, 2, 3, 5))
                    12 -> mutableSetOf(setOf(1, 2, 3, 6), setOf(1, 2, 4, 5))
                    13 -> mutableSetOf(setOf(1, 2, 3, 7), setOf(1, 2, 4, 6), setOf(1, 3, 4, 5))
                    14 ->
                        mutableSetOf(
                            setOf(1, 2, 3, 8),
                            setOf(1, 2, 4, 7),
                            setOf(1, 2, 5, 6),
                            setOf(1, 3, 4, 6),
                            setOf(2, 3, 4, 5),
                        )

                    15 ->
                        mutableSetOf(
                            setOf(1, 2, 3, 9),
                            setOf(1, 2, 4, 8),
                            setOf(1, 2, 5, 7),
                            setOf(1, 3, 4, 7),
                            setOf(1, 3, 5, 6),
                            setOf(2, 3, 4, 6),
                        )

                    16 ->
                        mutableSetOf(
                            setOf(1, 2, 4, 9),
                            setOf(1, 2, 5, 8),
                            setOf(1, 2, 6, 7),
                            setOf(1, 3, 4, 8),
                            setOf(1, 3, 5, 7),
                            setOf(1, 4, 5, 6),
                            setOf(2, 3, 4, 7),
                            setOf(2, 3, 5, 6),
                        )

                    17 ->
                        mutableSetOf(
                            setOf(1, 2, 5, 9),
                            setOf(1, 2, 6, 8),
                            setOf(1, 3, 4, 9),
                            setOf(1, 3, 5, 8),
                            setOf(1, 3, 6, 7),
                            setOf(1, 4, 5, 7),
                            setOf(2, 3, 4, 8),
                            setOf(2, 3, 5, 7),
                            setOf(2, 4, 5, 6),
                        )

                    18 ->
                        mutableSetOf(
                            setOf(1, 2, 6, 9),
                            setOf(1, 2, 7, 8),
                            setOf(1, 3, 5, 9),
                            setOf(1, 3, 6, 8),
                            setOf(1, 4, 5, 8),
                            setOf(1, 4, 6, 7),
                            setOf(2, 3, 4, 9),
                            setOf(2, 3, 5, 8),
                            setOf(2, 3, 6, 7),
                            setOf(2, 4, 5, 7),
                            setOf(3, 4, 5, 6),
                        )

                    19 ->
                        mutableSetOf(
                            setOf(1, 2, 7, 9),
                            setOf(1, 3, 6, 9),
                            setOf(1, 3, 7, 8),
                            setOf(1, 4, 5, 9),
                            setOf(1, 4, 6, 8),
                            setOf(1, 5, 6, 7),
                            setOf(2, 3, 5, 9),
                            setOf(2, 3, 6, 8),
                            setOf(2, 4, 5, 8),
                            setOf(2, 4, 6, 7),
                            setOf(3, 4, 5, 7),
                        )

                    20 ->
                        mutableSetOf(
                            setOf(1, 2, 8, 9),
                            setOf(1, 3, 7, 9),
                            setOf(1, 4, 6, 9),
                            setOf(1, 4, 7, 8),
                            setOf(1, 5, 6, 8),
                            setOf(2, 3, 6, 9),
                            setOf(2, 3, 7, 8),
                            setOf(2, 4, 5, 9),
                            setOf(2, 4, 6, 8),
                            setOf(2, 5, 6, 7),
                            setOf(3, 4, 5, 8),
                            setOf(3, 4, 6, 7),
                        )

                    21 ->
                        mutableSetOf(
                            setOf(1, 3, 8, 9),
                            setOf(1, 4, 7, 9),
                            setOf(1, 5, 6, 9),
                            setOf(1, 5, 7, 8),
                            setOf(2, 3, 7, 9),
                            setOf(2, 4, 6, 9),
                            setOf(2, 4, 7, 8),
                            setOf(2, 5, 6, 8),
                            setOf(3, 4, 5, 9),
                            setOf(3, 4, 6, 8),
                            setOf(3, 5, 6, 7),
                        )

                    22 ->
                        mutableSetOf(
                            setOf(1, 4, 8, 9),
                            setOf(1, 5, 7, 9),
                            setOf(1, 6, 7, 8),
                            setOf(2, 3, 8, 9),
                            setOf(2, 4, 7, 9),
                            setOf(2, 5, 6, 9),
                            setOf(2, 5, 7, 8),
                            setOf(3, 4, 6, 9),
                            setOf(3, 4, 7, 8),
                            setOf(3, 5, 6, 8),
                            setOf(4, 5, 6, 7),
                        )

                    23 ->
                        mutableSetOf(
                            setOf(1, 5, 8, 9),
                            setOf(1, 6, 7, 9),
                            setOf(2, 4, 8, 9),
                            setOf(2, 5, 7, 9),
                            setOf(2, 6, 7, 8),
                            setOf(3, 4, 7, 9),
                            setOf(3, 5, 6, 9),
                            setOf(3, 5, 7, 8),
                            setOf(4, 5, 6, 8),
                        )

                    24 ->
                        mutableSetOf(
                            setOf(1, 6, 8, 9),
                            setOf(2, 5, 8, 9),
                            setOf(2, 6, 7, 9),
                            setOf(3, 4, 8, 9),
                            setOf(3, 5, 7, 9),
                            setOf(3, 6, 7, 8),
                            setOf(4, 5, 6, 9),
                            setOf(4, 5, 7, 8),
                        )

                    25 ->
                        mutableSetOf(
                            setOf(1, 7, 8, 9),
                            setOf(2, 6, 8, 9),
                            setOf(3, 5, 8, 9),
                            setOf(3, 6, 7, 9),
                            setOf(4, 5, 7, 9),
                            setOf(4, 6, 7, 8),
                        )

                    26 ->
                        mutableSetOf(
                            setOf(2, 7, 8, 9),
                            setOf(3, 6, 8, 9),
                            setOf(4, 5, 8, 9),
                            setOf(4, 6, 7, 9),
                            setOf(5, 6, 7, 8),
                        )

                    27 -> mutableSetOf(setOf(3, 7, 8, 9), setOf(4, 6, 8, 9), setOf(5, 6, 7, 9))
                    28 -> mutableSetOf(setOf(4, 7, 8, 9), setOf(5, 6, 8, 9))
                    29 -> mutableSetOf(setOf(5, 7, 8, 9))
                    30 -> mutableSetOf(setOf(6, 7, 8, 9))
                    else -> throw RuntimeException("Invalid Sum $sum for size ${cells.size}")
                }

            5 ->
                when (sum.toInt()) {
                    15 -> mutableSetOf(setOf(1, 2, 3, 4, 5))
                    16 -> mutableSetOf(setOf(1, 2, 3, 4, 6))
                    17 -> mutableSetOf(setOf(1, 2, 3, 4, 7), setOf(1, 2, 3, 5, 6))
                    18 -> mutableSetOf(setOf(1, 2, 3, 4, 8), setOf(1, 2, 3, 5, 7), setOf(1, 2, 4, 5, 6))
                    19 ->
                        mutableSetOf(
                            setOf(1, 2, 3, 4, 9),
                            setOf(1, 2, 3, 5, 8),
                            setOf(1, 2, 3, 6, 7),
                            setOf(1, 2, 4, 5, 7),
                            setOf(1, 3, 4, 5, 6),
                        )

                    20 ->
                        mutableSetOf(
                            setOf(1, 2, 3, 5, 9),
                            setOf(1, 2, 3, 6, 8),
                            setOf(1, 2, 4, 5, 8),
                            setOf(1, 2, 4, 6, 7),
                            setOf(1, 3, 4, 5, 7),
                            setOf(2, 3, 4, 5, 6),
                        )

                    21 ->
                        mutableSetOf(
                            setOf(1, 2, 3, 6, 9),
                            setOf(1, 2, 3, 7, 8),
                            setOf(1, 2, 4, 5, 9),
                            setOf(1, 2, 4, 6, 8),
                            setOf(1, 2, 5, 6, 7),
                            setOf(1, 3, 4, 5, 8),
                            setOf(1, 3, 4, 6, 7),
                            setOf(2, 3, 4, 5, 7),
                        )

                    22 ->
                        mutableSetOf(
                            setOf(1, 2, 3, 7, 9),
                            setOf(1, 2, 4, 6, 9),
                            setOf(1, 2, 4, 7, 8),
                            setOf(1, 2, 5, 6, 8),
                            setOf(1, 3, 4, 5, 9),
                            setOf(1, 3, 4, 6, 8),
                            setOf(1, 3, 5, 6, 7),
                            setOf(2, 3, 4, 5, 8),
                            setOf(2, 3, 4, 6, 7),
                        )

                    23 ->
                        mutableSetOf(
                            setOf(1, 2, 3, 8, 9),
                            setOf(1, 2, 4, 7, 9),
                            setOf(1, 2, 5, 6, 9),
                            setOf(1, 2, 5, 7, 8),
                            setOf(1, 3, 4, 6, 9),
                            setOf(1, 3, 4, 7, 8),
                            setOf(1, 3, 5, 6, 8),
                            setOf(1, 4, 5, 6, 7),
                            setOf(2, 3, 4, 5, 9),
                            setOf(2, 3, 4, 6, 8),
                            setOf(2, 3, 5, 6, 7),
                        )

                    24 ->
                        mutableSetOf(
                            setOf(1, 2, 4, 8, 9),
                            setOf(1, 2, 5, 7, 9),
                            setOf(1, 2, 6, 7, 8),
                            setOf(1, 3, 4, 7, 9),
                            setOf(1, 3, 5, 6, 9),
                            setOf(1, 3, 5, 7, 8),
                            setOf(1, 4, 5, 6, 8),
                            setOf(2, 3, 4, 6, 9),
                            setOf(2, 3, 4, 7, 8),
                            setOf(2, 3, 5, 6, 8),
                            setOf(2, 4, 5, 6, 7),
                        )

                    25 ->
                        mutableSetOf(
                            setOf(1, 2, 5, 8, 9),
                            setOf(1, 2, 6, 7, 9),
                            setOf(1, 3, 4, 8, 9),
                            setOf(1, 3, 5, 7, 9),
                            setOf(1, 3, 6, 7, 8),
                            setOf(1, 4, 5, 6, 9),
                            setOf(1, 4, 5, 7, 8),
                            setOf(2, 3, 4, 7, 9),
                            setOf(2, 3, 5, 6, 9),
                            setOf(2, 3, 5, 7, 8),
                            setOf(2, 4, 5, 6, 8),
                            setOf(3, 4, 5, 6, 7),
                        )

                    26 ->
                        mutableSetOf(
                            setOf(1, 2, 6, 8, 9),
                            setOf(1, 3, 5, 8, 9),
                            setOf(1, 3, 6, 7, 9),
                            setOf(1, 4, 5, 7, 9),
                            setOf(1, 4, 6, 7, 8),
                            setOf(2, 3, 4, 8, 9),
                            setOf(2, 3, 5, 7, 9),
                            setOf(2, 3, 6, 7, 8),
                            setOf(2, 4, 5, 6, 9),
                            setOf(2, 4, 5, 7, 8),
                            setOf(3, 4, 5, 6, 8),
                        )

                    27 ->
                        mutableSetOf(
                            setOf(1, 2, 7, 8, 9),
                            setOf(1, 3, 6, 8, 9),
                            setOf(1, 4, 5, 8, 9),
                            setOf(1, 4, 6, 7, 9),
                            setOf(1, 5, 6, 7, 8),
                            setOf(2, 3, 5, 8, 9),
                            setOf(2, 3, 6, 7, 9),
                            setOf(2, 4, 5, 7, 9),
                            setOf(2, 4, 6, 7, 8),
                            setOf(3, 4, 5, 6, 9),
                            setOf(3, 4, 5, 7, 8),
                        )

                    28 ->
                        mutableSetOf(
                            setOf(1, 3, 7, 8, 9),
                            setOf(1, 4, 6, 8, 9),
                            setOf(1, 5, 6, 7, 9),
                            setOf(2, 3, 6, 8, 9),
                            setOf(2, 4, 5, 8, 9),
                            setOf(2, 4, 6, 7, 9),
                            setOf(2, 5, 6, 7, 8),
                            setOf(3, 4, 5, 7, 9),
                            setOf(3, 4, 6, 7, 8),
                        )

                    29 ->
                        mutableSetOf(
                            setOf(1, 4, 7, 8, 9),
                            setOf(1, 5, 6, 8, 9),
                            setOf(2, 3, 7, 8, 9),
                            setOf(2, 4, 6, 8, 9),
                            setOf(2, 5, 6, 7, 9),
                            setOf(3, 4, 5, 8, 9),
                            setOf(3, 4, 6, 7, 9),
                            setOf(3, 5, 6, 7, 8),
                        )

                    30 ->
                        mutableSetOf(
                            setOf(1, 5, 7, 8, 9),
                            setOf(2, 4, 7, 8, 9),
                            setOf(2, 5, 6, 8, 9),
                            setOf(3, 4, 6, 8, 9),
                            setOf(3, 5, 6, 7, 9),
                            setOf(4, 5, 6, 7, 8),
                        )

                    31 ->
                        mutableSetOf(
                            setOf(1, 6, 7, 8, 9),
                            setOf(2, 5, 7, 8, 9),
                            setOf(3, 4, 7, 8, 9),
                            setOf(3, 5, 6, 8, 9),
                            setOf(4, 5, 6, 7, 9),
                        )

                    32 -> mutableSetOf(setOf(2, 6, 7, 8, 9), setOf(3, 5, 7, 8, 9), setOf(4, 5, 6, 8, 9))
                    33 -> mutableSetOf(setOf(3, 6, 7, 8, 9), setOf(4, 5, 7, 8, 9))
                    34 -> mutableSetOf(setOf(4, 6, 7, 8, 9))
                    35 -> mutableSetOf(setOf(5, 6, 7, 8, 9))
                    else -> throw RuntimeException("Invalid Sum $sum for size ${cells.size}")
                }

            6 ->
                when (sum.toInt()) {
                    21 -> mutableSetOf(setOf(1, 2, 3, 4, 5, 6))
                    22 -> mutableSetOf(setOf(1, 2, 3, 4, 5, 7))
                    23 -> mutableSetOf(setOf(1, 2, 3, 4, 5, 8), setOf(1, 2, 3, 4, 6, 7))
                    24 -> mutableSetOf(setOf(1, 2, 3, 4, 5, 9), setOf(1, 2, 3, 4, 6, 8), setOf(1, 2, 3, 5, 6, 7))
                    25 ->
                        mutableSetOf(
                            setOf(1, 2, 3, 4, 6, 9),
                            setOf(1, 2, 3, 4, 7, 8),
                            setOf(1, 2, 3, 5, 6, 8),
                            setOf(1, 2, 4, 5, 6, 7),
                        )

                    26 ->
                        mutableSetOf(
                            setOf(1, 2, 3, 4, 7, 9),
                            setOf(1, 2, 3, 5, 6, 9),
                            setOf(1, 2, 3, 5, 7, 8),
                            setOf(1, 2, 4, 5, 6, 8),
                            setOf(1, 3, 4, 5, 6, 7),
                        )

                    27 ->
                        mutableSetOf(
                            setOf(1, 2, 3, 4, 8, 9),
                            setOf(1, 2, 3, 5, 7, 9),
                            setOf(1, 2, 3, 6, 7, 8),
                            setOf(1, 2, 4, 5, 6, 9),
                            setOf(1, 2, 4, 5, 7, 8),
                            setOf(1, 3, 4, 5, 6, 8),
                            setOf(2, 3, 4, 5, 6, 7),
                        )

                    28 ->
                        mutableSetOf(
                            setOf(1, 2, 3, 5, 8, 9),
                            setOf(1, 2, 3, 6, 7, 9),
                            setOf(1, 2, 4, 5, 7, 9),
                            setOf(1, 2, 4, 6, 7, 8),
                            setOf(1, 3, 4, 5, 6, 9),
                            setOf(1, 3, 4, 5, 7, 8),
                            setOf(2, 3, 4, 5, 6, 8),
                        )

                    29 ->
                        mutableSetOf(
                            setOf(1, 2, 3, 6, 8, 9),
                            setOf(1, 2, 4, 5, 8, 9),
                            setOf(1, 2, 4, 6, 7, 9),
                            setOf(1, 2, 5, 6, 7, 8),
                            setOf(1, 3, 4, 5, 7, 9),
                            setOf(1, 3, 4, 6, 7, 8),
                            setOf(2, 3, 4, 5, 6, 9),
                            setOf(2, 3, 4, 5, 7, 8),
                        )

                    30 ->
                        mutableSetOf(
                            setOf(1, 2, 3, 7, 8, 9),
                            setOf(1, 2, 4, 6, 8, 9),
                            setOf(1, 2, 5, 6, 7, 9),
                            setOf(1, 3, 4, 5, 8, 9),
                            setOf(1, 3, 4, 6, 7, 9),
                            setOf(1, 3, 5, 6, 7, 8),
                            setOf(2, 3, 4, 5, 7, 9),
                            setOf(2, 3, 4, 6, 7, 8),
                        )

                    31 ->
                        mutableSetOf(
                            setOf(1, 2, 4, 7, 8, 9),
                            setOf(1, 2, 5, 6, 8, 9),
                            setOf(1, 3, 4, 6, 8, 9),
                            setOf(1, 3, 5, 6, 7, 9),
                            setOf(1, 4, 5, 6, 7, 8),
                            setOf(2, 3, 4, 5, 8, 9),
                            setOf(2, 3, 4, 6, 7, 9),
                            setOf(2, 3, 5, 6, 7, 8),
                        )

                    32 ->
                        mutableSetOf(
                            setOf(1, 2, 5, 7, 8, 9),
                            setOf(1, 3, 4, 7, 8, 9),
                            setOf(1, 3, 5, 6, 8, 9),
                            setOf(1, 4, 5, 6, 7, 9),
                            setOf(2, 3, 4, 6, 8, 9),
                            setOf(2, 3, 5, 6, 7, 9),
                            setOf(2, 4, 5, 6, 7, 8),
                        )

                    33 ->
                        mutableSetOf(
                            setOf(1, 2, 6, 7, 8, 9),
                            setOf(1, 3, 5, 7, 8, 9),
                            setOf(1, 4, 5, 6, 8, 9),
                            setOf(2, 3, 4, 7, 8, 9),
                            setOf(2, 3, 5, 6, 8, 9),
                            setOf(2, 4, 5, 6, 7, 9),
                            setOf(3, 4, 5, 6, 7, 8),
                        )

                    34 ->
                        mutableSetOf(
                            setOf(1, 3, 6, 7, 8, 9),
                            setOf(1, 4, 5, 7, 8, 9),
                            setOf(2, 3, 5, 7, 8, 9),
                            setOf(2, 4, 5, 6, 8, 9),
                            setOf(3, 4, 5, 6, 7, 9),
                        )

                    35 ->
                        mutableSetOf(
                            setOf(1, 4, 6, 7, 8, 9),
                            setOf(2, 3, 6, 7, 8, 9),
                            setOf(2, 4, 5, 7, 8, 9),
                            setOf(3, 4, 5, 6, 8, 9),
                        )

                    36 -> mutableSetOf(setOf(1, 5, 6, 7, 8, 9), setOf(2, 4, 6, 7, 8, 9), setOf(3, 4, 5, 7, 8, 9))
                    37 -> mutableSetOf(setOf(2, 5, 6, 7, 8, 9), setOf(3, 4, 6, 7, 8, 9))
                    38 -> mutableSetOf(setOf(3, 5, 6, 7, 8, 9))
                    39 -> mutableSetOf(setOf(4, 5, 6, 7, 8, 9))
                    else -> throw RuntimeException("Invalid Sum $sum for size ${cells.size}")
                }

            7 ->
                when (sum.toInt()) {
                    28 -> mutableSetOf(setOf(1, 2, 3, 4, 5, 6, 7))
                    29 -> mutableSetOf(setOf(1, 2, 3, 4, 5, 6, 8))
                    30 -> mutableSetOf(setOf(1, 2, 3, 4, 5, 6, 9), setOf(1, 2, 3, 4, 5, 7, 8))
                    31 -> mutableSetOf(setOf(1, 2, 3, 4, 5, 7, 9), setOf(1, 2, 3, 4, 6, 7, 8))
                    32 -> mutableSetOf(setOf(1, 2, 3, 4, 5, 8, 9), setOf(1, 2, 3, 4, 6, 7, 9), setOf(1, 2, 3, 5, 6, 7, 8))
                    33 -> mutableSetOf(setOf(1, 2, 3, 4, 6, 8, 9), setOf(1, 2, 3, 5, 6, 7, 9), setOf(1, 2, 4, 5, 6, 7, 8))
                    34 ->
                        mutableSetOf(
                            setOf(1, 2, 3, 4, 7, 8, 9),
                            setOf(1, 2, 3, 5, 6, 8, 9),
                            setOf(1, 2, 4, 5, 6, 7, 9),
                            setOf(1, 3, 4, 5, 6, 7, 8),
                        )

                    35 ->
                        mutableSetOf(
                            setOf(1, 2, 3, 5, 7, 8, 9),
                            setOf(1, 2, 4, 5, 6, 8, 9),
                            setOf(1, 3, 4, 5, 6, 7, 9),
                            setOf(2, 3, 4, 5, 6, 7, 8),
                        )

                    36 ->
                        mutableSetOf(
                            setOf(1, 2, 3, 6, 7, 8, 9),
                            setOf(1, 2, 4, 5, 7, 8, 9),
                            setOf(1, 3, 4, 5, 6, 8, 9),
                            setOf(2, 3, 4, 5, 6, 7, 9),
                        )

                    37 -> mutableSetOf(setOf(1, 2, 4, 6, 7, 8, 9), setOf(1, 3, 4, 5, 7, 8, 9), setOf(2, 3, 4, 5, 6, 8, 9))
                    38 -> mutableSetOf(setOf(1, 2, 5, 6, 7, 8, 9), setOf(1, 3, 4, 6, 7, 8, 9), setOf(2, 3, 4, 5, 7, 8, 9))
                    39 -> mutableSetOf(setOf(1, 3, 5, 6, 7, 8, 9), setOf(2, 3, 4, 6, 7, 8, 9))
                    40 -> mutableSetOf(setOf(1, 4, 5, 6, 7, 8, 9), setOf(2, 3, 5, 6, 7, 8, 9))
                    41 -> mutableSetOf(setOf(2, 4, 5, 6, 7, 8, 9))
                    42 -> mutableSetOf(setOf(3, 4, 5, 6, 7, 8, 9))
                    else -> throw RuntimeException("Invalid Sum $sum for size ${cells.size}")
                }

            8 ->
                when (sum.toInt()) {
                    36 -> mutableSetOf(setOf(1, 2, 3, 4, 5, 6, 7, 8))
                    37 -> mutableSetOf(setOf(1, 2, 3, 4, 5, 6, 7, 9))
                    38 -> mutableSetOf(setOf(1, 2, 3, 4, 5, 6, 8, 9))
                    39 -> mutableSetOf(setOf(1, 2, 3, 4, 5, 7, 8, 9))
                    40 -> mutableSetOf(setOf(1, 2, 3, 4, 6, 7, 8, 9))
                    41 -> mutableSetOf(setOf(1, 2, 3, 5, 6, 7, 8, 9))
                    42 -> mutableSetOf(setOf(1, 2, 4, 5, 6, 7, 8, 9))
                    43 -> mutableSetOf(setOf(1, 3, 4, 5, 6, 7, 8, 9))
                    44 -> mutableSetOf(setOf(2, 3, 4, 5, 6, 7, 8, 9))
                    else -> throw RuntimeException("Invalid Sum $sum for size ${cells.size}")
                }

            9 ->
                when (sum.toInt()) {
                    45 -> mutableSetOf(setOf(1, 2, 3, 4, 5, 6, 7, 8, 9))
                    else -> throw RuntimeException("Invalid Sum $sum for size ${cells.size}")
                }

            else -> throw RuntimeException("Invalid size ${cells.size}")
        }

    private fun validateCells(cells: Set<Cell>) {
        require(cells.size in 1..9) {
            "Invalid cells count must be between 1 and 9"
        }

        // TODO check cells next to each other
    }

    private fun validateCageSum(
        sum: UByte,
        cells: Set<Cell>,
    ) {
        val intSum = sum.toInt()
        val valid = cells.size.isValidCageSum(intSum)
        require(valid) { "Invalid cage sum $sum for size ${cells.size} - $cells" }
    }

    private fun Int.isValidCageSum(sum: Int): Boolean =
        when (this) {
            1 -> sum in 1..9
            2 -> sum in 2..17
            3 -> sum in 6..24
            4 -> sum in 10..30
            5 -> sum in 15..35
            6 -> sum in 21..39
            7 -> sum in 28..42
            8 -> sum in 36..44
            9 -> sum in 45..45
            else -> false
        }

    override fun validate(): Result<Boolean> =
        try {
            require(sum in 1u..45u) { "Invalid Sum for Cage of size ${cells.size}" }
            require(cells.size in 1..9) { "A cage must contain between 1 and 9 cells" }
            validateCageSum(sum, cells)
            validateCells(cells)

            valid()
        } catch (e: Throwable) {
            validationFailure(e)
        }
}
