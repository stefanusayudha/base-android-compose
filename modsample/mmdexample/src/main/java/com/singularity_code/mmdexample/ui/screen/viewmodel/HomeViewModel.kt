package com.singularity_code.mmdexample.ui.screen.viewmodel

import com.singularity_code.control.provider.sample.pokemon.PokemonSpaceStation
import com.singularity_code.control.provider.sample.pokemon.model.PDMDL
import com.singularity_code.control.provider.sample.pokemon.payload.GPBIPLD
import com.singularity_code.core.common.util.get
import com.singularity_code.core.common.pattern.viewmodel.BaseViewModelAbs
import com.singularity_code.core.common.util.createStateHolder

class HomeViewModel(
    private val pokemonSpaceStation: PokemonSpaceStation = get()
) : BaseViewModelAbs(), HomeViewModelUseCase {

    override val pokemonState = createStateHolder<PDMDL, GPBIPLD> {
        pokemonSpaceStation.getPokemonById(it)
    }

    override fun updatePokemonState(
        payload: GPBIPLD
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
            GPBIPLD(
                id = 1
            )
        )
    }
}