package com.stefanus_ayudha.modsample.mmdexample.ui.screen.viewmodel

import com.stefanus_ayudha.control.provider.sample.pokemon.PokemonSpaceStation
import com.stefanus_ayudha.control.provider.sample.pokemon.model.PDMDL
import com.stefanus_ayudha.control.provider.sample.pokemon.payload.GPBIPLD
import com.stefanus_ayudha.core.common.util.koin.get
import com.stefanus_ayudha.core.common.util.viewmodel.BaseViewModel
import com.stefanus_ayudha.core.common.util.viewmodel.createStateHolder

class HomeViewModel(
    private val pokemonSpaceStation: PokemonSpaceStation = get()
) : BaseViewModel(), HomeViewModelUseCase {

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