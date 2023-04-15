/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 19:41
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 18:52
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class WindowInfo(
    val orientation: Int,
    val screenWidthInfo: WindowType,
    val screenHeightInfo: WindowType,
    val screenWidth: Dp,
    val screenHeigh: Dp,
) {
    sealed class WindowType {
        object Compact : WindowType()
        object Medium : WindowType()
        object Extended : WindowType()
    }

    companion object {
        @Composable
        fun remember(): WindowInfo {
            val configuration = LocalConfiguration.current
            return WindowInfo(
                configuration.orientation,
                screenWidthInfo = when {
                    configuration.screenWidthDp < 600 -> WindowType.Compact
                    configuration.screenWidthDp < 840 -> WindowType.Medium
                    else -> WindowType.Extended
                },
                screenHeightInfo = when {
                    configuration.screenHeightDp < 480 -> WindowType.Compact
                    configuration.screenHeightDp < 840 -> WindowType.Medium
                    else -> WindowType.Extended
                },
                screenWidth = configuration.screenWidthDp.dp,
                screenHeigh = configuration.screenHeightDp.dp,
            )
        }
    }
}