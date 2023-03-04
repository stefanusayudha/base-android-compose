package com.singularity_code.modsample.todolist.ui.activity

import androidx.compose.runtime.Composable
import com.singularity_code.core.common.model.NOTHING
import com.singularity_code.core.common.pattern.activity.ActivityResultEmitter
import com.singularity_code.core.common.pattern.activity.BaseActivityAbs
import com.singularity_code.modsample.todolist.ui.screen.TodoScreen

class TodoActivity : BaseActivityAbs(), ActivityResultEmitter<NOTHING> {
    override val content = @Composable { TodoScreen() }
}