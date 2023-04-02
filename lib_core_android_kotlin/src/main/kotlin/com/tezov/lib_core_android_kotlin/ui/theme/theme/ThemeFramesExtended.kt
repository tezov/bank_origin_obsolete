/*
 *  *********************************************************************************
 *  Created by Tezov on 02/04/2023 14:12
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 02/04/2023 14:12
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
        val roundedCorner: OutfitPalette.Variant<OutfitShape.StateColor.Style>,
    )
    internal val localShapes: ProvidableCompositionLocal<Shapes> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class Borders(
        val stroke: OutfitPalette.Variant<OutfitBorder.StateColor.Style>,
    )
    internal val localBorders: ProvidableCompositionLocal<Borders> = staticCompositionLocalOf {
        error("not provided")
    }

}