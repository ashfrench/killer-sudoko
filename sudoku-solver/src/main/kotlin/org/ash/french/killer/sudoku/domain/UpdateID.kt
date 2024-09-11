package org.ash.french.killer.sudoku.domain

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalUuidApi
internal interface UpdateID {
    val updateID: Uuid
        get() = Uuid.random()
}
