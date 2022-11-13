/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.singularity_code.core.common.util.bootstrap

interface BootstrapUseCase {
    fun initData()
    fun initUI()
    fun initAction()
    fun initObserver()
}