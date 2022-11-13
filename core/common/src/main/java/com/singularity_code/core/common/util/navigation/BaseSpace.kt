/*
 * Copyright (c) 2022. Stefanus Ayudha + Joseph Sanjaya.
 */
package com.singularity_code.core.common.util.navigation

import androidx.activity.result.contract.ActivityResultContract

interface BaseSpace<P, O> {
    fun getLauncher(): ActivityResultContract<P, O?>
}