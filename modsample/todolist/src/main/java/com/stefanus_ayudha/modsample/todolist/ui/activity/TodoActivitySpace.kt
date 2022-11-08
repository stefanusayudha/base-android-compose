package com.stefanus_ayudha.modsample.todolist.ui.activity

import androidx.activity.result.contract.ActivityResultContract
import com.stefanus_ayudha.control.provider.sample.space.TodoSpace
import com.stefanus_ayudha.core.common.domain.model.NOTHING
import com.stefanus_ayudha.core.common.util.launcher.createLauncher

class TodoActivitySpace() : TodoSpace {
    override fun getLauncher(): ActivityResultContract<TodoSpace.Payload, NOTHING?> {
        return createLauncher(
            activity = TodoActivity::class.java,
            outputType = NOTHING::class.java
        )
    }
}