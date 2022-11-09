package com.stefanus_ayudha.modsample.splash.ui.activity

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import com.stefanus_ayudha.control.provider.sample.mmdexample.MMDExampleSpace
import com.stefanus_ayudha.control.provider.sample.pokemon.PokemonSpace
import com.stefanus_ayudha.control.provider.sample.todolist.TodoSpace
import com.stefanus_ayudha.core.common.util.activity.BaseActivity
import com.stefanus_ayudha.core.common.util.navigation.launcher
import com.stefanus_ayudha.core.ui.setupScreenSize
import com.stefanus_ayudha.modsample.splash.ui.screen.splash.SplashScreen
import org.koin.android.ext.android.get

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity(), SplashActivityUseCase {

    override val todoLauncher = launcher(get<TodoSpace>())
    override val pokemonLauncher = launcher(get<PokemonSpace>())
    override val mmdExampleLauncher = launcher(get<MMDExampleSpace>())

    override val content = @Composable {
        setupScreenSize(1f)
        SplashScreen(
            portal = this
        )
    }
}