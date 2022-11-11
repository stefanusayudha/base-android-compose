package com.stefanus_ayudha.control.provider.sample.pokemon

import com.stefanus_ayudha.control.provider.sample.pokemon.model.PDMDL
import com.stefanus_ayudha.control.provider.sample.pokemon.payload.GPBIPLD
import com.stefanus_ayudha.core.common.util.navigation.BaseSpaceStation

interface PokemonSpaceStation : BaseSpaceStation {
    suspend fun getPokemonById(
        payload: GPBIPLD
    ): PDMDL
}