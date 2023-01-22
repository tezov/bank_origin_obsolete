package com.tezov.lib_core_android_kotlin.ui.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.InternalComposeApi
import androidx.compose.runtime.ProvidedValue

object ExtensionCompositionLocal {

    @Composable
    fun CompositionLocalProvider(
        parent: Array<ProvidedValue<*>>,
        child: @Composable () -> Array<ProvidedValue<*>>,
        content: @Composable () -> Unit
    ) {
        androidx.compose.runtime.CompositionLocalProvider(values = *parent) {
            androidx.compose.runtime.CompositionLocalProvider(values = *child(), content = content)
        }
    }
}