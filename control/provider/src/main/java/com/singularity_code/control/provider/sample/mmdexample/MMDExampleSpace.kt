package com.singularity_code.control.provider.sample.mmdexample

import com.google.gson.annotations.SerializedName
import com.singularity_code.core.common.pattern.JsonConvertible
import com.singularity_code.core.common.model.NOTHING
import com.singularity_code.core.common.pattern.Payload
import com.singularity_code.core.common.pattern.navigation.Space

interface MMDExampleSpace : Space<MMDExampleSpace.Pld, MMDExampleSpace.Result> {
    data class Pld(
        @field:SerializedName("nothing")
        val nothing: NOTHING = NOTHING()
    ) : Payload, JsonConvertible

    data class Result(
        val nothing: NOTHING = NOTHING()
    )
}