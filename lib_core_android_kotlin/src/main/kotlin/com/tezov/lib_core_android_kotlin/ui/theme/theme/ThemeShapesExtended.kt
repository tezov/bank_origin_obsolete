/*
 *  *********************************************************************************
 *  Created by Tezov on 26/02/2023 12:51
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 26/02/2023 11:51
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

val MaterialTheme.shapesSimpleExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeShapesExtended.Shapes.localShapesSimple.current
infix fun MaterialTheme.provides(value: ThemeShapesExtended.Shapes.Simple) = ThemeShapesExtended.Shapes.localShapesSimple provides value

val MaterialTheme.bordersSimpleExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeShapesExtended.Borders.localBordersSimple.current
infix fun MaterialTheme.provides(value: ThemeShapesExtended.Borders.Simple) = ThemeShapesExtended.Borders.localBordersSimple provides value

object ThemeShapesExtended{

    object Shapes{
        @Immutable
        data class Simple(
            val roundedCornerMicro: OutfitShapeSimple,
            val roundedCornerSmall: OutfitShapeSimple,
            val roundedCornerNormal: OutfitShapeSimple,
            val roundedCornerBig: OutfitShapeSimple,
            val roundedCornerHuge: OutfitShapeSimple,
            val roundedCornerSupra: OutfitShapeSimple,

            val dialog: OutfitShapeSimple,
            val snackbar: OutfitShapeSimple,
            val bottomSheet: OutfitShapeSimple,
        )
        internal val localShapesSimple: ProvidableCompositionLocal<Simple> = staticCompositionLocalOf {
            error("not provided")
        }
    }

    object Borders{

        @Immutable
        data class Simple(
            val strokeMicro: OutfitBorderSimple,
            val strokeSmall: OutfitBorderSimple,
            val strokeNormal: OutfitBorderSimple,
            val strokeBig: OutfitBorderSimple,
            val strokeHuge: OutfitBorderSimple,
            val strokeSupra: OutfitBorderSimple,
            val dialog: OutfitBorderSimple,
            val button: OutfitBorderSimple,
            val buttonOutlined: OutfitBorderSimple,
        )
        internal val localBordersSimple: ProvidableCompositionLocal<Simple> = staticCompositionLocalOf {
            error("not provided")
        }

    }




}