package com.singularity_code.modsample.splash.ui.activity

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import com.singularity_code.control.provider.sample.mmdexample.MMDExampleSpace
import com.singularity_code.control.provider.sample.pokemon.PokemonSpace
import com.singularity_code.control.provider.sample.todolist.TodoSpace
import com.singularity_code.core.common.pattern.activity.BaseActivityAbs
import com.singularity_code.core.common.util.launcher
import com.singularity_code.core.ui.theme.ContentThemeWrapper
import com.singularity_code.core.ui.util.setupScreenSize
import com.singularity_code.modsample.splash.ui.screen.splash.SplashScreen
import org.koin.android.ext.android.get

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivityAbs(), SplashActivityUseCase {

    override val todoLauncher = launcher(get<TodoSpace>())
    override val pokemonLauncher = launcher(get<PokemonSpace>())
    override val mmdExampleLauncher = launcher(get<MMDExampleSpace>())

    override val content = @Composable {
        setupScreenSize(1f)
        ContentThemeWrapper() {
            SplashScreen(
                portal = this
            )
        }
    }
}