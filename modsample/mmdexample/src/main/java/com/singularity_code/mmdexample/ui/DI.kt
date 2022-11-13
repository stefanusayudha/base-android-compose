package com.singularity_code.mmdexample.ui

import com.singularity_code.control.provider.sample.mmdexample.MMDExampleSpace
import com.singularity_code.mmdexample.ui.activity.MMDExampleActivitySpace
import org.koin.dsl.module

val uiModule = module {
    factory<MMDExampleSpace> {
        MMDExampleActivitySpace()
    }
}