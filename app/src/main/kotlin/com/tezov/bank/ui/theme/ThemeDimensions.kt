/*
 *  *********************************************************************************
 *  Created by Tezov on 01/04/2023 21:02
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 01/04/2023 20:46
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.theme

import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.type.primaire.sizeDp
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPalette
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeDimensionsExtended

object ThemeDimensions {

    val dimensionsPaddingExtended = ThemeDimensionsExtended.Paddings(
        page = OutfitPalette.Direction(
            vertical = 6.dp,
            horizontal = 4.dp
        ),
        block = OutfitPalette.Direction(
            vertical = OutfitPalette.Variant(
                micro = 4.dp,
                small = 6.dp,
                normal = 10.dp,
                big = 12.dp,
                huge = 14.dp,
                supra = 18.dp,

                ),
            horizontal = OutfitPalette.Variant(
                micro = 4.dp,
                small = 6.dp,
                normal = 8.dp,
                big = 10.dp,
                huge = 14.dp,
                supra = 18.dp,
            ),
        ),
        element = OutfitPalette.Direction(
            vertical = OutfitPalette.Variant(
                micro = 2.dp,
                small = 3.dp,
                normal = 4.dp,
                big = 6.dp,
                huge = 14.dp,
                supra = 18.dp,
            ),
            horizontal = OutfitPalette.Variant(
                micro = 1.dp,
                small = 2.dp,
                normal = 3.dp,
                big = 6.dp,
                huge = 10.dp,
                supra = 16.dp,
            ),
        ),

        text = OutfitPalette.Direction(
            vertical = OutfitPalette.Variant(
                micro = 1.dp,
                small = 2.dp,
                normal = 4.dp,
                big = 6.dp,
                huge = 8.dp,
                supra = 10.dp,
            ),
            horizontal = OutfitPalette.Variant(
                micro = 1.dp,
                small = 2.dp,
                normal = 4.dp,
                big = 6.dp,
                huge = 8.dp,
                supra = 10.dp,
            ),
        ),
    )

    val dimensionsSpacingExtended = ThemeDimensionsExtended.Spacings(
        element = OutfitPalette.Direction(
            vertical = OutfitPalette.Variant(
                micro = 1.dp,
                small = 2.dp,
                normal = 4.dp,
                big = 6.dp,
                huge = 8.dp,
                supra = 10.dp,
            ),
            horizontal = OutfitPalette.Variant(
                micro = 1.dp,
                small = 2.dp,
                normal = 4.dp,
                big = 6.dp,
                huge = 8.dp,
                supra = 10.dp,
            ),
        ),
        block = OutfitPalette.Direction(
            vertical = OutfitPalette.Variant(
                micro = 1.dp,
                small = 2.dp,
                normal = 4.dp,
                big = 6.dp,
                huge = 8.dp,
                supra = 10.dp,
            ),
            horizontal = OutfitPalette.Variant(
                micro = 1.dp,
                small = 2.dp,
                normal = 4.dp,
                big = 6.dp,
                huge = 8.dp,
                supra = 10.dp,
            ),

        )
    )

    val dimensionsElevationExtended = ThemeDimensionsExtended.Elevations(
        elevation = OutfitPalette.Variant(
            micro = 1.dp,
            small = 2.dp,
            normal = 4.dp,
            big = 6.dp,
            huge = 8.dp,
            supra = 10.dp,
        ),
    )

    val dimensionsSizeExtended = ThemeDimensionsExtended.Sizes(
        iconModal = 42.sizeDp,
        iconInfo = 36.sizeDp,
        iconAction = 22.sizeDp,
        iconFieldInfo = 32.sizeDp,
        iconFieldAction = 22.sizeDp,
        divider = OutfitPalette.Variant(
            micro = 1.dp,
            small = 2.dp,
            normal = 4.dp,
            big = 6.dp,
            huge = 8.dp,
            supra = 10.dp,
        ),
    )
}