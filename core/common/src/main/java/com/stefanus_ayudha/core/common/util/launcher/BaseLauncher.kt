package com.stefanus_ayudha.core.common.util.launcher

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.stefanus_ayudha.core.common.util.activity.ActivityResultEmitter
import com.stefanus_ayudha.core.common.util.gson.JsonConvertAble
import com.stefanus_ayudha.core.common.util.gson.toObject

abstract class BaseLauncher<P : JsonConvertAble, O>
    : ActivityResultContract<P, O?>() {

    abstract val intent: (c: Context) -> Intent
    abstract val outputType: Class<O>

    override fun createIntent(context: Context, input: P): Intent {
        return with(intent.invoke(context)) {
            putExtra(ActivityResultEmitter.KEY.PAYLOAD.name, input.toStringJSON())
            this
        }
    }

    override fun parseResult(resultCode: Int, intent: Intent?): O? {
        return if (resultCode == Activity.RESULT_OK) intent?.getStringExtra(ActivityResultEmitter.KEY.RESULT.name)
            ?.toObject(outputType)
            ?: run {
                // TODO: firebase crash analytic here
                throw NullPointerException()
            }
        else null
    }
}