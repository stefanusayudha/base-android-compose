package com.singularity_code.modsample.pokemon.data.payload

import com.singularity_code.core.common.data.payload.Payload

/**
 * sort for GetPokemonByIdPld
 */
typealias GPBIPLD = GetPokemonByIdPld

data class GetPokemonByIdPld(
    val id: Int
) : Payload