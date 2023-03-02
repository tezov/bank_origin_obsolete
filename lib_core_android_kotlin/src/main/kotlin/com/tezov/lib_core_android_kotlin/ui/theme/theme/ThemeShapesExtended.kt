/*
 *  *********************************************************************************
 *  Created by Tezov on 02/03/2023 20:30
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 02/03/2023 20:30
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

val MaterialTheme.shapesSketchExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeShapesExtended.Shapes.localShapesSketch.current
infix fun MaterialTheme.provides(value: ThemeShapesExtended.Shapes.Sketch) = ThemeShapesExtended.Shapes.localShapesSketch provides value

val MaterialTheme.bordersSketchExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeShapesExtended.Borders.localBordersSketch.current
infix fun MaterialTheme.provides(value: ThemeShapesExtended.Borders.Sketch) = ThemeShapesExtended.Borders.localBordersSketch provides value

object ThemeShapesExtended{

    object Shapes{
        @Immutable
        data class Sketch(
            val roundedCornerMicro: OutfitShapeSketch,
            val roundedCornerSmall: OutfitShapeSketch,
            val roundedCornerNormal: OutfitShapeSketch,
            val roundedCornerBig: OutfitShapeSketch,
            val roundedCornerHuge: OutfitShapeSketch,
            val roundedCornerSupra: OutfitShapeSketch,

            val dialog: OutfitShapeSketch,
            val snackbar: OutfitShapeSketch,
            val bottomSheet: OutfitShapeSketch,
        )
        internal val localShapesSketch: ProvidableCompositionLocal<Sketch> = staticCompositionLocalOf {
            error("not provided")
        }
    }

    object Borders{

        @Immutable
        data class Sketch(
            val strokeMicro: OutfitBorderSketch,
            val strokeSmall: OutfitBorderSketch,
            val strokeNormal: OutfitBorderSketch,
            val strokeBig: OutfitBorderSketch,
            val strokeHuge: OutfitBorderSketch,
            val strokeSupra: OutfitBorderSketch,
            val dialog: OutfitBorderSketch,
            val button: OutfitBorderSketch,
            val buttonOutlined: OutfitBorderSketch,
        )
        internal val localBordersSketch: ProvidableCompositionLocal<Sketch> = staticCompositionLocalOf {
            error("not provided")
        }

    }




}