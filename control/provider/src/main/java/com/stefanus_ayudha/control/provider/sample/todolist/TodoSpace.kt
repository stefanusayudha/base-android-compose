package com.stefanus_ayudha.control.provider.sample.todolist

import com.google.gson.annotations.SerializedName
import com.stefanus_ayudha.core.common.domain.model.NOTHING
import com.stefanus_ayudha.core.common.util.gson.JsonConvertAble
import com.stefanus_ayudha.core.common.util.navigation.BaseSpace

interface TodoSpace : BaseSpace<TodoSpace.Payload, NOTHING> {
    data class Payload(
        @field:SerializedName("nothing")
        val nothing: NOTHING = NOTHING()
    ) : JsonConvertAble
}