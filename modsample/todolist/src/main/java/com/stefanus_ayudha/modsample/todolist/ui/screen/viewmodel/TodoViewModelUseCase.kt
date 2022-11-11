package com.stefanus_ayudha.modsample.todolist.ui.screen.viewmodel

import com.stefanus_ayudha.core.common.util.viewmodel.BaseViewModel
import com.stefanus_ayudha.modsample.todolist.data.model.TDMDL
import com.stefanus_ayudha.modsample.todolist.data.payload.GetTodoListPld

interface TodoViewModelUseCase {
    val todoListState: BaseViewModel.State<List<TDMDL>, GetTodoListPld>
}