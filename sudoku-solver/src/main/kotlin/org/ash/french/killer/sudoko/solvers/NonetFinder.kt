package org.ash.french.killer.sudoko.solvers

import org.ash.french.killer.sudoko.domain.Cell
import org.ash.french.killer.sudoko.domain.Nonet
import org.ash.french.killer.sudoko.domain.Row

interface NonetFinder {
    fun getNonet(cell: Cell): Nonet
    fun getNonet(nonetPosition: Int): Nonet
}