package com.stefanus_ayudha.modsample.todolist.ui.activity

import androidx.activity.result.contract.ActivityResultContract
import com.stefanus_ayudha.control.provider.sample.todolist.TodoSpace
import com.stefanus_ayudha.core.common.domain.model.NOTHING
import com.stefanus_ayudha.core.common.util.launcher.createLauncher

class TodoActivitySpace() : TodoSpace {
    override fun getLauncher(): ActivityResultContract<TodoSpace.Pld, TodoSpace.Result?> {
        return createLauncher(
            activity = TodoActivity::class.java,
            outputType = TodoSpace.Result::class.java
        )
    }
}