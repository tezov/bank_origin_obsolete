/*
 *  *********************************************************************************
 *  Created by Tezov on 26/02/2023 16:10
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 26/02/2023 15:25
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
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorderSimple
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShapeSimple
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeShapesExtended

object ThemeShapes {

    @Composable
    fun provideShapes() = ThemeShapesExtended.Shapes.Simple(
        roundedCornerMicro = OutfitShapeSimple(
            size = OutfitShape.Size(4.dp)
        ),
        roundedCornerSmall = OutfitShapeSimple(
            size = OutfitShape.Size(8.dp)
        ),
        roundedCornerNormal = OutfitShapeSimple(
            size = OutfitShape.Size(12.dp)
        ),
        roundedCornerBig = OutfitShapeSimple(
            size = OutfitShape.Size(20.dp)
        ),
        roundedCornerHuge = OutfitShapeSimple(
            size = OutfitShape.Size(28.dp)
        ),
        roundedCornerSupra = OutfitShapeSimple(
            size = OutfitShape.Size(40)
        ),
        dialog = OutfitShapeSimple(
            size = OutfitShape.Size(8.dp)
        ),
        snackbar = OutfitShapeSimple(
            size = OutfitShape.Size(12.dp)
        ),
        bottomSheet = OutfitShapeSimple(
            size = OutfitShape.Size(topStart = 10.dp, topEnd = 10.dp)
        ),
    )

    @Composable
    fun provideBorders() = ThemeShapesExtended.Borders.Simple(
        strokeMicro =  OutfitBorderSimple(
            size = 0.8.dp,
            color = MaterialTheme.colors.primary
        ),
        strokeSmall =  OutfitBorderSimple(
            size = 1.dp,
            color = MaterialTheme.colors.primary
        ),
        strokeNormal = OutfitBorderSimple(
            size = 1.5.dp,
            color = MaterialTheme.colors.primary
        ),
        strokeBig =  OutfitBorderSimple(
            size = 2.2.dp,
            color = MaterialTheme.colors.primary
        ),
        strokeHuge =  OutfitBorderSimple(
            size = 4.dp,
            color = MaterialTheme.colors.primary
        ),
        strokeSupra =  OutfitBorderSimple(
            size = 5.5.dp,
            color = MaterialTheme.colors.primary
        ),
        dialog =  OutfitBorderSimple(
            size = 2.dp,
            color = MaterialTheme.colors.primary
        ),
        button = OutfitBorderSimple(
            size = 2.dp,
            color = MaterialTheme.colors.primary
        ),
        buttonOutlined = OutfitBorderSimple(
            size = 2.dp,
            color = MaterialTheme.colors.primary
        ),
    )

}