package com.singularity_code.control.provider.sample.pokemon.payload

import com.singularity_code.core.common.pattern.Payload

data class GetPokemonByIdSPLD(
    val id: Int
) : Payload