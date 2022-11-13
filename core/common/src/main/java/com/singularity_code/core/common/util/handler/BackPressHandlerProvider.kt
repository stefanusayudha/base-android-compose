/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.singularity_code.core.common.util.handler

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

object BackPressHandlerProvider {
    private val backPressHandler = arrayListOf<BackPressHandler>()

    fun add(lifecycle: Lifecycle, handler: BackPressHandler) {
        backPressHandler.add(handler)
        // side effect : remove handler on destroy
        removeHandlerOnDestroy(lifecycle, handler)
    }

    fun remove(handler: BackPressHandler) {
        backPressHandler.remove(handler)
    }

    fun getActiveHandler(): BackPressHandler? {
        var activeHandler: BackPressHandler? = null

        backPressHandler.forEach {
            if (it.isActive())
                activeHandler = it
        }

        return activeHandler
    }

    private fun removeHandlerOnDestroy(lifecycle: Lifecycle, handler: BackPressHandler) {
        lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onDestroy(owner: LifecycleOwner) {
                super.onDestroy(owner)
                kotlin.runCatching {
                    backPressHandler.remove(handler)
                }
            }
        })
    }

}