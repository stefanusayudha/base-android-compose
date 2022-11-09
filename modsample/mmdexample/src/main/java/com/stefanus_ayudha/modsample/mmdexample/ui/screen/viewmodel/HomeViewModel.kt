package com.stefanus_ayudha.modsample.mmdexample.ui.screen.viewmodel

import com.stefanus_ayudha.control.provider.sample.pokemon.PokemonSpaceStation
import com.stefanus_ayudha.control.provider.sample.pokemon.model.PokemonDataMdl
import com.stefanus_ayudha.control.provider.sample.pokemon.payload.GetPokemonByIdPld
import com.stefanus_ayudha.core.common.util.koin.get
import com.stefanus_ayudha.core.common.util.viewmodel.BaseViewModel

class HomeViewModel : BaseViewModel(), HomeViewModelUseCase {

    private val pokemonSpaceStation = get<PokemonSpaceStation>()
    override val pokemonListState = object : State<PokemonDataMdl, GetPokemonByIdPld>() {
        override val operator: suspend (payload: GetPokemonByIdPld) -> PokemonDataMdl
            get() = {
                pokemonSpaceStation.getPokemonById(it)
            }
    }

    override fun clear() {
        TODO("Not yet implemented")
    }

    init {
        pokemonListState.request(
            GetPokemonByIdPld(
                11
            )
        )
    }
}