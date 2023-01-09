package com.singularity_code.mmdexample.ui.activity

import androidx.compose.runtime.Composable
import com.singularity_code.core.common.pattern.baseactivity.BaseActivity
import com.singularity_code.mmdexample.ui.screen.home.HomeScreen

class MMDExampleActivity : BaseActivity() {
    override val content = @Composable {
        HomeScreen()
    }
}