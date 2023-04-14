/*
 *  *********************************************************************************
 *  Created by Tezov on 14/04/2023 22:46
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 14/04/2023 22:12
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.extension

import android.graphics.BlurMaskFilter
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

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
            interactionSource = remember { MutableInteractionSource() }) {
        }
    }

}