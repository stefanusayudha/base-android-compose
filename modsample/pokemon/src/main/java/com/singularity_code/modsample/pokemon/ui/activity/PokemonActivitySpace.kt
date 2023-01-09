package com.singularity_code.modsample.pokemon.ui.activity

import com.singularity_code.control.provider.sample.pokemon.PokemonSpace
import com.singularity_code.core.common.util.createLauncher

class PokemonActivitySpace : PokemonSpace {
    override fun getLauncher() =
        createLauncher<PokemonSpace.Pld, PokemonSpace.Result>(
            activity = PokemonActivity::class.java,
            outputType = PokemonSpace.Result::class.java
        )
}