package com.singularity_code.core.network.util

import com.iddevops.core.network.BuildConfig
import com.singularity_code.core.network.data.SecuredUseCase


object SecuredDev : SecuredUseCase {
    init {
        System.loadLibrary("dev-url")
    }

    external override fun getBaseUrl(): String
    external override fun getBasePokemonUrl(): String
}

object SecuredStaging: SecuredUseCase {
    init {
        System.loadLibrary("stage-url")
    }

    external override fun getBaseUrl(): String
    external override fun getBasePokemonUrl(): String
}

object SecuredProd: SecuredUseCase {
    init {
        System.loadLibrary("prod-url")
    }

    external override fun getBaseUrl(): String
    external override fun getBasePokemonUrl(): String
}

val Secured: SecuredUseCase by lazy {
    when (BuildConfig.BUILD_TYPE) {
        "debug" -> SecuredDev
        "staging" -> SecuredStaging
        else -> SecuredProd
    }
}