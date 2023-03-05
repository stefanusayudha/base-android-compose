/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */

package com.singularity_code.core.network.data

// use to store base URL securely by android NDK
interface SecuredUseCase {
    fun getBaseUrl(): String
    fun getBasePokemonUrl(): String
}