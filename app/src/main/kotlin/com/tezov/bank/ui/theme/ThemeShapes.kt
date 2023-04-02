/*
 *  *********************************************************************************
 *  Created by Tezov on 02/04/2023 16:46
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 02/04/2023 16:46
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.theme

import androidx.compose.runtime.Composable
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPalette
import com.tezov.lib_core_android_kotlin.ui.theme.style.asOutfitBorderColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.asOutfitShapeColor
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeShapesExtended

object ThemeShapes {

    @Composable
    fun provideShapes() = ThemeShapesExtended.Shapes(
        roundedCorner = OutfitPalette.Variant(
            micro = 4.asOutfitShapeColor,
            small = 8.asOutfitShapeColor,
            normal = 12.asOutfitShapeColor,
            big = 20.asOutfitShapeColor,
            huge = 28.asOutfitShapeColor,
            supra = 40.asOutfitShapeColor,
        )
    )

    @Composable
    fun provideBorders() = ThemeShapesExtended.Borders(
        stroke = OutfitPalette.Variant(
            micro = 0.8.asOutfitBorderColor,
            small = 1.asOutfitBorderColor,
            normal = 1.5.asOutfitBorderColor,
            big = 2.2.asOutfitBorderColor,
            huge = 4.asOutfitBorderColor,
            supra = 5.5.asOutfitBorderColor,
        ),
    )

}