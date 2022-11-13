package com.singularity_code.modsample.pokemon.ui.activity

import androidx.compose.runtime.Composable
import com.singularity_code.core.common.util.activity.BaseActivity
import com.singularity_code.modsample.pokemon.ui.screen.home.HomeScreen

class PokemonActivity : BaseActivity() {
    override val content = @Composable { HomeScreen() }
}