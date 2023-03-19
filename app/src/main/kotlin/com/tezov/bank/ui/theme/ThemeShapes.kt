/*
 *  *********************************************************************************
 *  Created by Tezov on 19/03/2023 22:02
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 19/03/2023 20:59
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
        roundedCornerMicro = 4.outfitShapeColor,
        roundedCornerSmall = 8.outfitShapeColor,
        roundedCornerNormal = 12.outfitShapeColor,
        roundedCornerBig = 20.outfitShapeColor,
        roundedCornerHuge = 28.outfitShapeColor,
        roundedCornerSupra = 40.outfitShapeColor,
    )

    @Composable
    fun provideBorders() = ThemeFramesExtended.Borders(
        strokeMicro =  0.8.outfitBorderColor,
        strokeSmall =  1.outfitBorderColor,
        strokeNormal = 1.5.outfitBorderColor,
        strokeBig =  2.2.outfitBorderColor,
        strokeHuge =  4.outfitBorderColor,
        strokeSupra =  5.5.outfitBorderColor,
    )

}