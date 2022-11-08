package com.stefanus_ayudha.modsample.todolist.ui.screen.viewmodel

import com.stefanus_ayudha.core.common.util.viewmodel.BaseViewModel
import com.stefanus_ayudha.modsample.todolist.data.getTodoList
import com.stefanus_ayudha.modsample.todolist.data.model.Todo
import com.stefanus_ayudha.modsample.todolist.data.payload.GetTodoListPayload

class TodoViewModel : BaseViewModel(), TodoViewModelUseCase {

    override val todoListState = object : State<List<Todo>, GetTodoListPayload>() {
        override val operator: suspend (GetTodoListPayload) -> List<Todo> = { getTodoList(it) }
    }

    override fun clear() {
        todoListState.resetClear()
    }
}