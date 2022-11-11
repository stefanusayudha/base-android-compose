package com.stefanus_ayudha.modsample.todolist.ui.screen.viewmodel

import com.stefanus_ayudha.core.common.util.viewmodel.BaseViewModel
import com.stefanus_ayudha.core.common.util.viewmodel.stateCreator
import com.stefanus_ayudha.modsample.todolist.data.getTodoList
import com.stefanus_ayudha.modsample.todolist.data.model.TodoMdl
import com.stefanus_ayudha.modsample.todolist.data.payload.GetTodoListPld

class TodoViewModel : BaseViewModel(), TodoViewModelUseCase {

    override val todoListState =
        stateCreator<List<TodoMdl>, GetTodoListPld> {
            getTodoList(it)
        }

    override fun clear() {
        todoListState.resetClear()
    }
}