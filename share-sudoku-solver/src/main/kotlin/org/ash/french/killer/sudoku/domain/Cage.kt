package org.ash.french.killer.sudoku.domain

import kotlinx.serialization.Serializable

@Serializable
data class Cage(override val sum: UByte, override val cells: Set<Cell>) : Region {
    private val potentialCageValues: Set<Set<Int>>

    init {
        this.validate().getOrThrow()
        potentialCageValues = generatePotentialCageValues()
    }

    private fun generatePotentialCageValues(): Set<Set<Int>> {
        return when (cells.size) {
            1 -> setOf(setOf(sum.toInt()))
            2 ->
                when (sum.toInt()) {
                    3 -> setOf(setOf(1, 2))
                    4 -> setOf(setOf(1, 3))
                    5 -> setOf(setOf(1, 4), setOf(2, 3))
                    6 -> setOf(setOf(1, 5), setOf(2, 4))
                    7 -> setOf(setOf(1, 6), setOf(2, 5), setOf(3, 4))
                    8 -> setOf(setOf(1, 7), setOf(2, 6), setOf(3, 5))
                    9 -> setOf(setOf(1, 8), setOf(2, 7), setOf(3, 6), setOf(4, 5))
                    10 -> setOf(setOf(1, 9), setOf(2, 8), setOf(3, 7), setOf(4, 6))
                    11 -> setOf(setOf(2, 9), setOf(3, 8), setOf(4, 7), setOf(5, 6))
                    12 -> setOf(setOf(3, 9), setOf(4, 8), setOf(5, 7))
                    13 -> setOf(setOf(4, 9), setOf(5, 8), setOf(6, 7))
                    14 -> setOf(setOf(5, 9), setOf(6, 8))
                    15 -> setOf(setOf(6, 9), setOf(7, 8))
                    16 -> setOf(setOf(7, 9))
                    17 -> setOf(setOf(8, 9))
                    else -> throw RuntimeException("Invalid Sum $sum for size ${cells.size}")
                }

            3 ->
                when (sum.toInt()) {
                    6 -> setOf(setOf(1, 2, 3))
                    7 -> setOf(setOf(1, 2, 4))
                    8 -> setOf(setOf(1, 2, 5), setOf(134))
                    9 -> setOf(setOf(1, 2, 6), setOf(1, 3, 5), setOf(2, 3, 4))
                    10 -> setOf(setOf(1, 2, 7), setOf(1, 3, 6), setOf(1, 4, 5), setOf(2, 3, 5))
                    11 -> setOf(setOf(1, 2, 8), setOf(1, 3, 7), setOf(1, 4, 6), setOf(2, 3, 6), setOf(2, 4, 5))
                    12 ->
                        setOf(
                            setOf(1, 2, 9),
                            setOf(1, 3, 8),
                            setOf(1, 4, 7),
                            setOf(1, 5, 6),
                            setOf(2, 3, 7),
                            setOf(2, 4, 6),
                            setOf(3, 4, 5),
                        )

                    13 ->
                        setOf(
                            setOf(1, 3, 9),
                            setOf(1, 4, 8),
                            setOf(1, 5, 7),
                            setOf(2, 3, 8),
                            setOf(2, 4, 7),
                            setOf(2, 5, 6),
                            setOf(3, 4, 6),
                        )

                    14 ->
                        setOf(
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
                        setOf(
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
                        setOf(
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
                        setOf(
                            setOf(1, 7, 9),
                            setOf(2, 6, 9),
                            setOf(2, 7, 8),
                            setOf(3, 5, 9),
                            setOf(3, 6, 8),
                            setOf(4, 5, 8),
                            setOf(4, 6, 7),
                        )

                    18 ->
                        setOf(
                            setOf(1, 8, 9),
                            setOf(2, 7, 9),
                            setOf(3, 6, 9),
                            setOf(3, 7, 8),
                            setOf(4, 5, 9),
                            setOf(4, 6, 8),
                            setOf(5, 6, 7),
                        )

                    19 -> setOf(setOf(2, 8, 9), setOf(3, 7, 9), setOf(4, 6, 9), setOf(4, 7, 8), setOf(5, 6, 8))
                    20 -> setOf(setOf(3, 8, 9), setOf(4, 7, 9), setOf(5, 6, 9), setOf(5, 7, 8))
                    21 -> setOf(setOf(4, 8, 9), setOf(5, 7, 9), setOf(6, 7, 8))
                    22 -> setOf(setOf(5, 8, 9), setOf(6, 7, 9))
                    23 -> setOf(setOf(6, 8, 9))
                    24 -> setOf(setOf(7, 8, 9))
                    else -> throw RuntimeException("Invalid Sum $sum for size ${cells.size}")
                }

            4 ->
                when (sum.toInt()) {
                    10 -> setOf(setOf(1, 2, 3, 4))
                    11 -> setOf(setOf(1, 2, 3, 5))
                    12 -> setOf(setOf(1, 2, 3, 6), setOf(1, 2, 4, 5))
                    13 -> setOf(setOf(1, 2, 3, 7), setOf(1, 2, 4, 6), setOf(1, 3, 4, 5))
                    14 ->
                        setOf(
                            setOf(1, 2, 3, 8),
                            setOf(1, 2, 4, 7),
                            setOf(1, 2, 5, 6),
                            setOf(1, 3, 4, 6),
                            setOf(2, 3, 4, 5),
                        )

                    15 ->
                        setOf(
                            setOf(1, 2, 3, 9),
                            setOf(1, 2, 4, 8),
                            setOf(1, 2, 5, 7),
                            setOf(1, 3, 4, 7),
                            setOf(1, 3, 5, 6),
                            setOf(2, 3, 4, 6),
                        )

                    16 ->
                        setOf(
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
                        setOf(
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
                        setOf(
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
                        setOf(
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
                        setOf(
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
                        setOf(
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
                        setOf(
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
                        setOf(
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
                        setOf(
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
                        setOf(
                            setOf(1, 7, 8, 9),
                            setOf(2, 6, 8, 9),
                            setOf(3, 5, 8, 9),
                            setOf(3, 6, 7, 9),
                            setOf(4, 5, 7, 9),
                            setOf(4, 6, 7, 8),
                        )

                    26 ->
                        setOf(
                            setOf(2, 7, 8, 9),
                            setOf(3, 6, 8, 9),
                            setOf(4, 5, 8, 9),
                            setOf(4, 6, 7, 9),
                            setOf(5, 6, 7, 8),
                        )

                    27 -> setOf(setOf(3, 7, 8, 9), setOf(4, 6, 8, 9), setOf(5, 6, 7, 9))
                    28 -> setOf(setOf(4, 7, 8, 9), setOf(5, 6, 8, 9))
                    29 -> setOf(setOf(5, 7, 8, 9))
                    30 -> setOf(setOf(6, 7, 8, 9))
                    else -> throw RuntimeException("Invalid Sum $sum for size ${cells.size}")
                }

            5 ->
                when (sum.toInt()) {
                    15 -> setOf(setOf(1, 2, 3, 4, 5))
                    16 -> setOf(setOf(1, 2, 3, 4, 6))
                    17 -> setOf(setOf(1, 2, 3, 4, 7), setOf(1, 2, 3, 5, 6))
                    18 -> setOf(setOf(1, 2, 3, 4, 8), setOf(1, 2, 3, 5, 7), setOf(1, 2, 4, 5, 6))
                    19 ->
                        setOf(
                            setOf(1, 2, 3, 4, 9),
                            setOf(1, 2, 3, 5, 8),
                            setOf(1, 2, 3, 6, 7),
                            setOf(1, 2, 4, 5, 7),
                            setOf(1, 3, 4, 5, 6),
                        )

                    20 ->
                        setOf(
                            setOf(1, 2, 3, 5, 9),
                            setOf(1, 2, 3, 6, 8),
                            setOf(1, 2, 4, 5, 8),
                            setOf(1, 2, 4, 6, 7),
                            setOf(1, 3, 4, 5, 7),
                            setOf(2, 3, 4, 5, 6),
                        )

                    21 ->
                        setOf(
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
                        setOf(
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
                        setOf(
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
                        setOf(
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
                        setOf(
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
                        setOf(
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
                        setOf(
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
                        setOf(
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
                        setOf(
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
                        setOf(
                            setOf(1, 5, 7, 8, 9),
                            setOf(2, 4, 7, 8, 9),
                            setOf(2, 5, 6, 8, 9),
                            setOf(3, 4, 6, 8, 9),
                            setOf(3, 5, 6, 7, 9),
                            setOf(4, 5, 6, 7, 8),
                        )

                    31 ->
                        setOf(
                            setOf(1, 6, 7, 8, 9),
                            setOf(2, 5, 7, 8, 9),
                            setOf(3, 4, 7, 8, 9),
                            setOf(3, 5, 6, 8, 9),
                            setOf(4, 5, 6, 7, 9),
                        )

                    32 -> setOf(setOf(2, 6, 7, 8, 9), setOf(3, 5, 7, 8, 9), setOf(4, 5, 6, 8, 9))
                    33 -> setOf(setOf(3, 6, 7, 8, 9), setOf(4, 5, 7, 8, 9))
                    34 -> setOf(setOf(4, 6, 7, 8, 9))
                    35 -> setOf(setOf(5, 6, 7, 8, 9))
                    else -> throw RuntimeException("Invalid Sum $sum for size ${cells.size}")
                }

            6 ->
                when (sum.toInt()) {
                    21 -> setOf(setOf(1, 2, 3, 4, 5, 6))
                    22 -> setOf(setOf(1, 2, 3, 4, 5, 7))
                    23 -> setOf(setOf(1, 2, 3, 4, 5, 8), setOf(1, 2, 3, 4, 6, 7))
                    24 -> setOf(setOf(1, 2, 3, 4, 5, 9), setOf(1, 2, 3, 4, 6, 8), setOf(1, 2, 3, 5, 6, 7))
                    25 ->
                        setOf(
                            setOf(1, 2, 3, 4, 6, 9),
                            setOf(1, 2, 3, 4, 7, 8),
                            setOf(1, 2, 3, 5, 6, 8),
                            setOf(1, 2, 4, 5, 6, 7),
                        )

                    26 ->
                        setOf(
                            setOf(1, 2, 3, 4, 7, 9),
                            setOf(1, 2, 3, 5, 6, 9),
                            setOf(1, 2, 3, 5, 7, 8),
                            setOf(1, 2, 4, 5, 6, 8),
                            setOf(1, 3, 4, 5, 6, 7),
                        )

                    27 ->
                        setOf(
                            setOf(1, 2, 3, 4, 8, 9),
                            setOf(1, 2, 3, 5, 7, 9),
                            setOf(1, 2, 3, 6, 7, 8),
                            setOf(1, 2, 4, 5, 6, 9),
                            setOf(1, 2, 4, 5, 7, 8),
                            setOf(1, 3, 4, 5, 6, 8),
                            setOf(2, 3, 4, 5, 6, 7),
                        )

                    28 ->
                        setOf(
                            setOf(1, 2, 3, 5, 8, 9),
                            setOf(1, 2, 3, 6, 7, 9),
                            setOf(1, 2, 4, 5, 7, 9),
                            setOf(1, 2, 4, 6, 7, 8),
                            setOf(1, 3, 4, 5, 6, 9),
                            setOf(1, 3, 4, 5, 7, 8),
                            setOf(2, 3, 4, 5, 6, 8),
                        )

                    29 ->
                        setOf(
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
                        setOf(
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
                        setOf(
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
                        setOf(
                            setOf(1, 2, 5, 7, 8, 9),
                            setOf(1, 3, 4, 7, 8, 9),
                            setOf(1, 3, 5, 6, 8, 9),
                            setOf(1, 4, 5, 6, 7, 9),
                            setOf(2, 3, 4, 6, 8, 9),
                            setOf(2, 3, 5, 6, 7, 9),
                            setOf(2, 4, 5, 6, 7, 8),
                        )

                    33 ->
                        setOf(
                            setOf(1, 2, 6, 7, 8, 9),
                            setOf(1, 3, 5, 7, 8, 9),
                            setOf(1, 4, 5, 6, 8, 9),
                            setOf(2, 3, 4, 7, 8, 9),
                            setOf(2, 3, 5, 6, 8, 9),
                            setOf(2, 4, 5, 6, 7, 9),
                            setOf(3, 4, 5, 6, 7, 8),
                        )

                    34 ->
                        setOf(
                            setOf(1, 3, 6, 7, 8, 9),
                            setOf(1, 4, 5, 7, 8, 9),
                            setOf(2, 3, 5, 7, 8, 9),
                            setOf(2, 4, 5, 6, 8, 9),
                            setOf(3, 4, 5, 6, 7, 9),
                        )

                    35 ->
                        setOf(
                            setOf(1, 4, 6, 7, 8, 9),
                            setOf(2, 3, 6, 7, 8, 9),
                            setOf(2, 4, 5, 7, 8, 9),
                            setOf(3, 4, 5, 6, 8, 9),
                        )

                    36 -> setOf(setOf(1, 5, 6, 7, 8, 9), setOf(2, 4, 6, 7, 8, 9), setOf(3, 4, 5, 7, 8, 9))
                    37 -> setOf(setOf(2, 5, 6, 7, 8, 9), setOf(3, 4, 6, 7, 8, 9))
                    38 -> setOf(setOf(3, 5, 6, 7, 8, 9))
                    39 -> setOf(setOf(4, 5, 6, 7, 8, 9))
                    else -> throw RuntimeException("Invalid Sum $sum for size ${cells.size}")
                }

            7 ->
                when (sum.toInt()) {
                    28 -> setOf(setOf(1, 2, 3, 4, 5, 6, 7))
                    29 -> setOf(setOf(1, 2, 3, 4, 5, 6, 8))
                    30 -> setOf(setOf(1, 2, 3, 4, 5, 6, 9), setOf(1, 2, 3, 4, 5, 7, 8))
                    31 -> setOf(setOf(1, 2, 3, 4, 5, 7, 9), setOf(1, 2, 3, 4, 6, 7, 8))
                    32 -> setOf(setOf(1, 2, 3, 4, 5, 8, 9), setOf(1, 2, 3, 4, 6, 7, 9), setOf(1, 2, 3, 5, 6, 7, 8))
                    33 -> setOf(setOf(1, 2, 3, 4, 6, 8, 9), setOf(1, 2, 3, 5, 6, 7, 9), setOf(1, 2, 4, 5, 6, 7, 8))
                    34 ->
                        setOf(
                            setOf(1, 2, 3, 4, 7, 8, 9),
                            setOf(1, 2, 3, 5, 6, 8, 9),
                            setOf(1, 2, 4, 5, 6, 7, 9),
                            setOf(1, 3, 4, 5, 6, 7, 8),
                        )

                    35 ->
                        setOf(
                            setOf(1, 2, 3, 5, 7, 8, 9),
                            setOf(1, 2, 4, 5, 6, 8, 9),
                            setOf(1, 3, 4, 5, 6, 7, 9),
                            setOf(2, 3, 4, 5, 6, 7, 8),
                        )

                    36 ->
                        setOf(
                            setOf(1, 2, 3, 6, 7, 8, 9),
                            setOf(1, 2, 4, 5, 7, 8, 9),
                            setOf(1, 3, 4, 5, 6, 8, 9),
                            setOf(2, 3, 4, 5, 6, 7, 9),
                        )

                    37 -> setOf(setOf(1, 2, 4, 6, 7, 8, 9), setOf(1, 3, 4, 5, 7, 8, 9), setOf(2, 3, 4, 5, 6, 8, 9))
                    38 -> setOf(setOf(1, 2, 5, 6, 7, 8, 9), setOf(1, 3, 4, 6, 7, 8, 9), setOf(2, 3, 4, 5, 7, 8, 9))
                    39 -> setOf(setOf(1, 3, 5, 6, 7, 8, 9), setOf(2, 3, 4, 6, 7, 8, 9))
                    40 -> setOf(setOf(1, 4, 5, 6, 7, 8, 9), setOf(2, 3, 5, 6, 7, 8, 9))
                    41 -> setOf(setOf(2, 4, 5, 6, 7, 8, 9))
                    42 -> setOf(setOf(3, 4, 5, 6, 7, 8, 9))
                    else -> throw RuntimeException("Invalid Sum $sum for size ${cells.size}")
                }

            8 ->
                when (sum.toInt()) {
                    36 -> setOf(setOf(1, 2, 3, 4, 5, 6, 7, 8))
                    37 -> setOf(setOf(1, 2, 3, 4, 5, 6, 7, 9))
                    38 -> setOf(setOf(1, 2, 3, 4, 5, 6, 8, 9))
                    39 -> setOf(setOf(1, 2, 3, 4, 5, 7, 8, 9))
                    40 -> setOf(setOf(1, 2, 3, 4, 6, 7, 8, 9))
                    41 -> setOf(setOf(1, 2, 3, 5, 6, 7, 8, 9))
                    42 -> setOf(setOf(1, 2, 4, 5, 6, 7, 8, 9))
                    43 -> setOf(setOf(1, 3, 4, 5, 6, 7, 8, 9))
                    44 -> setOf(setOf(2, 3, 4, 5, 6, 7, 8, 9))
                    else -> throw RuntimeException("Invalid Sum $sum for size ${cells.size}")
                }

            9 ->
                when (sum.toInt()) {
                    45 -> setOf(setOf(1, 2, 3, 4, 5, 6, 7, 8, 9))
                    else -> throw RuntimeException("Invalid Sum $sum for size ${cells.size}")
                }

            else -> throw RuntimeException("Invalid size ${cells.size}")
        }
    }

    private fun validateCells(cells: Set<Cell>) {
        if (cells.size == 1) {
            return
        }

        val cellStats =
            cells.fold(CellStatistics()) { cellStatics, cell ->
                cellStatics
                    .copy(
                        minX = if (cellStatics.minX > cell.x.toInt()) cell.x.toInt() else cellStatics.minX,
                        maxX = if (cellStatics.maxX < cell.x.toInt()) cell.x.toInt() else cellStatics.maxX,
                        minY = if (cellStatics.minY > cell.y.toInt()) cell.y.toInt() else cellStatics.minY,
                        maxY = if (cellStatics.maxY < cell.y.toInt()) cell.y.toInt() else cellStatics.maxY,
                        sum = cellStatics.sum + cell.x.toInt(),
                        count = cellStatics.count.inc(),
                    )
            }

        require(cells.size in cellStats.getXRange())
        require(cells.size in cellStats.getYRange())
    }

    private fun validateCageSum(
        sum: UByte,
        cells: Set<Cell>,
    ) {
        val intSum = sum.toInt()
        val valid = cells.size.isValidCageSum(intSum)
        require(valid) { "Invalid cage sum $sum for size ${cells.size}" }
    }

    private fun Int.isValidCageSum(sum: Int): Boolean {
        return when (this) {
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
    }

    override fun validate(): Result<Boolean> {
        return try {
            require(sum in 1u..45u) { "Invalid Sum for Cage of size ${cells.size}" }
            require(cells.size in 1..9) { "A cage must contain between 1 and 9 cells" }
            validateCageSum(sum, cells)
            validateCells(cells)

            valid()
        } catch (e: Throwable) {
            validationFailure(e)
        }
    }

    data class CellStatistics(
        val minX: Int = Int.MAX_VALUE,
        val maxX: Int = Int.MIN_VALUE,
        val minY: Int = Int.MAX_VALUE,
        val maxY: Int = Int.MIN_VALUE,
        val sum: Long = 0,
        val count: Long = 0,
    ) {
        fun getXRange(): IntRange = minX..maxX

        fun getYRange(): IntRange = minY..maxY
    }
}
