package com.singularity_code.modsample.pokemon.data

import arrow.core.Either
import com.singularity_code.core.common.data.model.VmError
import com.singularity_code.core.network.GetPokemonByIdQuery
import com.singularity_code.core.network.GetPokemonListQuery
import com.singularity_code.modsample.pokemon.data.payload.GPBIPLD
import com.singularity_code.modsample.pokemon.data.payload.GPLPLD
import com.singularity_code.modsample.pokemon.data.src.web.getPokemonByIdWeb
import com.singularity_code.modsample.pokemon.data.src.web.getPokemonListWeb

suspend fun getPokemonList(
    payload: GPLPLD
): Either<VmError, GetPokemonListQuery.Data> =
    getPokemonListWeb(
        payload
    )

suspend fun getPokemonById(
    payload: GPBIPLD
): Either<VmError, GetPokemonByIdQuery.Data> =
    getPokemonByIdWeb(
        payload
    )