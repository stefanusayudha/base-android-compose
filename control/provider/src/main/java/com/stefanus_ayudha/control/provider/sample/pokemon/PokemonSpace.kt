package com.stefanus_ayudha.control.provider.sample.pokemon

import com.google.gson.annotations.SerializedName
import com.stefanus_ayudha.core.common.domain.model.NOTHING
import com.stefanus_ayudha.core.common.util.gson.JsonConvertAble
import com.stefanus_ayudha.core.common.util.navigation.BaseSpace

interface PokemonSpace : BaseSpace<PokemonSpace.Payload, NOTHING> {
    data class Payload(
        @field:SerializedName("nothing")
        val nothing: NOTHING = NOTHING()
    ) : JsonConvertAble
}