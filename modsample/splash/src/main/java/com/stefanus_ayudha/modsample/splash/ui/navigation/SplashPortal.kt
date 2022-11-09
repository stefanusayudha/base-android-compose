package com.stefanus_ayudha.modsample.splash.ui.navigation

import com.stefanus_ayudha.control.provider.sample.mmdexample.MMDExampleSpace
import com.stefanus_ayudha.control.provider.sample.pokemon.PokemonSpace
import com.stefanus_ayudha.control.provider.sample.todolist.TodoSpace
import com.stefanus_ayudha.core.common.util.navigation.Launcher

interface SplashPortal {
    val todoLauncher: Launcher<TodoSpace, TodoSpace.Pld, TodoSpace.Result>
    fun goToTodoList(
        payload: TodoSpace.Pld,
        result: ((TodoSpace.Result) -> Unit)? = null
    ) {
        todoLauncher.resultCallback = result
        todoLauncher.launch(payload)
    }

    val pokemonLauncher: Launcher<PokemonSpace, PokemonSpace.Pld, PokemonSpace.Result>
    fun goToPokemonHome(
        payload: PokemonSpace.Pld,
        result: ((PokemonSpace.Result) -> Unit)? = null
    ) {
        pokemonLauncher.resultCallback = result
        pokemonLauncher.launch(payload)
    }

    val mmdExampleLauncher: Launcher<MMDExampleSpace, MMDExampleSpace.Pld, MMDExampleSpace.Result>
    fun goToMMDExample(
        payload: MMDExampleSpace.Pld,
        result: ((MMDExampleSpace.Result) -> Unit)? = null
    ) {
        mmdExampleLauncher.resultCallback = result
        mmdExampleLauncher.launch(payload)
    }
}