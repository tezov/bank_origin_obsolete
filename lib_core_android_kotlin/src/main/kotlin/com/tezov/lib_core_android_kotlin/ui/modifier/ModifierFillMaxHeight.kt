/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
 */

/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
 */

package com.tezov.lib_core_android_kotlin.ui.modifier

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionDensity.toDp

fun Modifier.updateToMaxHeight(heightState: MutableState<Dp>, enabled: Boolean = true) =
    if (enabled) {
        composed {
            val density = LocalDensity.current.density
            onSizeChanged { size ->
                val itemHeight = size.height.toDp(density)
                with(heightState.value) {
                    if (this == Dp.Unspecified || itemHeight > this) {
                        heightState.value = itemHeight
                    }
                }
            }
        }
    } else {
        this
    }

fun Modifier.fillMaxHeight(heightState: MutableState<Dp>, enabled: Boolean = true) =
    updateToMaxHeight(heightState, enabled).thenOnTrue(enabled) { height(heightState.value) }

fun Modifier.fillMaxHeightRemembered(enabled: Boolean = true) = composed {
    val heightState = remember {
        mutableStateOf(Dp.Unspecified)
    }
    fillMaxHeight(heightState, enabled)
}

fun Modifier.fillDefaultMinHeight(heightState: MutableState<Dp>, enabled: Boolean = true) =
    updateToMaxHeight(heightState, enabled).thenOnTrue(enabled) { defaultMinSize(minHeight = heightState.value) }

fun Modifier.fillDefaultMinHeightRemembered(enabled: Boolean = true) = composed {
    val heightState = remember {
        mutableStateOf(Dp.Unspecified)
    }
    fillDefaultMinHeight(heightState, enabled)
}