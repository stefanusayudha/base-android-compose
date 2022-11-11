package com.stefanus_ayudha.modsample.pokemon.ui.activity

import com.stefanus_ayudha.control.provider.sample.pokemon.PokemonSpace
import com.stefanus_ayudha.core.common.util.launcher.createLauncher

class PokemonActivitySpace : PokemonSpace {
    override fun getLauncher() =
        createLauncher<PokemonSpace.Pld, PokemonSpace.Result>(
            activity = PokemonActivity::class.java,
            outputType = PokemonSpace.Result::class.java
        )
}