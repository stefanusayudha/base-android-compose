package com.singularity_code.modsample.pokemon.ui

import com.singularity_code.control.provider.sample.pokemon.PokemonSpace
import com.singularity_code.modsample.pokemon.ui.activity.PokemonActivitySpace
import org.koin.dsl.module

val uiModule = module {
    factory<PokemonSpace> {
        PokemonActivitySpace()
    }
}