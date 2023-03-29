/*
 *  *********************************************************************************
 *  Created by Tezov on 29/03/2023 22:26
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 29/03/2023 22:26
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.theme

import androidx.compose.runtime.Composable
import com.tezov.lib_core_android_kotlin.ui.theme.style.*
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeFramesExtended

object ThemeShapes {

    @Composable
    fun provideShapes() = ThemeFramesExtended.Shapes(
        roundedCornerMicro = 4.asOutfitShapeColor,
        roundedCornerSmall = 8.asOutfitShapeColor,
        roundedCornerNormal = 12.asOutfitShapeColor,
        roundedCornerBig = 20.asOutfitShapeColor,
        roundedCornerHuge = 28.asOutfitShapeColor,
        roundedCornerSupra = 40.asOutfitShapeColor,
    )

    @Composable
    fun provideBorders() = ThemeFramesExtended.Borders(
        strokeMicro =  0.8.asOutfitBorderColor,
        strokeSmall =  1.asOutfitBorderColor,
        strokeNormal = 1.5.asOutfitBorderColor,
        strokeBig =  2.2.asOutfitBorderColor,
        strokeHuge =  4.asOutfitBorderColor,
        strokeSupra =  5.5.asOutfitBorderColor,
    )

}