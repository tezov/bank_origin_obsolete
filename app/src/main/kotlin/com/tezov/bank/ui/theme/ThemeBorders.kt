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
import com.tezov.lib_core_android_kotlin.ui.theme.style.asOutfitBorderColor
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeBordersExtended

object ThemeBorders {

    @Composable
    fun provideBorders() = ThemeBordersExtended.Common(
        stroke = OutfitPaletteSize(
            micro = 0.8.asOutfitBorderColor,
            small = 1.asOutfitBorderColor,
            normal = 1.5.asOutfitBorderColor,
            big = 2.2.asOutfitBorderColor,
            huge = 4.asOutfitBorderColor,
            supra = 5.5.asOutfitBorderColor,
        ),
    )

    @Composable
    fun providesButtons() = ThemeBordersExtended.Buttons(
        primary = 2.asOutfitBorderColor
    )

}