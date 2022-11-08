package com.stefanus_ayudha.core.common.util.navigation

import androidx.activity.result.contract.ActivityResultContract

interface BaseSpace<P, O> {
    fun getLauncher(): ActivityResultContract<P, O?>
}