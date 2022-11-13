package com.singularity_code.modsample.pokemon.data.src.web

import com.singularity_code.core.network.GetPokemonByIdQuery
import com.singularity_code.core.network.GetPokemonListQuery
import com.singularity_code.core.network.data.Secured
import com.singularity_code.core.network.util.apolloClient
import com.singularity_code.modsample.pokemon.data.payload.GPBIPLD
import com.singularity_code.modsample.pokemon.data.payload.GPLPLD

private val apiClient by lazy { apolloClient(Secured.getBasePokemonUrl()) }

suspend fun getPokemonListWeb(
    payload: GPLPLD
) = apiClient.query(
    GetPokemonListQuery(
        payload.limit,
        payload.offset
    )
).execute()

suspend fun getPokemonByIdWeb(
    payload: GPBIPLD
) = apiClient.query(
    GetPokemonByIdQuery(
        payload.id
    )
).execute()