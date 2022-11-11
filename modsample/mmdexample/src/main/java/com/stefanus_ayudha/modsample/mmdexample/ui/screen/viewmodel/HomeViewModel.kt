package com.stefanus_ayudha.modsample.mmdexample.ui.screen.viewmodel

import com.stefanus_ayudha.control.provider.sample.pokemon.PokemonSpaceStation
import com.stefanus_ayudha.control.provider.sample.pokemon.model.PokemonDataMdl
import com.stefanus_ayudha.control.provider.sample.pokemon.payload.GetPokemonByIdPld
import com.stefanus_ayudha.core.common.util.koin.get
import com.stefanus_ayudha.core.common.util.viewmodel.BaseViewModel
import com.stefanus_ayudha.core.common.util.viewmodel.stateCreator

class HomeViewModel(
    private val pokemonSpaceStation: PokemonSpaceStation = get()
) : BaseViewModel(), HomeViewModelUseCase {

    override val pokemonState =
        stateCreator<PokemonDataMdl, GetPokemonByIdPld> {
            pokemonSpaceStation.getPokemonById(it)
        }

    override fun clear() {
        TODO("Not yet implemented")
    }

    init {
        pokemonState.request(
            GetPokemonByIdPld(
                11
            )
        )
    }
}