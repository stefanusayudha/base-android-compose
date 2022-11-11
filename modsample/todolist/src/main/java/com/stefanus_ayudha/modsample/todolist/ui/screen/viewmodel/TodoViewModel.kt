package com.stefanus_ayudha.modsample.todolist.ui.screen.viewmodel

import com.stefanus_ayudha.core.common.util.viewmodel.BaseViewModel
import com.stefanus_ayudha.core.common.util.viewmodel.createStateHolder
import com.stefanus_ayudha.modsample.todolist.data.getTodoList
import com.stefanus_ayudha.modsample.todolist.data.model.TDMDL
import com.stefanus_ayudha.modsample.todolist.data.payload.GetTodoListPld

class TodoViewModel : BaseViewModel(), TodoViewModelUseCase {

    override val todoListState =
        createStateHolder<List<TDMDL>, GetTodoListPld> {
            getTodoList(it)
        }

    override fun clear() {
        todoListState.resetClear()
    }
}