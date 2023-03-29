/*
 *  *********************************************************************************
 *  Created by Tezov on 29/03/2023 22:26
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 29/03/2023 22:26
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPaletteColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPaletteColorSemantic
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitStateDual
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeColorsExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.colorsExtended

object ThemeColors {
    object Common {
        val blueNight = Color(0xFF01252B)
        val blueElegant = Color(0xFF12263F)
        val blueSea = Color(0xFF11BAD5)
        val blueDark = Color(0xFF08465C)
        val blueShadow= Color(0xFF364C53)
        val blueClear= Color(0xFFD0E9F1)

        val redSalmon = Color(0xFFF0767E)
        val redBlood = Color(0xFFAD1720)

        val whiteShiny = Color(0xFFF0EEEE)
        val whiteDark = Color(0xFFDDDDDD)
        val whiteShady = Color(0xFFDDDADA)

        val grayDark = Color(0xFF3F3F3F)

        val purple = Color(0xFF945AC3)
        val greenFlashy = Color(0xFF2BD695)
        val pinkFlashy = Color(0xFFFF00C7)
        val blueFlashy = Color(0xFF19D9FF)

        val blueOverlay = Color(0x3400DCFF)
        val blackOverlay = Color(0xAA000000)
        val grayOverlay = Color(0x063F3F3F)
    }

    val colorsLightExtended = ThemeColorsExtended.Common(
        primary = OutfitPaletteColor(
            default = Common.whiteShady,
            accent = Common.blueDark,
        ),
        onPrimary = OutfitPaletteColor(
            default = Common.blueSea,
            accent = Common.blueDark,
        ),
        secondary = OutfitPaletteColor(
            default = Common.whiteShady,
            light = Common.whiteDark,
        ),
        onSecondary = OutfitPaletteColor(
            default = Common.blueNight,
        ),
        semantic= OutfitPaletteColorSemantic(
            error = OutfitPaletteColor(
                default = Common.redBlood
            ),
        ),
        onSemantic= OutfitPaletteColorSemantic(
            error = OutfitPaletteColor(
                default = Common.whiteDark
            )
        ),
        background = OutfitPaletteColor(
            default = Common.whiteShiny,
            accent = Common.blueSea,
        ),
        onBackground = OutfitPaletteColor(
            default = Common.blueElegant,
            accent =  Common.whiteShiny,
        ),
        backgroundElevated = OutfitPaletteColor(
            default = Common.grayOverlay,
        ),
        onBackgroundElevated = OutfitPaletteColor(
            default = Common.blueNight,
            accent = Common.blueElegant,
        ),
        backgroundModal = OutfitPaletteColor(
            default = Common.whiteShady,
            accent = Common.blueElegant,
        ),
        onBackgroundModal = OutfitPaletteColor(
            default = Common.blueNight,
            accent = Common.blueElegant,
        )
    )

    @Composable
    fun providesColorsLightMaterial() =  Colors(
        primary = MaterialTheme.colorsExtended.primary.default,
        primaryVariant = MaterialTheme.colorsExtended.primary.accent,
        onPrimary = MaterialTheme.colorsExtended.onPrimary.default,

        secondary = MaterialTheme.colorsExtended.secondary.default,
        secondaryVariant = MaterialTheme.colorsExtended.secondary.accent,
        onSecondary = MaterialTheme.colorsExtended.onSecondary.default,

        surface = Color.Unspecified,
        onSurface = MaterialTheme.colorsExtended.onBackground.default,

        background = MaterialTheme.colorsExtended.background.default,
        onBackground = MaterialTheme.colorsExtended.onBackground.default,

        error = MaterialTheme.colorsExtended.semantic.error!!.default,
        onError = MaterialTheme.colorsExtended.onSemantic.error!!.default,

        isLight = true
    )

}