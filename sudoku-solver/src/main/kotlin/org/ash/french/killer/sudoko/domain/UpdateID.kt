package org.ash.french.killer.sudoko.domain

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

interface UpdateID {
    @OptIn(ExperimentalUuidApi::class)
    val updateID: Uuid
        get() = Uuid.random()
}
