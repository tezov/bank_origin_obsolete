/*
 *  *********************************************************************************
 *  Created by Tezov on 01/04/2023 21:02
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 01/04/2023 20:46
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.theme.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.unit.Dp
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
        val roundedCorner: OutfitPalette.Variant<OutfitShape.StateColor>,
    )
    internal val localShapes: ProvidableCompositionLocal<Shapes> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class Borders(
        val stroke: OutfitPalette.Variant<OutfitBorder.StateColor>,
    )
    internal val localBorders: ProvidableCompositionLocal<Borders> = staticCompositionLocalOf {
        error("not provided")
    }

}