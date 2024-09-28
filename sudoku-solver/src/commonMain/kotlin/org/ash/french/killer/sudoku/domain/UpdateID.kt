package org.ash.french.killer.sudoku.domain

import java.util.UUID

interface UpdateID {
    val updateID: UUID
        get() = UUID.randomUUID()
}
