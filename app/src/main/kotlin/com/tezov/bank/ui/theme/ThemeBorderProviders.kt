/*
 *  *********************************************************************************
 *  Created by Tezov on 06/04/2023 23:14
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 06/04/2023 23:14
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.theme

import androidx.compose.runtime.Composable
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPaletteSize
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeBordersExtended

object ThemeBorderProviders {

    @Composable
    fun common() = ThemeBordersExtended.Common(
        stroke = OutfitPaletteSize(
            normal = 1.5.asBorderStateColor,
            micro = 0.8.asBorderStateColor,
            small = 1.asBorderStateColor,
            big = 2.2.asBorderStateColor,
            huge = 4.asBorderStateColor,
        ),
    )

    @Composable
    fun buttons() = ThemeBordersExtended.Buttons(
        primary = 2.asBorderStateColor
    )

}