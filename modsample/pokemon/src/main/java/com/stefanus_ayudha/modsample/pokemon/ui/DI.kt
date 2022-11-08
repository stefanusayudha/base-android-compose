package com.stefanus_ayudha.modsample.pokemon.ui

import com.stefanus_ayudha.control.provider.sample.space.PokemonSpace
import com.stefanus_ayudha.modsample.pokemon.ui.activity.PokemonActivitySpace
import org.koin.dsl.module

val uiModule = module {
    factory<PokemonSpace> {
        PokemonActivitySpace()
    }
}