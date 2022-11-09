package com.stefanus_ayudha.modsample.mmdexample.ui.activity

import androidx.compose.runtime.Composable
import com.stefanus_ayudha.core.common.util.activity.BaseActivity
import com.stefanus_ayudha.modsample.mmdexample.ui.screen.HomeScreen

class MMDExampleActivity : BaseActivity() {
    override val content = @Composable {
        HomeScreen()
    }
}