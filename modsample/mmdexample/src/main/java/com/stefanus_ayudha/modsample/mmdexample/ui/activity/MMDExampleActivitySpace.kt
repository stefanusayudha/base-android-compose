package com.stefanus_ayudha.modsample.mmdexample.ui.activity

import androidx.activity.result.contract.ActivityResultContract
import com.stefanus_ayudha.control.provider.sample.space.MMDExampleSpace
import com.stefanus_ayudha.core.common.domain.model.NOTHING
import com.stefanus_ayudha.core.common.util.launcher.createLauncher

class MMDExampleActivitySpace : MMDExampleSpace {
    override fun getLauncher(): ActivityResultContract<MMDExampleSpace.Payload, NOTHING?> {
        return createLauncher(
            activity = MMDExampleActivity::class.java,
            outputType = NOTHING::class.java
        )
    }
}