package com.singularity_code.modsample.todolist.data

import com.singularity_code.modsample.todolist.data.model.TDMDL
import com.singularity_code.modsample.todolist.data.payload.GetTodoByIdPld
import com.singularity_code.modsample.todolist.data.payload.GetTodoListPld
import com.singularity_code.modsample.todolist.data.src.web.todoListWebApi

suspend fun getTodoList(
    payload: GetTodoListPld
): List<TDMDL> {
    return todoListWebApi.getTodoList(
        payload.getQueryMap()
    )
}

suspend fun getTodoById(
    payload: GetTodoByIdPld
): TDMDL {
    return todoListWebApi.getTodoById(
        payload.id
    )
}