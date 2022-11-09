package com.stefanus_ayudha.modsample.splash.ui.navigation

import androidx.activity.result.ActivityResultLauncher
import com.stefanus_ayudha.control.provider.sample.space.MMDExampleSpace
import com.stefanus_ayudha.control.provider.sample.space.PokemonSpace
import com.stefanus_ayudha.control.provider.sample.space.TodoSpace
import com.stefanus_ayudha.core.common.domain.model.NOTHING

interface SplashPortal {
    val todoSpace: TodoSpace
    val todoLauncher: ActivityResultLauncher<TodoSpace.Payload>
    var todoLauncherResult: ((NOTHING) -> Unit)?
    fun goToTodoList(
        payload: TodoSpace.Payload,
        result: ((NOTHING) -> Unit)? = null
    ) {
        todoLauncherResult = result
        todoLauncher.launch(payload)
    }

    val pokemonSpace: PokemonSpace
    val pokemonLauncher: ActivityResultLauncher<PokemonSpace.Payload>
    var pokemonLauncherResult: ((NOTHING) -> Unit)?
    fun goToPokemonHome(
        payload: PokemonSpace.Payload,
        result: ((NOTHING) -> Unit)? = null
    ) {
        pokemonLauncherResult = result
        pokemonLauncher.launch(payload)
    }

    val mmdExampleSpace: MMDExampleSpace
    val mmdExampleLauncher: ActivityResultLauncher<MMDExampleSpace.Payload>
    var mmdExampleLauncherResult: ((NOTHING) -> Unit)?
    fun goToMMDExample(
        payload: MMDExampleSpace.Payload,
        result: ((NOTHING) -> Unit)? = null
    ) {
        mmdExampleLauncherResult = result
        mmdExampleLauncher.launch(payload)
    }
}