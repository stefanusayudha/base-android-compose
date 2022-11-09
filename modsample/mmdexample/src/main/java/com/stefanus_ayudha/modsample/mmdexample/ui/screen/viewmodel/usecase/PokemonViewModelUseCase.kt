package com.stefanus_ayudha.modsample.mmdexample.ui.screen.viewmodel.usecase

import com.stefanus_ayudha.control.provider.sample.pokemon.model.PokemonDataMdl
import com.stefanus_ayudha.control.provider.sample.pokemon.payload.GetPokemonByIdPld
import com.stefanus_ayudha.core.common.util.viewmodel.BaseViewModel

interface PokemonViewModelUseCase {
    val pokemonListState: BaseViewModel.State<PokemonDataMdl, GetPokemonByIdPld>
}