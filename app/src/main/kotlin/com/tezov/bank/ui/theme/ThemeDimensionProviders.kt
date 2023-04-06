/*
 *  *********************************************************************************
 *  Created by Tezov on 06/04/2023 12:56
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 06/04/2023 12:05
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.theme

import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.type.primaire.sizeDp
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPalette.Size.Style.Companion.asPaletteSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPaletteDirection
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPaletteSize
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeDimensionsExtended

object ThemeDimensionProviders {

    fun paddings() = ThemeDimensionsExtended.Paddings(
        page = OutfitPaletteDirection(
            vertical = 6.dp,
            horizontal = 4.dp
        ),
        block = OutfitPaletteDirection(
            vertical = OutfitPaletteSize(
                normal = 10.dp,
                micro = 4.dp,
                small = 6.dp,
                big = 12.dp,
                huge = 14.dp,
                supra = 18.dp,

                ),
            horizontal = OutfitPaletteSize(
                normal = 8.dp,
                micro = 4.dp,
                small = 6.dp,
                big = 10.dp,
                huge = 14.dp,
                supra = 18.dp,
            ),
        ),
        element = OutfitPaletteDirection(
            vertical = OutfitPaletteSize(
                normal = 4.dp,
                small = 3.dp,
                big = 6.dp,
                huge = 14.dp,
            ),
            horizontal = OutfitPaletteSize(
                normal = 3.dp,
                small = 2.dp,
                big = 6.dp,
                huge = 10.dp,
            ),
        ),
        button = OutfitPaletteDirection(
            vertical = 4.asPaletteSize,
            horizontal = 8.asPaletteSize,
        ),
    )

    fun spacings() = ThemeDimensionsExtended.Spacings(
        block = OutfitPaletteDirection(
            vertical = OutfitPaletteSize(
                normal = 6.dp,
                small = 4.dp,
                big = 10.dp,
            ),
            horizontal = OutfitPaletteSize(
                normal = 4.dp,
                small = 2.dp,
                big = 8.dp,
            ),
        ),
        element = OutfitPaletteDirection(
            vertical = OutfitPaletteSize(
                normal = 4.dp,
                small = 2.dp,
                big = 6.dp,
            ),
            horizontal = OutfitPaletteSize(
                normal = 4.dp,
                small = 2.dp,
                big = 6.dp,
            ),
        ),

        )

    fun elevations() = ThemeDimensionsExtended.Elevations(
        palette = OutfitPaletteSize(
            normal = 4.dp,
            small = 2.dp,
            big = 6.dp,
        ),
    )

    fun sizes() = ThemeDimensionsExtended.Sizes(
        iconModal = 42.sizeDp,
        iconInfo = 36.sizeDp,
        iconAction = 22.sizeDp,
        iconFieldInfo = 32.sizeDp,
        iconFieldAction = 22.sizeDp,
        divider = 1.asPaletteSize,
    )
}