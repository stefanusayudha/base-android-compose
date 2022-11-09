package com.stefanus_ayudha.modsample.pokemon.ui.screen.home.viewmodel

import com.stefanus_ayudha.core.common.util.viewmodel.BaseViewModel
import com.stefanus_ayudha.core.network.GetPokemonListQuery
import com.stefanus_ayudha.modsample.pokemon.data.payload.GetPokemonListPld

interface HomeViewModelUseCase {
    val pokemonListState: BaseViewModel.State<GetPokemonListQuery.Data, GetPokemonListPld>
}