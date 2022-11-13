/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */

package com.singularity_code.core.common

import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val coreMainModules = arrayOf(
    module {
        factory { androidApplication() }
        factory { androidContext() }
    }
)