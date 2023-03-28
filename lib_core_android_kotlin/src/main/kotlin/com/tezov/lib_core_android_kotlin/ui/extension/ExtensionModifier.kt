/*
 *  *********************************************************************************
 *  Created by Tezov on 28/03/2023 23:25
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 28/03/2023 23:20
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.extension

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

object ExtensionModifier {

    fun Modifier.thenIfTrue(
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

    fun <T : Any> Modifier.thenIfNotNull(
        condition: T?,
        onTrue: Modifier.(T) -> Modifier,
        onFalse: (Modifier.() -> Modifier)? = null
    ): Modifier {
        return if (condition != null) {
            then(onTrue(condition))
        } else if (onFalse != null) {
            then(onFalse())
        } else {
            this
        }
    }


    inline fun Modifier.clickableDisabled(): Modifier = composed {
        clickable(
            enabled = false,
            indication = null,
            interactionSource = remember { MutableInteractionSource() }) {
        }
    }
}