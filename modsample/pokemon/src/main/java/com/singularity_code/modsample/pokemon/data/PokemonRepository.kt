package com.singularity_code.modsample.pokemon.data

import com.singularity_code.core.network.GetPokemonByIdQuery
import com.singularity_code.core.network.GetPokemonListQuery
import com.singularity_code.modsample.pokemon.data.payload.GPBIPLD
import com.singularity_code.modsample.pokemon.data.payload.GPLPLD
import com.singularity_code.modsample.pokemon.data.src.web.getPokemonByIdWeb
import com.singularity_code.modsample.pokemon.data.src.web.getPokemonListWeb

suspend fun getPokemonList(
    payload: GPLPLD
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
    payload: GPBIPLD
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