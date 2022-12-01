package com.singularity_code.modsample.pokemon.station

import arrow.core.Either
import com.singularity_code.control.provider.sample.pokemon.PokemonSpaceStation
import com.singularity_code.control.provider.sample.pokemon.model.PDMDL
import com.singularity_code.control.provider.sample.pokemon.payload.GPBIPLD
import com.singularity_code.core.common.data.model.VmError

class SpaceStation : PokemonSpaceStation {
    override suspend fun getPokemonById(
        payload: GPBIPLD
    ): Either<VmError, PDMDL> {

        val pld = com.singularity_code
            .modsample
            .pokemon
            .data
            .payload
            .GPBIPLD(payload.id)

        return com.singularity_code
            .modsample
            .pokemon
            .data
            .getPokemonById(
                pld
            )
            .map {
                it.pokemon_v2_pokemon[0]
                    .let {
                        PDMDL(
                            id = it.id.toString(),
                            name = it.name
                        )
                    }
            }
    }
}