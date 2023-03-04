package com.singularity_code.control.provider.sample.todolist

import com.google.gson.annotations.SerializedName
import com.singularity_code.core.common.pattern.JsonConvertible
import com.singularity_code.core.common.model.NOTHING
import com.singularity_code.core.common.pattern.Payload
import com.singularity_code.core.common.pattern.navigation.Space

interface TodoSpace : Space<TodoSpace.Pld, TodoSpace.Result> {
    data class Pld(
        @field:SerializedName("nothing")
        val nothing: NOTHING = NOTHING()
    ) : JsonConvertible, Payload

    data class Result(
        val nothing: NOTHING = NOTHING()
    )
}