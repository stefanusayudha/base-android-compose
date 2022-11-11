package com.stefanus_ayudha.modsample.pokemon.data.src.web

import com.stefanus_ayudha.core.network.GetPokemonByIdQuery
import com.stefanus_ayudha.core.network.GetPokemonListQuery
import com.stefanus_ayudha.core.network.data.Secured
import com.stefanus_ayudha.core.network.util.apolloClient
import com.stefanus_ayudha.modsample.pokemon.data.payload.GPBIPLD
import com.stefanus_ayudha.modsample.pokemon.data.payload.GPLPLD

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