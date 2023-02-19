/*
 *  *********************************************************************************
 *  Created by Tezov on 19/02/2023 20:50
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 19/02/2023 20:30
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorderSimple
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShapeSimple
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeShapesExtended

object ThemeShapes {

    @Composable
    fun provideShapes() = ThemeShapesExtended.Shapes(
        roundedCornerHuge = OutfitShapeSimple(
            size = CornerSize(28.dp)
        ),
        roundedCornerBig = OutfitShapeSimple(
            size = CornerSize(20.dp)
        ),
        roundedCornerNormal = OutfitShapeSimple(
            size = CornerSize(12.dp)
        ),
        roundedCornerSmall = OutfitShapeSimple(
            size = CornerSize(8.dp)
        ),
        roundedCornerMicro = OutfitShapeSimple(
            size = CornerSize(4.dp)
        ),
        dialog = OutfitShapeSimple(
            size = CornerSize(8.dp)
        ),
        snackbar = OutfitShapeSimple(
            size = CornerSize(12.dp)
        ),
        bottomSheet = OutfitShapeSimple(
//            size = CornerSize(topStart = 10.dp, topEnd = 10.dp) RoundedCornerShape
        ),
    )

    @Composable
    fun provideBorders() = ThemeShapesExtended.Borders(
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