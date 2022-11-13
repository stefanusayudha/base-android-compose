package com.singularity_code.modsample.pokemon.station

import com.singularity_code.control.provider.sample.pokemon.PokemonSpaceStation
import org.koin.dsl.module

val stationModule = module {
    factory<PokemonSpaceStation> {
        SpaceStation()
    }
}