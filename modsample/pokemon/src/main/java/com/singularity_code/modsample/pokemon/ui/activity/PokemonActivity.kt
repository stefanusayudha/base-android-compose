package com.singularity_code.modsample.pokemon.ui.activity

import androidx.compose.runtime.Composable
import com.singularity_code.core.common.pattern.activity.BaseActivityAbs
import com.singularity_code.core.ui.theme.ContentThemeWrapper
import com.singularity_code.modsample.pokemon.ui.screen.home.HomeScreen

class PokemonActivity : BaseActivityAbs() {
    override val content = @Composable {
        ContentThemeWrapper {
            HomeScreen()
        }
    }
}