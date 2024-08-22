package org.ash.french.killer.sudoko.domain

data class Cell(val x: Int, val y: Int) {
    init {
        require(x in (1..9)) { "X must be a positive Integer between 1 and 9" }
        require(y in (1..9)) { "Y must be a positive Integer between 1 and 9" }
    }
}

data class Row(val y: Int, val cells: Set<Cell>): CellSet(cells) {

    override fun validate(cells: Set<Cell>): Result<Boolean> {
        return try {
            require(y in (1..9)) { "Y must be a positive Integer between 1 and 9" }
            require(cells.any { it.y == y }) { "All Cells must be in the Row $y" }
            require(cells.distinct().count() == 9) { "All Cells must be in the Row $y" }
            Result.success(true)
        } catch (e: Throwable) {
            valid()
        }
    }
}

data class Column(val x: Int, val cells: Set<Cell>): CellSet(cells) {

    override fun validate(cells: Set<Cell>): Result<Boolean> {
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

data class Nonet(val cells: Set<Cell>): CellSet(cells) {

    override fun validate(cells: Set<Cell>): Result<Boolean> {
        return try {
            require(cells.distinct().count() == 9) { "Nonet must contain 9 cells" }
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

data class Cage(val sum: Int, val cells: Set<Cell>): CellSet(cells) {
    override fun validate(cells: Set<Cell>): Result<Boolean> {
        return try {
            require(cells.count() in 1..9) { "Number of cells in a cage must be between 1 and 9" }
            valid()
        } catch (e : Throwable) {
            validationFailure(e)
        }
        
    }
}

sealed class CellSet(private val cells: Set<Cell>): Set<Cell> by cells {
    open fun validate(cells: Set<Cell>): Result<Boolean> {
        return if (cells == this.cells) {
            valid()
        } else {
            validationFailure(RuntimeException("Unexpected Cells: $cells"))
        }
    }

    //Private Constructor to hide visibility
    constructor(): this(emptySet())

    init {
        this.validate(cells)
    }

}

typealias Validation = Result<Boolean>
fun validationFailure(t: Throwable): Validation = Result.failure(t)
fun valid(): Validation = Result.success(true)