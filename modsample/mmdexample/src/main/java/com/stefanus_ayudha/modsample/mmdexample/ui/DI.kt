package com.stefanus_ayudha.modsample.mmdexample.ui

import com.stefanus_ayudha.control.provider.sample.space.MMDExampleSpace
import com.stefanus_ayudha.control.provider.sample.space.PokemonSpace
import com.stefanus_ayudha.modsample.mmdexample.ui.activity.MMDExampleActivitySpace
import org.koin.dsl.module

val uiModule = module {
    factory<MMDExampleSpace> {
        MMDExampleActivitySpace()
    }
}