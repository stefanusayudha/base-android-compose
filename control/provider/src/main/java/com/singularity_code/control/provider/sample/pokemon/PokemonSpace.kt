package com.singularity_code.control.provider.sample.pokemon

import com.google.gson.annotations.SerializedName
import com.singularity_code.core.common.pattern.JsonConvertAble
import com.singularity_code.core.common.pattern.NOTHING
import com.singularity_code.core.common.pattern.Payload
import com.singularity_code.core.common.pattern.navigation.Space

interface PokemonSpace : Space<PokemonSpace.Pld, PokemonSpace.Result> {
    data class Pld(
        @field:SerializedName("nothing")
        val nothing: NOTHING = NOTHING()
    ) : Payload, JsonConvertAble

    data class Result(
        val nothing: NOTHING = NOTHING()
    )
}