package com.stefanus_ayudha.control.provider.sample.mmdexample

import com.google.gson.annotations.SerializedName
import com.stefanus_ayudha.core.common.domain.model.NOTHING
import com.stefanus_ayudha.core.common.domain.payload.Payload
import com.stefanus_ayudha.core.common.util.gson.JsonConvertAble
import com.stefanus_ayudha.core.common.util.navigation.BaseSpace

interface MMDExampleSpace : BaseSpace<MMDExampleSpace.Pld, MMDExampleSpace.Result> {
    data class Pld(
        @field:SerializedName("nothing")
        val nothing: NOTHING = NOTHING()
    ) : Payload, JsonConvertAble

    data class Result(
        val nothing: NOTHING = NOTHING()
    )
}