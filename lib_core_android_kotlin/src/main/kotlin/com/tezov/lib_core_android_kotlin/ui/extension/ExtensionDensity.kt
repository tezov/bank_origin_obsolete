/*
 *  *********************************************************************************
 *  Created by Tezov on 12/02/2023 16:03
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 12/02/2023 15:22
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.extension

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionDensity.toPx

object ExtensionDensity {

    inline val Dp.toPx @Composable get() = this.toPx(LocalDensity.current.density)
    fun Dp.toPx(density:Float) = value * density

    val Int.toDp @Composable get() = this.toDp(LocalDensity.current.density)
    fun Int.toDp(density:Float) = Dp((this / density))

    val Float.toDp @Composable get() = this.toDp(LocalDensity.current.density)
    fun Float.toDp(density:Float) = Dp((this / density))

}