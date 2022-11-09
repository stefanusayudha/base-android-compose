package com.stefanus_ayudha.modsample.pokemon.station

import com.stefanus_ayudha.control.provider.sample.pokemon.PokemonSpaceStation
import org.koin.dsl.module

val stationModule = module {
    factory<PokemonSpaceStation> {
        SpaceStation()
    }
}