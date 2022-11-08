package com.stefanus_ayudha.core.common.util.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.lifecycleScope
import com.stefanus_ayudha.core.common.util.handler.BackPressHandlerProvider
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class BaseActivity : ComponentActivity(), BaseActivityUseCase {

    override val TAG = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onEarlyCreate()

        setContent {
            content()
        }

        initData()
        initUI()
        initObserver()
        initAction()
    }

    override fun onEarlyCreate() {}

    override fun initData() {}

    override fun initUI() {}

    override fun initObserver() {}

    override fun initAction() {}

    override fun withScope(block: suspend () -> Unit): Job {
        return lifecycleScope.launch {
            block.invoke()
        }
    }

    abstract val content: @Composable () -> Unit

    final override fun onBackPressed() {
        BackPressHandlerProvider.getActiveHandler()?.onBackPress()
            ?: super.onBackPressed()
    }
}