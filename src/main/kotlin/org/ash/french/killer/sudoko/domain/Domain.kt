package org.ash.french.killer.sudoko.domain

data class Cell(val x: UByte, val y: UByte) {
    init {
        require(x in (1..9)) { "X must be a positive Integer between 1 and 9" }
        require(y in (1..9)) { "Y must be a positive Integer between 1 and 9" }
    }
}

data class Row(val y: UByte, override val cells: Set<Cell>): Region(cells) {

    override fun validate(): SudokuValidation {
        return try {

            require(y in (1..9)) { "Y must be a positive Integer between 1 and 9" }
            require(cells.any { it.y == y }) { "All Cells must be in the Row $y" }
            require(cells.distinct().count() == 9) { "All Cells must be in the Row $y" }

            valid()
        } catch (e: Throwable) {
            validationFailure(e)
        }
    }
}

data class Column(val x: UByte, override val cells: Set<Cell>): Region(cells) {

    override fun validate(): Result<Boolean> {
        return try {
            require(x in (1..9)) { "X must be a positive Integer between 1 and 9" }
            require(cells.any { it.x == x }) { "All Cells must be in the Row $x" }
            require(cells.distinct().count() == 9) { "All Cells must be in the Row $x" }

            valid()
        } catch (e: Throwable) {
            validationFailure(e)
        }
    }

}

data class Nonet(override val cells: Set<Cell>): Region(cells) {

    override fun validate(): Result<Boolean> {
        return try {
            val groupByX = cells.groupBy { it.x }
            val groupByY = cells.groupBy { it.y }

            require(groupByX.all { it.value.count() == 3 }) { "All groups of X cells should only have 3" }
            require(groupByY.all { it.value.count() == 3 }) { "All groups of Y cells should only have 3" }

            valid()
        } catch (e: Throwable) {
            validationFailure(e)
        }
    }

}

sealed class Region(open val sum: UByte, open val cells: Set<Cell>): CellSet(cells) {

    constructor(cells: Set<Cell>): this(45, cells)

    override fun validate(): Result<Boolean> {
        return try {

            require(cells.count() in 1..9) { "Number of cells in a cage must be between 1 and 9" }
            valid()
        } catch (e : Throwable) {
            validationFailure(e)
        }
        
    }
}

data class Cage(override val sum: UByte, override val cells: Set<Cell>): Region(sum, cells) {

    init {
        require(sum in 1..45) { "Invalid Sum for Cage of size ${cells.size}" }
    }

    override fun validate(): Result<Boolean> {
        return validate()
    }

}

sealed class CellSet(private val cells: Set<Cell>): Set<Cell> by cells {
    open fun validate(): SudokuValidation {
        return try {
            require(cells.size == 9) { "${this.javaClass.canonicalName} must contain 9 cells" }
            valid()
        } catch (e: Throwable) {
            validationFailure(e)
        }
    }

    //Private Constructor to hide visibility
    constructor(): this(emptySet())

    init {
        this.validate()
    }

}

typealias SudokuValidation = Result<Boolean>
fun validationFailure(t: Throwable): SudokuValidation = Result.failure(t)
fun valid(): SudokuValidation = Result.success(true)