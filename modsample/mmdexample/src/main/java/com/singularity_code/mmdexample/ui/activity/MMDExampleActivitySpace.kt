package com.singularity_code.mmdexample.ui.activity

import com.singularity_code.control.provider.sample.mmdexample.MMDExampleSpace
import com.singularity_code.core.common.util.launcher.createLauncher

class MMDExampleActivitySpace : MMDExampleSpace {
    override fun getLauncher() =
        createLauncher<MMDExampleSpace.Pld, MMDExampleSpace.Result>(
            activity = MMDExampleActivity::class.java,
            outputType = MMDExampleSpace.Result::class.java
        )
}