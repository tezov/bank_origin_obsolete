/*
 *  *********************************************************************************
 *  Created by Tezov on 05/03/2023 14:03
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 04/03/2023 22:50
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.tezov.lib_core_android_kotlin.ui.theme.style.*
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeFramesExtended

object ThemeShapes {

    @Composable
    fun provideShapes() = ThemeFramesExtended.Shapes(
        roundedCornerMicro = 4.outfitShapeSketch,
        roundedCornerSmall = 8.outfitShapeSketch,
        roundedCornerNormal = 12.outfitShapeSketch,
        roundedCornerBig = 20.outfitShapeSketch,
        roundedCornerHuge = 28.outfitShapeSketch,
        roundedCornerSupra = 40.outfitShapeSketch,
        button = OutfitShapeState(
            sketch = 14.outfitShapeSketch,
            outfitColor = OutfitColorsState(
                active = MaterialTheme.colors.primary
            )
        ),
        buttonOutlined = 24.outfitShapeState,
    )

    @Composable
    fun provideBorders() = ThemeFramesExtended.Borders(
        strokeMicro =  0.8.outfitBorderSketch,
        strokeSmall =  1.outfitBorderSketch,
        strokeNormal = 1.5.outfitBorderSketch,
        strokeBig =  2.2.outfitBorderSketch,
        strokeHuge =  4.outfitBorderSketch,
        strokeSupra =  5.5.outfitBorderSketch,
        button = OutfitBorderState(),
        buttonOutlined = OutfitBorderState(
            sketch = 2.outfitBorderSketch,
            outfitColor = OutfitColorsState(
                active = MaterialTheme.colors.primary
            ),
        ),
    )

}