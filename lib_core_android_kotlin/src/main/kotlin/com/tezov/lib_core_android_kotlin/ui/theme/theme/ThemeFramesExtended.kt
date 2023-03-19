/*
 *  *********************************************************************************
 *  Created by Tezov on 19/03/2023 12:48
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 19/03/2023 12:48
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
        val roundedCornerMicro: OutfitShapeColor,
        val roundedCornerSmall: OutfitShapeColor,
        val roundedCornerNormal: OutfitShapeColor,
        val roundedCornerBig: OutfitShapeColor,
        val roundedCornerHuge: OutfitShapeColor,
        val roundedCornerSupra: OutfitShapeColor,
    )
    internal val localShapes: ProvidableCompositionLocal<Shapes> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class Borders(
        val strokeMicro: OutfitBorderColor,
        val strokeSmall: OutfitBorderColor,
        val strokeNormal: OutfitBorderColor,
        val strokeBig: OutfitBorderColor,
        val strokeHuge: OutfitBorderColor,
        val strokeSupra: OutfitBorderColor,
    )
    internal val localBorders: ProvidableCompositionLocal<Borders> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class Frames(
        val button: OutfitFrameColorDual,
        val buttonOutlined: OutfitFrameColorDual,
    )
    internal val localFrames: ProvidableCompositionLocal<Frames> = staticCompositionLocalOf {
        error("not provided")
    }

}