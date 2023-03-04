package com.singularity_code.mmdexample.ui.screen.viewmodel.usecase

import com.singularity_code.control.provider.sample.pokemon.model.PokemonGem
import com.singularity_code.control.provider.sample.pokemon.payload.GetPokemonByIdSPLD
import com.singularity_code.core.common.pattern.viewmodel.BaseViewModelAbs

interface PokemonViewModelUseCase {
    val pokemonState: BaseViewModelAbs.State<PokemonGem, GetPokemonByIdSPLD>
    fun updatePokemonState(payload: GetPokemonByIdSPLD)
}