package com.singularity_code.control.provider.sample.pokemon

import com.singularity_code.control.provider.sample.pokemon.model.PDMDL
import com.singularity_code.control.provider.sample.pokemon.payload.GPBIPLD
import com.singularity_code.core.common.util.navigation.BaseSpaceStation

interface PokemonSpaceStation : BaseSpaceStation {
    suspend fun getPokemonById(
        payload: GPBIPLD
    ): PDMDL
}