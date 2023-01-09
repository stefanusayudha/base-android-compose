/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.singularity_code.core.common.util

import android.content.Context
import android.content.Intent
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import com.singularity_code.core.common.pattern.Payload
import com.singularity_code.core.common.pattern.BaseLauncher
import com.singularity_code.core.common.pattern.JsonConvertAble
import com.singularity_code.core.common.pattern.baseactivity.BaseActivity
import com.singularity_code.core.common.pattern.navigation.Space

fun <P : JsonConvertAble, O> createLauncher(
    activity: Class<*>,
    outputType: Class<O>
): BaseLauncher<P, O> {
    return object : BaseLauncher<P, O>() {
        override val intent: (c: Context) -> Intent
            get() = { c -> Intent(c, activity) }
        override val outputType: Class<O>
            get() = outputType
    }
}

fun <P, O> BaseActivity.createLauncher(
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
fun <S : Space<P, R>, P : Payload, R> BaseActivity.launcher(
    space: S
) = Launcher(
    space = space,
    activity = this
)