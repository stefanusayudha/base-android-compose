package com.singularity_code.modsample.pokemon.data.payload

import com.singularity_code.core.common.pattern.Payload

/**
 * sort for GetPokemonListPld
 */
typealias GPLPLD = GetPokemonListPld

data class GetPokemonListPld(
    val limit: Int = 10,
    val offset: Int = 0
) : Payload