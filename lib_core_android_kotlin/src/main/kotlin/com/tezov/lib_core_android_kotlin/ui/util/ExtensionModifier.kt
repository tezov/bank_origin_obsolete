package com.tezov.lib_core_android_kotlin.ui.util

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

object ExtensionModifier {

    inline fun Modifier.clickableDisabled(): Modifier = composed {
        clickable(
            enabled = false,
            indication = null,
            interactionSource = remember { MutableInteractionSource() }) {
        }
    }
}