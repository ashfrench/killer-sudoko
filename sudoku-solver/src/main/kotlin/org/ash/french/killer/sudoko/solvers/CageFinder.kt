package org.ash.french.killer.sudoko.solvers

import org.ash.french.killer.sudoko.domain.Cage
import org.ash.french.killer.sudoko.domain.Cell

interface CageFinder {
    fun getCages(): Set<Cage>

    fun getCage(cell: Cell): Cage

    fun getCage(
        x: UByte,
        y: UByte,
    ) = getCage(Cell(x, y))

    fun getCage(
        x: Int,
        y: Int,
    ) = getCage(Cell(x, y))
}
