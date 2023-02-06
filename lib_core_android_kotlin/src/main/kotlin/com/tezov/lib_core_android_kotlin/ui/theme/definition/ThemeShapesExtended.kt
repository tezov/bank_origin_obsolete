/*
 *  *********************************************************************************
 *  Created by Tezov on 06/02/2023 21:15
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 06/02/2023 20:39
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.theme.definition

import androidx.compose.foundation.BorderStroke
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*

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
        val roundedCornerMicro: androidx.compose.ui.graphics.Shape,
        val roundedCornerSmall: androidx.compose.ui.graphics.Shape,
        val roundedCornerNormal: androidx.compose.ui.graphics.Shape,
        val roundedCornerBig: androidx.compose.ui.graphics.Shape,
        val roundedCornerHuge: androidx.compose.ui.graphics.Shape,
        val dialog: androidx.compose.ui.graphics.Shape,
        val snackbar: androidx.compose.ui.graphics.Shape,
        val bottomSheet: androidx.compose.ui.graphics.Shape,
    )
    internal val localShapes: ProvidableCompositionLocal<Shapes> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class Borders(
        val strokeSmall: BorderStroke,
        val strokeNormal: BorderStroke,
        val strokeBig: BorderStroke,
        val strokeHuge: BorderStroke,
        val strokeSupra: BorderStroke,
        val dialog: BorderStroke,
        val button: BorderStroke,
        val buttonOutlined: BorderStroke,
    )
    internal val localBorders: ProvidableCompositionLocal<Borders> = staticCompositionLocalOf {
        error("not provided")
    }

}