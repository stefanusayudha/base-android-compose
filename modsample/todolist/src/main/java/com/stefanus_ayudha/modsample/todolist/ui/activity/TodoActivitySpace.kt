package com.stefanus_ayudha.modsample.todolist.ui.activity

import com.stefanus_ayudha.control.provider.sample.todolist.TodoSpace
import com.stefanus_ayudha.core.common.util.launcher.createLauncher

class TodoActivitySpace() : TodoSpace {
    override fun getLauncher() =
        createLauncher<TodoSpace.Pld, TodoSpace.Result>(
            activity = TodoActivity::class.java,
            outputType = TodoSpace.Result::class.java
        )
}