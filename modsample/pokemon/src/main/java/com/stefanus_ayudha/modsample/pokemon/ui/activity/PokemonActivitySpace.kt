package com.stefanus_ayudha.modsample.pokemon.ui.activity

import androidx.activity.result.contract.ActivityResultContract
import com.stefanus_ayudha.control.provider.sample.pokemon.PokemonSpace
import com.stefanus_ayudha.core.common.domain.model.NOTHING
import com.stefanus_ayudha.core.common.util.launcher.createLauncher

class PokemonActivitySpace : PokemonSpace {
    override fun getLauncher(): ActivityResultContract<PokemonSpace.Pld, PokemonSpace.Result?> {
        return createLauncher(
            activity = PokemonActivity::class.java,
            outputType = PokemonSpace.Result::class.java
        )
    }
}