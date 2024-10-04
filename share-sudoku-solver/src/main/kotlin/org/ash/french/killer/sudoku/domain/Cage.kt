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
        when (cells.size) {
            1 -> setOf(setOf(sum.toInt()))
            2 -> TODO()
            3 -> TODO()
            4 -> TODO()
            5 -> TODO()
            6 -> TODO()
            7 -> TODO()
            8 -> TODO()
            9 -> TODO()
        }
        TODO("Not yet implemented")
    }

    private fun validateCells(cells: Set<Cell>) {
        if (cells.size == 1) {
            return
        }

        val cellRows = cells.associateBy { it.x.toInt() }
        val cellCols = cells.associateBy { it.y.toInt() }

        val rowKeys = cellRows.keys.sorted()
        val colKeys = cellCols.keys.sorted()

        val rowSummaryStatistics = rowKeys.stream().mapToInt { it }.summaryStatistics()
        val colSummaryStatistics = colKeys.stream().mapToInt { it }.summaryStatistics()

        val rowRange = rowSummaryStatistics.min..rowSummaryStatistics.min
        val colRange = colSummaryStatistics.min..colSummaryStatistics.min

        cells.fold(CellStatistics()) { cellStatics, cell ->
            cellStatics.copy(
                min = if (cellStatics.min > cell.x.toInt()) cell.x.toInt() else cellStatics.min,
                max = if (cellStatics.max < cell.x.toInt()) cell.x.toInt() else cellStatics.max,
                sum = cellStatics.sum + cell.x.toInt(),
                count = cellStatics.count.inc(),
            )
        }

        require(rowRange.count() <= cells.size)
        require(colRange.count() <= cells.size)
        require(rowRange.count() + colRange.count() <= cells.size)
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
}

data class CellStatistics(
    val min: Int = Int.MAX_VALUE,
    val max: Int = Int.MIN_VALUE,
    val sum: Long = 0,
    val count: Long = 0,
) {
    fun getRange(): IntRange = min..max
}
