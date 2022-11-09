package com.stefanus_ayudha.modsample.pokemon.station

import com.stefanus_ayudha.control.provider.sample.pokemon.PokemonSpaceStation
import com.stefanus_ayudha.control.provider.sample.pokemon.model.PokemonDataMdl
import com.stefanus_ayudha.control.provider.sample.pokemon.payload.GetPokemonByIdPld

class SpaceStation : PokemonSpaceStation {
    override suspend fun getPokemonById(
        payload: GetPokemonByIdPld
    ): PokemonDataMdl {

        val pld = com.stefanus_ayudha.modsample
            .pokemon.data.payload
            .GetPokemonByIdPld(payload.id)

        return com.stefanus_ayudha.modsample
            .pokemon.data
            .getPokemonById(pld)
            .pokemon_v2_pokemon[0]
            .let {
                PokemonDataMdl(
                    id = it.id.toString(),
                    name = it.name
                )
            }
    }
}