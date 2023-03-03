/*
 *  *********************************************************************************
 *  Created by Tezov on 03/03/2023 22:33
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 03/03/2023 22:28
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.ui.theme.style.*
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeShapesExtended

object ThemeShapes {

    @Composable
    fun provideShapes() = ThemeShapesExtended.Shapes.Sketch(
        roundedCornerMicro = OutfitShapeSketch(
            size = OutfitShape.Size(4.dp)
        ),
        roundedCornerSmall = OutfitShapeSketch(
            size = OutfitShape.Size(8.dp)
        ),
        roundedCornerNormal = OutfitShapeSketch(
            size = OutfitShape.Size(12.dp)
        ),
        roundedCornerBig = OutfitShapeSketch(
            size = OutfitShape.Size(20.dp)
        ),
        roundedCornerHuge = OutfitShapeSketch(
            size = OutfitShape.Size(28.dp)
        ),
        roundedCornerSupra = OutfitShapeSketch(
            size = OutfitShape.Size(40)
        ),
    )

    @Composable
    fun provideBorders() = ThemeShapesExtended.Borders.Sketch(
        strokeMicro =  OutfitBorderSketch(
            size = 0.8.dp,
        ),
        strokeSmall =  OutfitBorderSketch(
            size = 1.dp,
        ),
        strokeNormal = OutfitBorderSketch(
            size = 1.5.dp,
        ),
        strokeBig =  OutfitBorderSketch(
            size = 2.2.dp,
        ),
        strokeHuge =  OutfitBorderSketch(
            size = 4.dp,
        ),
        strokeSupra =  OutfitBorderSketch(
            size = 5.5.dp,
        ),
        button = OutfitBorderState(
            sketch = OutfitBorderSketch(
                OutfitBorderSketch(
                    size = 2.dp,
                )
            ),
            outfitColor = OutfitColorsState(),
        ),
        buttonOutlined = OutfitBorderState(
            sketch = OutfitBorderSketch(
                OutfitBorderSketch(
                    size = 2.dp,
                )
            ),
            outfitColor = OutfitColorsState(),
        ),
    )

}