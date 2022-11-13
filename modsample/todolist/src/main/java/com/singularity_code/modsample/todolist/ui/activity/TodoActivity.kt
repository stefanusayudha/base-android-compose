package com.singularity_code.modsample.todolist.ui.activity

import androidx.compose.runtime.Composable
import com.singularity_code.core.common.data.model.NOTHING
import com.singularity_code.core.common.util.activity.ActivityResultEmitter
import com.singularity_code.core.common.util.activity.BaseActivity
import com.singularity_code.core.common.util.handler.BackPressHandler
import com.singularity_code.core.common.util.handler.BackPressHandlerProvider
import com.singularity_code.modsample.todolist.ui.screen.TodoScreen

class TodoActivity : BaseActivity(), ActivityResultEmitter<NOTHING> {
    override val content = @Composable { TodoScreen() }

    override fun onEarlyCreate() {
        super.onEarlyCreate()
        BackPressHandlerProvider.add(lifecycle, backPressHandler)
    }

    private val backPressHandler by lazy {
        object : BackPressHandler {
            override fun onBackPress() {
                activityReturnOK(NOTHING("from home: alksndmandlanldnandlad"))
            }

            override fun isActive(): Boolean {
                return true
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        BackPressHandlerProvider.remove(backPressHandler)
    }
}