package org.ash.french.killer.sudoku.domain

object SudokuFinder : RowFinder, ColumnFinder, NonetFinder {
    private val rows = cells.groupBy { it.y }.mapValues { Row(it.key, it.value.toSet()) }

    private val columns = cells.groupBy { it.x }.mapValues { Column(it.key, it.value.toSet()) }

    override fun getRow(cell: Cell) = rows[cell.y] ?: throw RuntimeException("Unexpected Cell: $cell - No row found")

    override fun getColumn(cell: Cell) = columns[cell.x] ?: throw RuntimeException("Unexpected Cell: $cell - No Column found")

    override fun getNonet(cell: Cell) = nonets.find { cell in it } ?: throw RuntimeException("No Nonet for Cell $cell")

    override fun getNonet(nonetPosition: Int): Nonet {
        require(nonetPosition in 1..9)

        return nonets[nonetPosition]
    }
}
