package com.stefanus_ayudha.modsample.pokemon.data.payload

import com.stefanus_ayudha.core.common.domain.payload.Payload

/**
 * sort for GetPokemonListPld
 */
typealias GPLPLD = GetPokemonListPld

data class GetPokemonListPld(
    val limit: Int = 10,
    val offset: Int = 0
) : Payload