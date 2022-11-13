/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */

package com.singularity_code.core.ui

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