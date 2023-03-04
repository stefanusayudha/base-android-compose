package com.singularity_code.mmdexample.ui.activity

import androidx.compose.runtime.Composable
import com.singularity_code.core.common.pattern.activity.BaseActivityAbs
import com.singularity_code.core.ui.theme.ContentThemeWrapper
import com.singularity_code.mmdexample.ui.screen.home.HomeScreen

class MMDExampleActivity : BaseActivityAbs() {
    override val content = @Composable {
        ContentThemeWrapper() {
            HomeScreen()
        }
    }
}