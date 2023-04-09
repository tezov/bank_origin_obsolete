/*
 *  *********************************************************************************
 *  Created by Tezov on 09/04/2023 15:37
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 09/04/2023 14:25
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorder.StateColor.Style.Companion.asPaletteSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorder.StateColor.Style.Companion.asStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPaletteSize
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeBordersExtended

object ThemeBorderProviders {

    fun common() = ThemeBordersExtended.Common(
        cluster = 1.2.dp.asStateColor.asPaletteSize,
        block = 1.dp.asStateColor.asPaletteSize,
        chunk = 0.8.dp.asStateColor.asPaletteSize,
        button = OutfitPaletteSize(
            normal = 0.8.dp.asStateColor,
            big = 2.5.dp.asStateColor,
        ),
        icon = OutfitPaletteSize(
            normal = 2.5.dp.asStateColor,
        ),
    )



}