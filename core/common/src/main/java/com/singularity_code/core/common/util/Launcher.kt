/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.singularity_code.core.common.util

import android.content.Context
import android.content.Intent
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import com.singularity_code.core.common.pattern.Payload
import com.singularity_code.core.common.pattern.activity.LauncherAbs
import com.singularity_code.core.common.pattern.JsonConvertible
import com.singularity_code.core.common.pattern.activity.BaseActivityAbs
import com.singularity_code.core.common.pattern.navigation.Space

fun <P : JsonConvertible, O> createLauncher(
    activity: Class<*>,
    outputType: Class<O>
): LauncherAbs<P, O> {
    return object : LauncherAbs<P, O>() {
        override val intent: (c: Context) -> Intent
            get() = { c -> Intent(c, activity) }
        override val outputType: Class<O>
            get() = outputType
    }
}

fun <P, O> BaseActivityAbs.createLauncher(
    space: Space<P, O>,
    callback: ActivityResultCallback<O?>
): ActivityResultLauncher<P> {
    return registerForActivityResult(space.getLauncher(), callback)
}

/**
 * @param S for Space
 * @param P for Payload
 * @param R for Result
 */
class Launcher<S : Space<P, R>, P : Payload, R>(
    private val space: S,
    private val activity: BaseActivityAbs
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
fun <S : Space<P, R>, P : Payload, R> BaseActivityAbs.launcher(
    space: S
) = Launcher(
    space = space,
    activity = this
)