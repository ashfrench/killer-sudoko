package org.ash.french.killer.sudoko.domain

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalUuidApi
interface UpdateID {
    val updateID: Uuid
        get() = Uuid.random()
}
