package com.singularity_code.control.provider.sample.pokemon.payload

import com.singularity_code.core.common.data.payload.Payload

/**
 * sort for GetPokemonByIdPld
 */
typealias GPBIPLD = GetPokemonByIdPld

data class GetPokemonByIdPld(
    val id: Int
) : Payload