package com.singularity_code.modsample.pokemon.ui.screen.home.viewmodel

import com.singularity_code.core.common.pattern.viewmodel.BaseViewModelAbs
import com.singularity_code.core.network.GetPokemonListQuery
import com.singularity_code.modsample.pokemon.data.payload.GPLPLD

interface HomeViewModelUseCase {
    val pokemonListState: BaseViewModelAbs.State<GetPokemonListQuery.Data, GPLPLD>
    fun updatePokemonListState(payload: GPLPLD)
}