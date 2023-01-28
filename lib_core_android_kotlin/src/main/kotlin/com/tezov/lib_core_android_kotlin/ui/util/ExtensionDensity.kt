package com.tezov.lib_core_android_kotlin.ui.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

object ExtensionDensity {
    val Dp.toPx @Composable get() = (value * LocalDensity.current.density)
    val Int.toDp @Composable get() = Dp((this / LocalDensity.current.density))
}