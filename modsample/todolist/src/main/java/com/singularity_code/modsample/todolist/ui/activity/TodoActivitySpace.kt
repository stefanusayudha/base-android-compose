package com.singularity_code.modsample.todolist.ui.activity

import com.singularity_code.control.provider.sample.todolist.TodoSpace
import com.singularity_code.core.common.util.createLauncher

class TodoActivitySpace() : TodoSpace {
    override fun getLauncher() =
        createLauncher<TodoSpace.Pld, TodoSpace.Result>(
            activity = TodoActivity::class.java,
            outputType = TodoSpace.Result::class.java
        )
}