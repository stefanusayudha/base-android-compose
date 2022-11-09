package com.stefanus_ayudha.modsample.pokemon.data.src.web

import com.stefanus_ayudha.core.network.GetPokemonByIdQuery
import com.stefanus_ayudha.core.network.GetPokemonListQuery
import com.stefanus_ayudha.core.network.data.Secured
import com.stefanus_ayudha.core.network.util.apolloClient
import com.stefanus_ayudha.modsample.pokemon.data.payload.GetPokemonByIdPld
import com.stefanus_ayudha.modsample.pokemon.data.payload.GetPokemonListPld

private val apiClient by lazy { apolloClient(Secured.getBasePokemonUrl()) }

suspend fun getPokemonListWeb(
    payload: GetPokemonListPld
) = apiClient.query(
    GetPokemonListQuery(
        payload.limit,
        payload.offset
    )
).execute()

suspend fun getPokemonByIdWeb(
    payload: GetPokemonByIdPld
) = apiClient.query(
    GetPokemonByIdQuery(
        payload.id
    )
).execute()