package com.stefanus_ayudha.modsample.todolist.data

import com.stefanus_ayudha.modsample.todolist.data.model.TDMDL
import com.stefanus_ayudha.modsample.todolist.data.payload.GetTodoByIdPld
import com.stefanus_ayudha.modsample.todolist.data.payload.GetTodoListPld
import com.stefanus_ayudha.modsample.todolist.data.src.web.todoListWebApi

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