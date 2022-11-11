package com.stefanus_ayudha.modsample.pokemon.data.payload

import com.stefanus_ayudha.core.common.domain.payload.Payload

/**
 * sort for GetPokemonByIdPld
 */
typealias GPBIPLD = GetPokemonByIdPld

data class GetPokemonByIdPld(
    val id: Int
) : Payload