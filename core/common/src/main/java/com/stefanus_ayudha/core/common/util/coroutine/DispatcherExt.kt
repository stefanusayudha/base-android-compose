package com.stefanus_ayudha.core.common.util.coroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun LaunchInIO(block: suspend CoroutineScope.() -> Unit) {
    CoroutineScope(Dispatchers.IO).launch { block.invoke(this) }
}

fun LaunchInMain(block: suspend CoroutineScope.() -> Unit) {
    CoroutineScope(Dispatchers.Main).launch { block.invoke(this) }
}

fun LaunchInDefault(block: suspend CoroutineScope.() -> Unit) {
    CoroutineScope(Dispatchers.Default).launch { block.invoke(this) }
}