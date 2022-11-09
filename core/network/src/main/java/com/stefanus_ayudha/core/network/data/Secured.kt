package com.stefanus_ayudha.core.network.data

import com.iddevops.core.network.BuildConfig

// use to store base URL securely by android NDK

interface SecuredUseCase {
    fun getBaseUrl(): String
    fun getBasePokemonUrl(): String
}

class SecuredDev : SecuredUseCase {
    init {
        System.loadLibrary("native-lib")
    }

    external override fun getBaseUrl(): String
    external override fun getBasePokemonUrl(): String
}

class SecuredStaging: SecuredUseCase {
    init {
        System.loadLibrary("native-lib")
    }

    external override fun getBaseUrl(): String
    external override fun getBasePokemonUrl(): String
}

class SecuredProd: SecuredUseCase {
    init {
        System.loadLibrary("native-lib")
    }

    external override fun getBaseUrl(): String
    external override fun getBasePokemonUrl(): String
}

val Secured: SecuredUseCase by lazy {
    when (BuildConfig.BUILD_TYPE) {
        "debug" -> SecuredDev()
        "staging" -> SecuredStaging()
        else -> SecuredProd()
    }
}