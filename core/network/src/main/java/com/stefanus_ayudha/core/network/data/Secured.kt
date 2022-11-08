package com.stefanus_ayudha.core.network.data

// use to store base URL securely by android NDK
object Secured {
    init {
        System.loadLibrary("native-lib")
    }

    external fun getBaseUrl(): String
    external fun getBasePokemonUrl(): String
}

const val BASE_URL = "BASE URL"