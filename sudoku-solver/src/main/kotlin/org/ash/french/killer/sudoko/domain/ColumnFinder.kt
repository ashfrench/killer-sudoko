package org.ash.french.killer.sudoko.domain

interface ColumnFinder {
    fun getColumn(cell: Cell): Column

    @Suppress("unused")
    fun getColumn(x: UByte) = getColumn(Cell(x, 1u))

    @Suppress("unused")
    fun getColumn(x: Int) = getColumn(Cell(x, 1))
}
