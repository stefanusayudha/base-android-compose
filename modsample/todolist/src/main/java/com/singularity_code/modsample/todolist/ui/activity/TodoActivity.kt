package com.singularity_code.modsample.todolist.ui.activity

import androidx.compose.runtime.Composable
import com.singularity_code.core.common.pattern.NOTHING
import com.singularity_code.core.common.pattern.ActivityResultEmitter
import com.singularity_code.core.common.pattern.baseactivity.BaseActivity
import com.singularity_code.modsample.todolist.ui.screen.TodoScreen

class TodoActivity : BaseActivity(), ActivityResultEmitter<NOTHING> {
    override val content = @Composable { TodoScreen() }
}