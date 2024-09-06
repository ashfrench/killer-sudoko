package org.ash.french.killer.sudoko.domain

import java.util.UUID

interface UpdateID {
    val updateID: UUID
        get() = UUID.randomUUID()
}
