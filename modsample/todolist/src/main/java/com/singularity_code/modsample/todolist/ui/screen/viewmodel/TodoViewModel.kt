package com.singularity_code.modsample.todolist.ui.screen.viewmodel

import com.singularity_code.core.common.pattern.viewmodel.BaseViewModelAbs
import com.singularity_code.core.common.util.createStateHolder
import com.singularity_code.modsample.todolist.data.getTodoList
import com.singularity_code.modsample.todolist.data.model.TDMDL
import com.singularity_code.modsample.todolist.data.payload.GetTodoListPld

class TodoViewModel : BaseViewModelAbs(), TodoViewModelUseCase {

    override val todoListState =
        createStateHolder<List<TDMDL>, GetTodoListPld> {
            getTodoList(it)
        }

    override fun clear() {
        todoListState.resetClear()
    }
}