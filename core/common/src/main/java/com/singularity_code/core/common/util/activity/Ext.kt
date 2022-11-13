/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.singularity_code.core.common.util.activity

import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import com.singularity_code.core.common.util.navigation.BaseSpace

fun <P, O> BaseActivity.createLauncher(
    space: BaseSpace<P, O>,
    callback: ActivityResultCallback<O?>
): ActivityResultLauncher<P> {
    return registerForActivityResult(space.getLauncher(), callback)
}