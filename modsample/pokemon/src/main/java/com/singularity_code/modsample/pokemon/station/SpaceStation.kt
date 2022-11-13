package com.singularity_code.modsample.pokemon.station

import com.singularity_code.control.provider.sample.pokemon.PokemonSpaceStation
import com.singularity_code.control.provider.sample.pokemon.model.PDMDL
import com.singularity_code.control.provider.sample.pokemon.payload.GPBIPLD

class SpaceStation : PokemonSpaceStation {
    override suspend fun getPokemonById(
        payload: GPBIPLD
    ): PDMDL {

        val pld = com.singularity_code
            .modsample
            .pokemon
            .data
            .payload
            .GPBIPLD(payload.id)

        return com.singularity_code.modsample.pokemon.data.getPokemonById(pld)
            .pokemon_v2_pokemon[0]
            .let {
                PDMDL(
                    id = it.id.toString(),
                    name = it.name
                )
            }
    }
}