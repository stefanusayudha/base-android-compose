package com.stefanus_ayudha.modsample.pokemon.station

import com.stefanus_ayudha.control.provider.sample.pokemon.PokemonSpaceStation
import com.stefanus_ayudha.control.provider.sample.pokemon.model.PDMDL
import com.stefanus_ayudha.control.provider.sample.pokemon.payload.GPBIPLD

class SpaceStation : PokemonSpaceStation {
    override suspend fun getPokemonById(
        payload: GPBIPLD
    ): PDMDL {

        val pld = com.stefanus_ayudha.modsample
            .pokemon.data.payload
            .GPBIPLD(payload.id)

        return com.stefanus_ayudha.modsample
            .pokemon.data
            .getPokemonById(pld)
            .pokemon_v2_pokemon[0]
            .let {
                PDMDL(
                    id = it.id.toString(),
                    name = it.name
                )
            }
    }
}