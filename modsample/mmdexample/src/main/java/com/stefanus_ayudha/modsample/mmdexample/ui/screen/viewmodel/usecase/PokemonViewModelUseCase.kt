package com.stefanus_ayudha.modsample.mmdexample.ui.screen.viewmodel.usecase

import com.stefanus_ayudha.control.provider.sample.pokemon.model.PDMDL
import com.stefanus_ayudha.control.provider.sample.pokemon.payload.GPBIPLD
import com.stefanus_ayudha.core.common.util.viewmodel.BaseViewModel

interface PokemonViewModelUseCase {
    val pokemonState: BaseViewModel.State<PDMDL, GPBIPLD>
    fun updatePokemonState(payload: GPBIPLD)
}