package com.stefanus_ayudha.modsample.pokemon.data

import com.stefanus_ayudha.core.network.GetPokemonByIdQuery
import com.stefanus_ayudha.core.network.GetPokemonListQuery
import com.stefanus_ayudha.modsample.pokemon.data.payload.GetPokemonByIdPld
import com.stefanus_ayudha.modsample.pokemon.data.payload.GetPokemonListPayload
import com.stefanus_ayudha.modsample.pokemon.data.src.web.getPokemonByIdWeb
import com.stefanus_ayudha.modsample.pokemon.data.src.web.getPokemonListWeb

suspend fun getPokemonList(
    payload: GetPokemonListPayload
): GetPokemonListQuery.Data =
    getPokemonListWeb(
        payload
    ).let {
        if (it.hasErrors())
            throw Error(
                it.errors!!.map { e ->
                    e.message
                }.toString()
            )
        else
            it.data ?: GetPokemonListQuery.Data(
                pokemon_v2_pokemon = listOf()
            )
    }

suspend fun getPokemonById(
    payload: GetPokemonByIdPld
): GetPokemonByIdQuery.Data =
    getPokemonByIdWeb(
        payload
    ).let {
        if (it.hasErrors())
            throw Error(
                it.errors!!.map { e ->
                    e.message
                }.toString()
            )
        else
            it.data ?: GetPokemonByIdQuery.Data(
                pokemon_v2_pokemon = listOf()
            )
    }