package com.stefanus_ayudha.control.provider.sample.pokemon

import com.stefanus_ayudha.control.provider.sample.pokemon.model.PokemonDataMdl
import com.stefanus_ayudha.control.provider.sample.pokemon.payload.GetPokemonByIdPld
import com.stefanus_ayudha.core.common.util.navigation.BaseSpaceStation

interface PokemonSpaceStation : BaseSpaceStation {
    suspend fun getPokemonById(
        payload: GetPokemonByIdPld
    ): PokemonDataMdl
}