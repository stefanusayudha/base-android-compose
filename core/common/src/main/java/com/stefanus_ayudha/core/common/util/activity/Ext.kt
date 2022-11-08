package com.stefanus_ayudha.core.common.util.activity

import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import com.stefanus_ayudha.core.common.util.navigation.BaseSpace

fun <P, O> BaseActivity.createLauncher(
    space: BaseSpace<P, O>,
    callback: ActivityResultCallback<O?>
): ActivityResultLauncher<P> {
    return registerForActivityResult(space.getLauncher(), callback)
}