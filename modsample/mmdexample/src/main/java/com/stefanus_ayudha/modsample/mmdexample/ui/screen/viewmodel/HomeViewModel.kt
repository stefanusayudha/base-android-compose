package com.stefanus_ayudha.modsample.mmdexample.ui.screen.viewmodel

import com.stefanus_ayudha.control.provider.sample.pokemon.PokemonSpaceStation
import com.stefanus_ayudha.control.provider.sample.pokemon.model.PokemonDataMdl
import com.stefanus_ayudha.control.provider.sample.pokemon.payload.GetPokemonByIdPld
import com.stefanus_ayudha.core.common.util.koin.get
import com.stefanus_ayudha.core.common.util.viewmodel.BaseViewModel

class HomeViewModel(
    private val pokemonSpaceStation: PokemonSpaceStation = get()
) : BaseViewModel(), HomeViewModelUseCase {

    override val pokemonState =
        object : State<PokemonDataMdl, GetPokemonByIdPld>() {
            override val operator: suspend (payload: GetPokemonByIdPld) -> PokemonDataMdl
                get() = {
                    pokemonSpaceStation.getPokemonById(it)
                }
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