/*
 *  *********************************************************************************
 *  Created by Tezov on 29/03/2023 22:26
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 29/03/2023 22:26
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

object ThemeFramesExtended{

    @Immutable
    data class Shapes(
        val roundedCornerMicro: OutfitShape.StateColor = NoValue("ThemeFramesExtended:Shapes:roundedCornerMicro"),
        val roundedCornerSmall: OutfitShape.StateColor = NoValue("ThemeFramesExtended:Shapes:roundedCornerSmall"),
        val roundedCornerNormal: OutfitShape.StateColor = NoValue("ThemeFramesExtended:Shapes:roundedCornerNormal"),
        val roundedCornerBig: OutfitShape.StateColor = NoValue("ThemeFramesExtended:Shapes:roundedCornerBig"),
        val roundedCornerHuge: OutfitShape.StateColor = NoValue("ThemeFramesExtended:Shapes:roundedCornerHuge"),
        val roundedCornerSupra: OutfitShape.StateColor = NoValue("ThemeFramesExtended:Shapes:roundedCornerSupra"),
    )
    internal val localShapes: ProvidableCompositionLocal<Shapes> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class Borders(
        val strokeMicro: OutfitBorder.StateColor = NoValue("ThemeFramesExtended:Borders:strokeMicro"),
        val strokeSmall: OutfitBorder.StateColor = NoValue("ThemeFramesExtended:Borders:strokeSmall"),
        val strokeNormal: OutfitBorder.StateColor = NoValue("ThemeFramesExtended:Borders:strokeNormal"),
        val strokeBig: OutfitBorder.StateColor = NoValue("ThemeFramesExtended:Borders:strokeBig"),
        val strokeHuge: OutfitBorder.StateColor = NoValue("ThemeFramesExtended:Borders:strokeHuge"),
        val strokeSupra: OutfitBorder.StateColor = NoValue("ThemeFramesExtended:Borders:strokeSupra"),
    )
    internal val localBorders: ProvidableCompositionLocal<Borders> = staticCompositionLocalOf {
        error("not provided")
    }

}