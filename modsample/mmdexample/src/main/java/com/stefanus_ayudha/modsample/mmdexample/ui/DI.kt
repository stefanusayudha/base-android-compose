package com.stefanus_ayudha.modsample.mmdexample.ui

import com.stefanus_ayudha.control.provider.sample.mmdexample.MMDExampleSpace
import com.stefanus_ayudha.modsample.mmdexample.ui.activity.MMDExampleActivitySpace
import org.koin.dsl.module

val uiModule = module {
    factory<MMDExampleSpace> {
        MMDExampleActivitySpace()
    }
}