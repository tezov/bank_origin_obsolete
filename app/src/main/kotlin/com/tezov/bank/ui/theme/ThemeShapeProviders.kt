/*
 *  *********************************************************************************
 *  Created by Tezov on 08/04/2023 15:32
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/04/2023 15:06
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
        cluster = OutfitPaletteSize(
            normal = 6.dp.asStateColor,
            small = 4.dp.asStateColor,
            big = 8.dp.asStateColor,
        ),
        block = OutfitPaletteSize(
            normal = 10.dp.asStateColor,
            small = 6.dp.asStateColor,
            big = 14.dp.asStateColor,
        ),
        chunk = OutfitPaletteSize(
            normal = 8.dp.asStateColor,
            small = 6.dp.asStateColor,
            big = 10.dp.asStateColor,
        ),
        button = OutfitPaletteSize(
            normal = 12.dp.asStateColor,
            small = 8.dp.asStateColor,
            big = 20.dp.asStateColor,
        ),
        icon = OutfitPaletteSize(
            normal = 50.asStateColor,
            small = 35.asStateColor,
            micro = 15.asStateColor,
        )
    )




}