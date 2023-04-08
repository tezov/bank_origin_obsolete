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

import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.type.primaire.dpSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPalette.Size.Style.Companion.asPaletteSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPaletteDirection
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPaletteSize
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeDimensionsExtended

object ThemeDimensionProviders {

    fun common() = ThemeDimensionsExtended.Common(
        elevation = OutfitPaletteSize(
            normal = 4.dp,
            small = 2.dp,
            big = 6.dp,
        ),
        divider = OutfitPaletteSize(
            normal = 1.dp,
            small = 0.8.dp,
            big = 1.2.dp,
        ),
    )

    fun paddings() = ThemeDimensionsExtended.Paddings(
        page = OutfitPaletteDirection(
            vertical = 6.dp.asPaletteSize,
            horizontal = 4.dp.asPaletteSize
        ),
        cluster = OutfitPaletteDirection(
            vertical = OutfitPaletteSize(
                normal = 10.dp,
                small = 6.dp,
                big = 12.dp,
            ),
            horizontal = OutfitPaletteSize(
                normal = 8.dp,
                small = 6.dp,
                big = 10.dp,
            ),
        ),
        block = OutfitPaletteDirection(
            vertical = OutfitPaletteSize(
                normal = 8.dp,
                small = 6.dp,
                big = 10.dp,
            ),
            horizontal = OutfitPaletteSize(
                normal = 8.dp,
                small = 6.dp,
                big = 12.dp,
            ),
        ),
        chunk = OutfitPaletteDirection(
            vertical = OutfitPaletteSize(
                normal = 4.dp,
                small = 3.dp,
                big = 5.dp,
            ),
            horizontal = OutfitPaletteSize(
                normal = 3.dp,
                small = 2.dp,
                big = 4.dp,
            ),
        ),
        button = OutfitPaletteDirection(
            vertical = 6.dp.asPaletteSize,
            horizontal = 10.dp.asPaletteSize,
        ),
        text = OutfitPaletteDirection(
            vertical = OutfitPaletteSize(
                normal = 4.dp,
                small = 2.dp,
                big = 6.dp,
            ),
            horizontal = OutfitPaletteSize(
                normal = 6.dp,
                small = 3.dp,
                big = 9.dp,
            ),
        ),
        icon = OutfitPaletteDirection(
            all = OutfitPaletteSize(
                normal = 32.dp,
                small = 24.dp,
                big = 48.dp,
            ),
        ),
    )

    fun icons() = ThemeDimensionsExtended.Icons(
        modal = 42.dpSize.asPaletteSize,
        info = 36.dpSize.asPaletteSize,
        action = 22.dpSize.asPaletteSize,
        fieldInfo = 32.dpSize.asPaletteSize,
        fieldAction = 22.dpSize.asPaletteSize,
    )
}