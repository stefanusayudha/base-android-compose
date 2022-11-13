package com.singularity_code.control.provider.sample.mmdexample

import com.google.gson.annotations.SerializedName
import com.singularity_code.core.common.data.model.NOTHING
import com.singularity_code.core.common.data.payload.Payload
import com.singularity_code.core.common.util.gson.JsonConvertAble
import com.singularity_code.core.common.util.navigation.BaseSpace

interface MMDExampleSpace : BaseSpace<MMDExampleSpace.Pld, MMDExampleSpace.Result> {
    data class Pld(
        @field:SerializedName("nothing")
        val nothing: NOTHING = NOTHING()
    ) : Payload, JsonConvertAble

    data class Result(
        val nothing: NOTHING = NOTHING()
    )
}