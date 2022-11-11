package com.stefanus_ayudha.control.provider.sample.pokemon.payload

import com.stefanus_ayudha.core.common.domain.payload.Payload

/**
 * sort for GetPokemonByIdPld
 */
typealias GPBIPLD = GetPokemonByIdPld

data class GetPokemonByIdPld(
    val id: Int
) : Payload