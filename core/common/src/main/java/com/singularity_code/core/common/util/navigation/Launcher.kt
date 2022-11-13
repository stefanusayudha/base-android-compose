/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.singularity_code.core.common.util.navigation

import com.singularity_code.core.common.data.payload.Payload
import com.singularity_code.core.common.util.activity.BaseActivity
import com.singularity_code.core.common.util.activity.createLauncher

/**
 * @param S for Space
 * @param P for Payload
 * @param R for Result
 */
class Launcher<S : BaseSpace<P, R>, P : Payload, R>(
    private val space: S,
    private val activity: BaseActivity
) {
    /**
     * Override this value for callback action
     */
    var resultCallback: ((R) -> Unit)? = null

    private val launcher = activity.createLauncher(space) {
        if (it != null)
            resultCallback?.invoke(it)
    }

    fun launch(
        payload: P
    ) {
        launcher.launch(payload)
    }
}

/**
 * @param S for Space
 * @param P for Payload
 * @param R for Result
 * @param space for Space
 */
fun <S : BaseSpace<P, R>, P : Payload, R> BaseActivity.launcher(
    space: S
) = Launcher(
    space = space,
    activity = this
)