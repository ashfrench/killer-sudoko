package org.ash.french.killer.sudoku.domain

import java.util.UUID

internal interface UpdateID {
    val updateID: UUID
        get() = UUID.randomUUID()
}
