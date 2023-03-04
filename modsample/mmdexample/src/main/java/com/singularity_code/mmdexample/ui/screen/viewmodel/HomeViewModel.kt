package com.singularity_code.mmdexample.ui.screen.viewmodel

import com.singularity_code.control.provider.sample.pokemon.PokemonSpaceStation
import com.singularity_code.control.provider.sample.pokemon.model.PokemonGem
import com.singularity_code.control.provider.sample.pokemon.payload.GetPokemonByIdSPLD
import com.singularity_code.core.common.pattern.viewmodel.BaseViewModelAbs
import com.singularity_code.core.common.util.createStateHolder
import com.singularity_code.core.common.util.get

class HomeViewModel(
    private val pokemonSpaceStation: PokemonSpaceStation = get()
) : BaseViewModelAbs(), HomeViewModelUseCase {

    override val pokemonState = createStateHolder<PokemonGem, GetPokemonByIdSPLD> {
        pokemonSpaceStation.getPokemonById(it)
    }

    override fun updatePokemonState(
        payload: GetPokemonByIdSPLD
    ) {
        pokemonState.requestUpdate(
            payload
        )
    }

    override fun clear() {
        TODO("Not yet implemented")
    }

    init {
        updatePokemonState(
            GetPokemonByIdSPLD(
                id = 1
            )
        )
    }
}