package com.singularity_code.modsample.pokemon.ui.screen.home.viewmodel

import com.singularity_code.core.common.pattern.viewmodel.BaseViewModelAbs
import com.singularity_code.core.common.util.createStateHolder
import com.singularity_code.core.network.GetPokemonListQuery
import com.singularity_code.modsample.pokemon.data.getPokemonList
import com.singularity_code.modsample.pokemon.data.payload.GPLPLD

class HomeViewModel : BaseViewModelAbs(), HomeViewModelUseCase {

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