package com.stefanus_ayudha.modsample.todolist.data

import com.stefanus_ayudha.modsample.todolist.data.model.Todo
import com.stefanus_ayudha.modsample.todolist.data.payload.GetTodoByIdPayload
import com.stefanus_ayudha.modsample.todolist.data.payload.GetTodoListPayload
import com.stefanus_ayudha.modsample.todolist.data.src.web.todoListWebApi

suspend fun getTodoList(
    payload: GetTodoListPayload
): List<Todo> {
    return todoListWebApi.getTodoList(
        payload.getQueryMap()
    )
}

suspend fun getTodoById(
    payload: GetTodoByIdPayload
): Todo {
    return todoListWebApi.getTodoById(
        payload.id
    )
}