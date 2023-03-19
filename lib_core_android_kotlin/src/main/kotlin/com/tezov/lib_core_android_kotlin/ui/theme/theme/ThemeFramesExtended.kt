/*
 *  *********************************************************************************
 *  Created by Tezov on 19/03/2023 16:08
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 19/03/2023 14:46
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.theme.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.*

val MaterialTheme.shapesExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeFramesExtended.localShapes.current
infix fun MaterialTheme.provides(value: ThemeFramesExtended.Shapes) = ThemeFramesExtended.localShapes provides value

val MaterialTheme.bordersExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeFramesExtended.localBorders.current
infix fun MaterialTheme.provides(value: ThemeFramesExtended.Borders) = ThemeFramesExtended.localBorders provides value

val MaterialTheme.framesExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeFramesExtended.localFrames.current
infix fun MaterialTheme.provides(value: ThemeFramesExtended.Frames) = ThemeFramesExtended.localFrames provides value

object ThemeFramesExtended{

    @Immutable
    data class Shapes(
        val roundedCornerMicro: OutfitShape.StateColor,
        val roundedCornerSmall: OutfitShape.StateColor,
        val roundedCornerNormal: OutfitShape.StateColor,
        val roundedCornerBig: OutfitShape.StateColor,
        val roundedCornerHuge: OutfitShape.StateColor,
        val roundedCornerSupra: OutfitShape.StateColor,
    )
    internal val localShapes: ProvidableCompositionLocal<Shapes> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class Borders(
        val strokeMicro: OutfitBorder.StateColor,
        val strokeSmall: OutfitBorder.StateColor,
        val strokeNormal: OutfitBorder.StateColor,
        val strokeBig: OutfitBorder.StateColor,
        val strokeHuge: OutfitBorder.StateColor,
        val strokeSupra: OutfitBorder.StateColor,
    )
    internal val localBorders: ProvidableCompositionLocal<Borders> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class Frames(
        val button: OutfitFrame.StateColor,
        val buttonOutlined: OutfitFrame.StateColor,
    )
    internal val localFrames: ProvidableCompositionLocal<Frames> = staticCompositionLocalOf {
        error("not provided")
    }

}