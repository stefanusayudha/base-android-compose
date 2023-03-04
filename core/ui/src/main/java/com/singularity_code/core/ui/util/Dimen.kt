package com.singularity_code.core.ui.util

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object ScreenSpec {
    var scale = 1f
    var isTablet = false
}

/**
 * In case you wanted to scale the "dp" and "sp" unit to fit your screen.
 * Example case: sometime the design system is build for a specific kind of devices like tablet.
 * Most of the time, the component sizes, text elements and others custom elements won't fit in.
 *
 * Notes: use "toDp" and "toSp" instead of built in "dp" and "sp",
 * these extensions designed to scale respect to ScreenSpec configuration.
 */
fun setupScreenSize(scaleScreen: Float = 1f) {
    ScreenSpec.scale = scaleScreen
    ScreenSpec.isTablet = false
}

/**
 * these extensions design to automatically scale it self, respect to
 * ScreenSpec configuration.
 * @see com.singularity_code.core.ui.ScreenSpec
 */
val Int.toDp: Dp
    get() = if (ScreenSpec.isTablet) this.dp * ScreenSpec.scale else this.dp

/**
 * these extensions design to automatically scale it self, respect to
 * ScreenSpec configuration.
 * @see com.singularity_code.core.ui.ScreenSpec
 */
val Int.toSp: TextUnit
    get() = if (ScreenSpec.isTablet) this.sp * ScreenSpec.scale else this.sp