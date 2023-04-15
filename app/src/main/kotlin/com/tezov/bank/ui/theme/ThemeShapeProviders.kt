/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 11:25
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 10:08
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPaletteSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.StateColor.Style.Companion.asStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeShapesExtended

object ThemeShapeProviders {

    fun common() = ThemeShapesExtended.Common(
        block = OutfitPaletteSize(
            normal = 10.dp.asStateColor,
            small = 6.dp.asStateColor,
            big = 14.dp.asStateColor,
        ),
        element = OutfitPaletteSize(
            normal = 12.dp.asStateColor,
        ),
        button = OutfitPaletteSize(
            normal = 24.dp.asStateColor,
            small = 16.dp.asStateColor,
        ),
        icon = OutfitPaletteSize(
            normal = 50.asStateColor
        )
    )




}