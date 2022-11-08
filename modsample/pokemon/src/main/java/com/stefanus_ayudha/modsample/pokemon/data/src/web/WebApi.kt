package com.stefanus_ayudha.modsample.pokemon.data.src.web

import com.stefanus_ayudha.core.network.GetPokemonListQuery
import com.stefanus_ayudha.core.network.data.Secured
import com.stefanus_ayudha.core.network.util.apolloClient
import com.stefanus_ayudha.modsample.pokemon.data.payload.GetPokemonListPayload

private val apiClient by lazy { apolloClient(Secured.getBasePokemonUrl()) }

suspend fun getPokemonListWeb(
    payload: GetPokemonListPayload
) = apiClient.query(
    GetPokemonListQuery(
        payload.limit,
        payload.offset
    )
).execute()