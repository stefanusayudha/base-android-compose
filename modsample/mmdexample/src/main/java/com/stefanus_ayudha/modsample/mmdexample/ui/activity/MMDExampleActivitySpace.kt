package com.stefanus_ayudha.modsample.mmdexample.ui.activity

import androidx.activity.result.contract.ActivityResultContract
import com.stefanus_ayudha.control.provider.sample.mmdexample.MMDExampleSpace
import com.stefanus_ayudha.core.common.util.launcher.createLauncher

class MMDExampleActivitySpace : MMDExampleSpace {
    override fun getLauncher(): ActivityResultContract<MMDExampleSpace.Pld, MMDExampleSpace.Result?> {
        return createLauncher(
            activity = MMDExampleActivity::class.java,
            outputType = MMDExampleSpace.Result::class.java
        )
    }
}