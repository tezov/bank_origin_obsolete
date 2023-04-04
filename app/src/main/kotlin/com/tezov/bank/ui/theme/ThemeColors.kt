/*
 *  *********************************************************************************
 *  Created by Tezov on 04/04/2023 13:51
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 04/04/2023 13:03
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
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeColorsExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.colorsCommonExtended

object ThemeColors {
    object Resource {
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
        background = OutfitPaletteColor(
            default = Resource.whiteShiny,
            accent = Resource.blueSea,
        ),
        onBackground = OutfitPaletteColor(
            default = Resource.blueElegant,
            accent =  Resource.whiteShiny,
        ),
        backgroundElevated = OutfitPaletteColor(
            default = Resource.grayOverlay,
        ),
        onBackgroundElevated = OutfitPaletteColor(
            default = Resource.blueNight,
            accent = Resource.blueElegant,
        ),
        backgroundModal = OutfitPaletteColor(
            default = Resource.whiteShady,
            accent = Resource.blueElegant,
        ),
        onBackgroundModal = OutfitPaletteColor(
            default = Resource.blueNight,
            accent = Resource.blueElegant,
        ),
        primary = OutfitPaletteColor(
            default = Resource.whiteShady,
            accent = Resource.blueDark,
        ),
        onPrimary = OutfitPaletteColor(
            default = Resource.blueSea,
            accent = Resource.blueDark,
        ),
        secondary = OutfitPaletteColor(
            default = Resource.whiteShady,
            light = Resource.whiteDark,
        ),
        onSecondary = OutfitPaletteColor(
            default = Resource.blueNight,
        ),
        tertiary = OutfitPaletteColor(
            default = Resource.whiteShady,
            light = Resource.whiteDark,
        ),
        onTertiary = OutfitPaletteColor(
            default = Resource.blueNight,
        ),
        semantic= OutfitPaletteColorSemantic(
            error = OutfitPaletteColor(
                default = Resource.redBlood
            ),
        ),
        onSemantic= OutfitPaletteColorSemantic(
            error = OutfitPaletteColor(
                default = Resource.whiteDark
            )
        ),
    )

    @Composable
    fun providesColorsLightMaterial() =  Colors(
        primary = MaterialTheme.colorsCommonExtended.primary.default,
        primaryVariant = MaterialTheme.colorsCommonExtended.primary.accent,
        onPrimary = MaterialTheme.colorsCommonExtended.onPrimary.default,

        secondary = MaterialTheme.colorsCommonExtended.secondary.default,
        secondaryVariant = MaterialTheme.colorsCommonExtended.secondary.accent,
        onSecondary = MaterialTheme.colorsCommonExtended.onSecondary.default,

        surface = Color.Unspecified,
        onSurface = MaterialTheme.colorsCommonExtended.onBackground.default,

        background = MaterialTheme.colorsCommonExtended.background.default,
        onBackground = MaterialTheme.colorsCommonExtended.onBackground.default,

        error = MaterialTheme.colorsCommonExtended.semantic.error!!.default,
        onError = MaterialTheme.colorsCommonExtended.onSemantic.error!!.default,

        isLight = true
    )

}