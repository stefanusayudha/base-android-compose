package com.stefanus_ayudha.modsample.pokemon.ui.screen.home.viewmodel

import com.stefanus_ayudha.core.common.util.viewmodel.BaseViewModel
import com.stefanus_ayudha.core.common.util.viewmodel.createStateHolder
import com.stefanus_ayudha.core.network.GetPokemonListQuery
import com.stefanus_ayudha.modsample.pokemon.data.getPokemonList
import com.stefanus_ayudha.modsample.pokemon.data.payload.GPLPLD

class HomeViewModel : BaseViewModel(), HomeViewModelUseCase {

    override val pokemonListState =
        createStateHolder<GetPokemonListQuery.Data, GPLPLD> {
            getPokemonList(it)
        }

    override fun updatePokemonListState(
        payload: GPLPLD
    ) {
        pokemonListState.requestUpdate(
            payload
        )
    }

    override fun clear() {
        TODO("Not yet implemented")
    }

    init {
        updatePokemonListState(
            GPLPLD(
                limit = 30
            )
        )
    }
}