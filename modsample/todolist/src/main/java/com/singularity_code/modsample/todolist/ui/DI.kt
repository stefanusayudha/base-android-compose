package com.singularity_code.modsample.todolist.ui

import com.singularity_code.control.provider.sample.todolist.TodoSpace
import com.singularity_code.modsample.todolist.ui.activity.TodoActivitySpace
import org.koin.dsl.module

val uiModule = module {
    factory<TodoSpace> {
        TodoActivitySpace()
    }
}