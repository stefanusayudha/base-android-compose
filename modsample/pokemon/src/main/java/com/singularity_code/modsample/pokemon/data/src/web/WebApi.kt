package com.singularity_code.modsample.pokemon.data.src.web

import arrow.core.Either
import com.singularity_code.core.common.model.VmError
import com.singularity_code.core.common.util.getOrError
import com.singularity_code.core.network.GetPokemonByIdQuery
import com.singularity_code.core.network.GetPokemonListQuery
import com.singularity_code.core.network.util.Secured
import com.singularity_code.core.network.util.apolloClient
import com.singularity_code.modsample.pokemon.data.payload.GPBIPLD
import com.singularity_code.modsample.pokemon.data.payload.GPLPLD

private val apiClient by lazy { apolloClient(Secured.getBasePokemonUrl()) }

suspend fun getPokemonListWeb(
    payload: GPLPLD
): Either<VmError, GetPokemonListQuery.Data> =
    apiClient
        .query(
            GetPokemonListQuery(
                payload.limit,
                payload.offset
            )
        )
        .getOrError()

suspend fun getPokemonByIdWeb(
    payload: GPBIPLD
): Either<VmError, GetPokemonByIdQuery.Data> =
    apiClient.query(
        GetPokemonByIdQuery(
            payload.id
        )
    ).getOrError()