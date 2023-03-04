/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.singularity_code.core.common.pattern.application

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.singularity_code.core.common.util.application.ApplicationContext
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.module.Module

abstract class BaseApplication : Application() {
    abstract val modules: Array<Module>

    companion object {
        @SuppressLint("StaticFieldLeak")
        var context: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(modules.toList())
            androidLogger(Level.INFO)
        }
        ApplicationContext.set(applicationContext)
    }
}