/*
 *  *********************************************************************************
 *  Created by Tezov on 05/02/2023 01:03
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 04/02/2023 23:13
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

object ExtensionDensity {
    val Dp.toPx @Composable get() = (value * LocalDensity.current.density)
    val Int.toDp @Composable get() = Dp((this / LocalDensity.current.density))
}