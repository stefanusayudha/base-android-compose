package com.singularity_code.modsample.pokemon.ui.screen.home.viewmodel

import com.singularity_code.core.common.util.viewmodel.BaseViewModel
import com.singularity_code.core.common.util.viewmodel.createStateHolder
import com.singularity_code.core.network.GetPokemonListQuery
import com.singularity_code.modsample.pokemon.data.getPokemonList
import com.singularity_code.modsample.pokemon.data.payload.GPLPLD

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