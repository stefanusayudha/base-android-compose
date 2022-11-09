package com.stefanus_ayudha.modsample.todolist.ui.screen.viewmodel

import com.stefanus_ayudha.core.common.util.viewmodel.BaseViewModel
import com.stefanus_ayudha.modsample.todolist.data.model.TodoMdl
import com.stefanus_ayudha.modsample.todolist.data.payload.GetTodoListPld

interface TodoViewModelUseCase {
    val todoListState: BaseViewModel.State<List<TodoMdl>, GetTodoListPld>
}