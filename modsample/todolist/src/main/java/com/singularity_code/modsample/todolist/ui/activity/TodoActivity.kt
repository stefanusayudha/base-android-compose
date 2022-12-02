package com.singularity_code.modsample.todolist.ui.activity

import androidx.compose.runtime.Composable
import com.singularity_code.core.common.data.model.NOTHING
import com.singularity_code.core.common.util.activity.ActivityResultEmitter
import com.singularity_code.core.common.util.activity.BaseActivity
import com.singularity_code.modsample.todolist.ui.screen.TodoScreen

class TodoActivity : BaseActivity(), ActivityResultEmitter<NOTHING> {
    override val content = @Composable { TodoScreen() }
}