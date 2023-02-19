/*
 *  *********************************************************************************
 *  Created by Tezov on 19/02/2023 20:50
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 19/02/2023 20:30
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.theme.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorderSimple
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShapeSimple

val MaterialTheme.shapesExtended: ThemeShapesExtended.Shapes
    @Composable
    @ReadOnlyComposable
    get() = ThemeShapesExtended.localShapes.current
infix fun MaterialTheme.provides(value: ThemeShapesExtended.Shapes) = ThemeShapesExtended.localShapes provides value

val MaterialTheme.bordersExtended: ThemeShapesExtended.Borders
    @Composable
    @ReadOnlyComposable
    get() = ThemeShapesExtended.localBorders.current
infix fun MaterialTheme.provides(value: ThemeShapesExtended.Borders) = ThemeShapesExtended.localBorders provides value

object ThemeShapesExtended{

    @Immutable
    data class Shapes(
        val roundedCornerMicro: OutfitShapeSimple,
        val roundedCornerSmall: OutfitShapeSimple,
        val roundedCornerNormal: OutfitShapeSimple,
        val roundedCornerBig: OutfitShapeSimple,
        val roundedCornerHuge: OutfitShapeSimple,
        val dialog: OutfitShapeSimple,
        val snackbar: OutfitShapeSimple,
        val bottomSheet: OutfitShapeSimple,
    )
    internal val localShapes: ProvidableCompositionLocal<Shapes> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class Borders(
        val strokeSmall: OutfitBorderSimple,
        val strokeNormal: OutfitBorderSimple,
        val strokeBig: OutfitBorderSimple,
        val strokeHuge: OutfitBorderSimple,
        val strokeSupra: OutfitBorderSimple,
        val dialog: OutfitBorderSimple,
        val button: OutfitBorderSimple,
        val buttonOutlined: OutfitBorderSimple,
    )
    internal val localBorders: ProvidableCompositionLocal<Borders> = staticCompositionLocalOf {
        error("not provided")
    }

}