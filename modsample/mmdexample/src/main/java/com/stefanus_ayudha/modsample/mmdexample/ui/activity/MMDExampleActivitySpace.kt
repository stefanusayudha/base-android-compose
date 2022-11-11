package com.stefanus_ayudha.modsample.mmdexample.ui.activity

import com.stefanus_ayudha.control.provider.sample.mmdexample.MMDExampleSpace
import com.stefanus_ayudha.core.common.util.launcher.createLauncher

class MMDExampleActivitySpace : MMDExampleSpace {
    override fun getLauncher() =
        createLauncher<MMDExampleSpace.Pld, MMDExampleSpace.Result>(
            activity = MMDExampleActivity::class.java,
            outputType = MMDExampleSpace.Result::class.java
        )
}