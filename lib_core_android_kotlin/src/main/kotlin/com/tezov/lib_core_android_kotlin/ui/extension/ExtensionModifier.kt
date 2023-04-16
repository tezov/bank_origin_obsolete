/*
 *  *********************************************************************************
 *  Created by Tezov on 16/04/2023 14:41
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 16/04/2023 14:34
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.extension

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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

object ExtensionModifier {

    fun Modifier.thenOnTrue(
        condition: Boolean,
        block: Modifier.() -> Modifier
    ) = then(condition, onTrue = block)

    fun Modifier.thenOnFalse(
        condition: Boolean,
        block: Modifier.() -> Modifier
    ) = then(condition, onFalse = block)

    fun Modifier.then(
        condition: Boolean,
        onTrue: (Modifier.() -> Modifier)? = null,
        onFalse: (Modifier.() -> Modifier)? = null
    ) = (if(condition){
        onTrue?.let { then(it()) }
    } else{
        onFalse?.let { then(it()) }
    }) ?: this

    fun <T : Any> Modifier.thenOnNotNull(
        condition: T?,
        block: Modifier.(T) -> Modifier
    ) = then(condition, onNotNull = block)

    fun <T : Any> Modifier.thenOnNull(
        condition: T?,
        block: Modifier.() -> Modifier
    ) = then(condition, onNull = block)

    fun <T : Any> Modifier.then(
        condition: T?,
        onNotNull: (Modifier.(T) -> Modifier)? = null,
        onNull: (Modifier.() -> Modifier)? = null
    ) = (condition?.let {
        onNotNull?.let { then(it(condition)) }
    } ?: run {
        onNull?.let { then(it()) }
    }) ?: this


    fun Modifier.clickableDisabled(): Modifier = composed {
        clickable(
            enabled = false,
            indication = null,
            interactionSource = remember { MutableInteractionSource() }
        ) {}
    }

    fun Modifier.updateToMaxHeight(heightState: MutableState<Dp>) = composed {
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

    fun Modifier.fillMaxHeight(heightState: MutableState<Dp>) =
        updateToMaxHeight(heightState).height(heightState.value)

    fun Modifier.fillMaxHeightRemembered() = composed {
        val heightState = remember {
            mutableStateOf(Dp.Unspecified)
        }
        fillMaxHeight(heightState)
    }

    fun Modifier.fillDefaultMinHeight(heightState: MutableState<Dp>) =
        updateToMaxHeight(heightState).defaultMinSize(minHeight = heightState.value)

    fun Modifier.fillDefaultMinHeightRemembered() = composed {
        val heightState = remember {
            mutableStateOf(Dp.Unspecified)
        }
        fillDefaultMinHeight(heightState)
    }

}