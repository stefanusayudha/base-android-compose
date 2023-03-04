package com.singularity_code.mmdexample.ui.screen.viewmodel.usecase

import com.singularity_code.control.provider.sample.pokemon.model.PDMDL
import com.singularity_code.control.provider.sample.pokemon.payload.GPBIPLD
import com.singularity_code.core.common.pattern.viewmodel.BaseViewModelAbs

interface PokemonViewModelUseCase {
    val pokemonState: BaseViewModelAbs.State<PDMDL, GPBIPLD>
    fun updatePokemonState(payload: GPBIPLD)
}