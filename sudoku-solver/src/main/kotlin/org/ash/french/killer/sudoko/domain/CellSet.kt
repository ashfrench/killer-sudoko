package org.ash.french.killer.sudoko.domain

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
    private constructor(): this(emptySet())

    init {
        this.validate()
    }
    override fun contains(element: Cell) = cells.contains(element)
}

sealed class Region(open val sum: UByte, open val cells: Set<Cell>): CellSet(cells) {

    constructor(cells: Set<Cell>): this(45u, cells)

    override fun validate(): Result<Boolean> {
        return try {
            require(cells.count() in 1..9) { "Number of cells in a cage must be between 1 and 9" }
            valid()
        } catch (e : Throwable) {
            validationFailure(e)
        }

    }
}