package com.stefanus_ayudha.modsample.splash.ui.activity

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import com.stefanus_ayudha.control.provider.sample.space.MMDExampleSpace
import com.stefanus_ayudha.control.provider.sample.space.PokemonSpace
import com.stefanus_ayudha.control.provider.sample.space.TodoSpace
import com.stefanus_ayudha.core.common.domain.model.NOTHING
import com.stefanus_ayudha.core.common.util.activity.BaseActivity
import com.stefanus_ayudha.core.common.util.activity.createLauncher
import com.stefanus_ayudha.core.ui.setupScreenSize
import com.stefanus_ayudha.modsample.splash.ui.screen.splash.SplashScreen
import org.koin.android.ext.android.inject

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity(), SplashActivityUseCase {

    override val todoSpace: TodoSpace by inject()
    override var todoLauncherResult: ((NOTHING) -> Unit)? = null
    override val todoLauncher = createLauncher(todoSpace) {
        if (it != null)
            todoLauncherResult?.invoke(it)
    }

    override val pokemonSpace: PokemonSpace by inject()
    override var pokemonLauncherResult: ((NOTHING) -> Unit)? = null
    override val pokemonLauncher = createLauncher(pokemonSpace) {
        if (it != null)
            pokemonLauncherResult?.invoke(it)
    }

    override val mmdExampleSpace: MMDExampleSpace by inject()
    override var mmdExampleLauncherResult: ((NOTHING) -> Unit)? = null
    override val mmdExampleLauncher = createLauncher(mmdExampleSpace) {
        if (it != null)
            mmdExampleLauncherResult?.invoke(it)
    }

    override val content = @Composable {
        setupScreenSize(1f)
        SplashScreen(
            portal = this
        )
    }
}