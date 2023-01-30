/*
 *  *********************************************************************************
 *  Created by Tezov on 30/01/2023 20:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 30/01/2023 20:11
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
        val cardSmall: androidx.compose.ui.graphics.Shape,
        val cardNormal: androidx.compose.ui.graphics.Shape,
        val cardBig: androidx.compose.ui.graphics.Shape,
        val buttonSmall: androidx.compose.ui.graphics.Shape,
        val buttonNormal: androidx.compose.ui.graphics.Shape,
        val buttonBig: androidx.compose.ui.graphics.Shape,
        val buttonOutlinedSmall: androidx.compose.ui.graphics.Shape,
        val buttonOutlinedNormal: androidx.compose.ui.graphics.Shape,
        val buttonOutlinedBig: androidx.compose.ui.graphics.Shape,
        val dialog: androidx.compose.ui.graphics.Shape,
        val snackbar: androidx.compose.ui.graphics.Shape,
        val bottomSheet: androidx.compose.ui.graphics.Shape,
    )
    internal val localShapes: ProvidableCompositionLocal<Shapes> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class Borders(
        val dialog: BorderStroke,
        val button: BorderStroke,
    )
    internal val localBorders: ProvidableCompositionLocal<Borders> = staticCompositionLocalOf {
        error("not provided")
    }

}