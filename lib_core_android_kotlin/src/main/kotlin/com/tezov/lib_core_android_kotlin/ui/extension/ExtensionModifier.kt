/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 23:53
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 23:52
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.extension

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionDensity.toDp

object ExtensionModifier {

    fun Modifier.then(
        condition: Boolean,
        onTrue: Modifier.() -> Modifier,
        onFalse: (Modifier.() -> Modifier)? = null
    ): Modifier {
        return if (condition) {
            then(onTrue())
        } else if (onFalse != null) {
            then(onFalse())
        } else {
            this
        }
    }

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


    fun Modifier.fillMaxHeightAuto(minHeightState:MutableState<Dp>) = composed {
        val density = LocalDensity.current.density
        onSizeChanged {size ->
            val itemHeight = size.height.toDp(density)
            with(minHeightState.value){
                if(this == Dp.Unspecified || itemHeight > this){
                    minHeightState.value = itemHeight
                }
            }
        }.defaultMinSize(minHeight = minHeightState.value)
    }


}