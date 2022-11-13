package com.singularity_code.control.igniter

import com.singularity_code.core.common.coreMainModules
import com.singularity_code.core.network.coreNetworkModules
import com.singularity_code.core.ui.coreUIModules
import com.singularity_code.mmdexample.modMMDSampleModules
import com.singularity_code.modsample.pokemon.modPokemonModules
import com.singularity_code.modsample.todolist.modTodoListModules

val allModules = arrayOf(
    *coreMainModules,
    *coreNetworkModules,
    *coreUIModules,
    *modTodoListModules,
    *modPokemonModules,
    *modMMDSampleModules
)