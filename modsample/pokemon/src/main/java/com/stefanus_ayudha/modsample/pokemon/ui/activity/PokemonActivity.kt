package com.stefanus_ayudha.modsample.pokemon.ui.activity

import androidx.compose.runtime.Composable
import com.stefanus_ayudha.core.common.util.activity.BaseActivity
import com.stefanus_ayudha.modsample.pokemon.ui.screen.home.HomeScreen

class PokemonActivity : BaseActivity() {
    override val content = @Composable { HomeScreen() }
}