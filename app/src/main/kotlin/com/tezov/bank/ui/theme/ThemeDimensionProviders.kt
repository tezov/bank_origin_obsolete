/*
 *  *********************************************************************************
 *  Created by Tezov on 08/04/2023 22:36
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/04/2023 22:03
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.theme

import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.type.primaire.dpSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPalette.Direction.Style.Companion.asPaletteDirection
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
            vertical = 6.dp,
            horizontal = 4.dp
        ).asPaletteSize,
        cluster = OutfitPaletteSize(
            normal = OutfitPaletteDirection(
                vertical = 10.dp,
                horizontal = 8.dp
            ),
            small = OutfitPaletteDirection(
                vertical = 6.dp,
                horizontal = 6.dp
            ),
            big = OutfitPaletteDirection(
                vertical = 12.dp,
                horizontal = 10.dp
            )
        ),
        block = OutfitPaletteSize(
            normal = OutfitPaletteDirection(
                vertical = 8.dp,
                horizontal = 8.dp
            ),
            small = OutfitPaletteDirection(
                vertical = 6.dp,
                horizontal = 6.dp
            ),
            big = OutfitPaletteDirection(
                vertical = 10.dp,
                horizontal = 10.dp
            )
        ),
        chunk = OutfitPaletteSize(
            normal = OutfitPaletteDirection(
                vertical = 4.dp,
                horizontal = 3.dp
            ),
            small = OutfitPaletteDirection(
                vertical = 3.dp,
                horizontal = 2.dp
            ),
            big = OutfitPaletteDirection(
                vertical = 5.dp,
                horizontal = 4.dp
            )
        ),
        button = OutfitPaletteDirection(
            vertical = 6.dp,
            horizontal = 10.dp,
        ).asPaletteSize,
        text = OutfitPaletteSize(
            normal = OutfitPaletteDirection(
                vertical = 4.dp,
                horizontal = 6.dp
            ),
            small = OutfitPaletteDirection(
                vertical = 2.dp,
                horizontal = 3.dp
            ),
            big = OutfitPaletteDirection(
                vertical = 6.dp,
                horizontal = 9.dp
            )
        ),
        icon = OutfitPaletteSize(
            normal = 32.dp.asPaletteDirection,
            small = 24.dp.asPaletteDirection,
            big = 48.dp.asPaletteDirection
        )
    )

    fun icons() = ThemeDimensionsExtended.Icons(
        modal = 42.dpSize.asPaletteSize,
        info = 36.dpSize.asPaletteSize,
        action = 22.dpSize.asPaletteSize,
        fieldInfo = 32.dpSize.asPaletteSize,
        fieldAction = 22.dpSize.asPaletteSize,
    )
}