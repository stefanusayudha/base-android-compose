package com.stefanus_ayudha.modsample.todolist.ui

import com.stefanus_ayudha.control.provider.sample.todolist.TodoSpace
import com.stefanus_ayudha.modsample.todolist.ui.activity.TodoActivitySpace
import org.koin.dsl.module

val uiModule = module {
    factory<TodoSpace> {
        TodoActivitySpace()
    }
}