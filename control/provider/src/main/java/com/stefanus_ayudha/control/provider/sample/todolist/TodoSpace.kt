package com.stefanus_ayudha.control.provider.sample.todolist

import com.google.gson.annotations.SerializedName
import com.stefanus_ayudha.core.common.domain.model.NOTHING
import com.stefanus_ayudha.core.common.domain.payload.Payload
import com.stefanus_ayudha.core.common.util.gson.JsonConvertAble
import com.stefanus_ayudha.core.common.util.navigation.BaseSpace

interface TodoSpace : BaseSpace<TodoSpace.Pld, TodoSpace.Result> {
    data class Pld(
        @field:SerializedName("nothing")
        val nothing: NOTHING = NOTHING()
    ) : JsonConvertAble, Payload

    data class Result(
        val nothing: NOTHING = NOTHING()
    )
}