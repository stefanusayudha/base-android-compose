package com.singularity_code.modsample.todolist.ui.screen.viewmodel

import com.singularity_code.core.common.pattern.viewmodel.BaseViewModelAbs
import com.singularity_code.modsample.todolist.data.model.TDMDL
import com.singularity_code.modsample.todolist.data.payload.GetTodoListPld

interface TodoViewModelUseCase {
    val todoListState: BaseViewModelAbs.State<List<TDMDL>, GetTodoListPld>
}