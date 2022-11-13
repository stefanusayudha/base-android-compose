package com.singularity_code.modsample.splash.ui.activity

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import com.singularity_code.control.provider.sample.mmdexample.MMDExampleSpace
import com.singularity_code.control.provider.sample.pokemon.PokemonSpace
import com.singularity_code.control.provider.sample.todolist.TodoSpace
import com.singularity_code.core.common.util.activity.BaseActivity
import com.singularity_code.core.common.util.navigation.launcher
import com.singularity_code.core.ui.setupScreenSize
import com.singularity_code.modsample.splash.ui.screen.splash.SplashScreen
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