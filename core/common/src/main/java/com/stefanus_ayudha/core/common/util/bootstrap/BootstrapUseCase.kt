package com.stefanus_ayudha.core.common.util.bootstrap

interface BootstrapUseCase {
    fun initData()
    fun initUI()
    fun initAction()
    fun initObserver()
}