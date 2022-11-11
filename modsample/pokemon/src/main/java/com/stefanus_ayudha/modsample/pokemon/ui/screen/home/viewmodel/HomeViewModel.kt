package com.stefanus_ayudha.modsample.pokemon.ui.screen.home.viewmodel

import com.stefanus_ayudha.core.common.util.viewmodel.BaseViewModel
import com.stefanus_ayudha.core.common.util.viewmodel.stateCreator
import com.stefanus_ayudha.core.network.GetPokemonListQuery
import com.stefanus_ayudha.modsample.pokemon.data.getPokemonList
import com.stefanus_ayudha.modsample.pokemon.data.payload.GetPokemonListPld

class HomeViewModel : BaseViewModel(), HomeViewModelUseCase {

    override val pokemonListState =
        stateCreator<GetPokemonListQuery.Data, GetPokemonListPld> {
            getPokemonList(it)
        }

    override fun clear() {
        TODO("Not yet implemented")
    }

    init {
        pokemonListState.request(
            GetPokemonListPld(
                limit = 30
            )
        )
    }
}