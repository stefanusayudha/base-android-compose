package com.singularity_code.modsample.pokemon.data.payload

import com.singularity_code.core.common.pattern.Payload

/**
 * sort for GetPokemonByIdPld
 */
typealias GPBIPLD = GetPokemonByIdPld

data class GetPokemonByIdPld(
    val id: Int
) : Payload