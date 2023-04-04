/*
 *  *********************************************************************************
 *  Created by Tezov on 04/04/2023 12:05
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 04/04/2023 11:52
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.theme

import androidx.compose.runtime.Composable
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPaletteSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.asOutfitShapeColor
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeShapesExtended

object ThemeShapes {

    @Composable
    fun provideShapes() = ThemeShapesExtended.Common(
        roundedCorner = OutfitPaletteSize(
            micro = 4.asOutfitShapeColor,
            small = 8.asOutfitShapeColor,
            normal = 12.asOutfitShapeColor,
            big = 20.asOutfitShapeColor,
            huge = 28.asOutfitShapeColor,
            supra = 40.asOutfitShapeColor,
        )
    )

    @Composable
    fun providesButtons() = ThemeShapesExtended.Buttons(
        primary = 4.asOutfitShapeColor
    )


}