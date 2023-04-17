/*
 *  *********************************************************************************
 *  Created by Tezov on 17/04/2023 21:26
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 17/04/2023 19:07
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.modifier

import androidx.compose.ui.Modifier

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