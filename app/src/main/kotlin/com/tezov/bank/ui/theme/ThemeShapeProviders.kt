/*
 *  *********************************************************************************
 *  Created by Tezov on 05/04/2023 23:47
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 05/04/2023 23:47
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.theme

import androidx.compose.runtime.Composable
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPaletteSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.StateColor.Style.Companion.asShapeStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeShapesExtended

object ThemeShapeProviders {

    @Composable
    fun common() = ThemeShapesExtended.Common(
        roundedCorner = OutfitPaletteSize(
            normal = 12.asShapeStateColor,
            small = 8.asShapeStateColor,
            big = 20.asShapeStateColor,
        )
    )

    @Composable
    fun buttons() = ThemeShapesExtended.Buttons(
        primary = 4.asShapeStateColor
    )



}