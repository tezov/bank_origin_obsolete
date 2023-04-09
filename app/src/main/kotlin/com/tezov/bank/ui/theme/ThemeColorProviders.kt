/*
 *  *********************************************************************************
 *  Created by Tezov on 09/04/2023 15:37
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 09/04/2023 14:49
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPaletteColor
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeColorsExtended

val MaterialTheme.colorsPalette
    @Composable
    @ReadOnlyComposable
    get() = ThemeColorProviders.localPalette.current

object ThemeColorProviders {

    object Palette {
        val blueNight = Color(0xFF01252B)
        val blueElegant = Color(0xFF12263F)
        val blueSea = Color(0xFF11BAD5)
        val blueDark = Color(0xFF08465C)
        val blueShadow= Color(0xFF364C53)
        val blueClear= Color(0xFFD0E9F1)
        val blueOverlay = Color(0x3400DCFF)

        val redSalmon = Color(0xFFF0767E)
        val redBlood = Color(0xFFAD1720)

        val whiteShiny = Color(0xFFF0EEEE)
        val whiteDark = Color(0xFFDDDDDD)
        val whiteShady = Color(0xFFDDDADA)

        val grayBlack = Color(0xFF111010)
        val grayDark = Color(0xFF3F3F3F)
        val grayLight = Color(0xFF696969)
        val grayOverlay = Color(0x063F3F3F)

        val purple = Color(0xFF945AC3)
        val greenFlashy = Color(0xFF2BD695)
        val pinkFlashy = Color(0xFFFF00C7)
        val blueFlashy = Color(0xFF19D9FF)


        val blackOverlay = Color(0xAA000000)

    }

    internal val localPalette = staticCompositionLocalOf { Palette }

    fun common() = ThemeColorsExtended.Common(
        background = OutfitPaletteColor(
            default = Palette.whiteDark,
            accent = Palette.blueSea,
        ),
        onBackground = OutfitPaletteColor(
            default = Palette.blueElegant,
            accent =  Palette.whiteShiny,
        ),
        primary = OutfitPaletteColor(
            default = Palette.blueNight,
            fade = Palette.grayLight,
            shiny = Palette.whiteShiny,
        ),
        onPrimary = OutfitPaletteColor(
            default = Palette.whiteShiny,
            fade = Palette.grayBlack,
            shiny = Palette.blueNight,
        ),

        backgroundElevated = OutfitPaletteColor(
            default = Palette.grayOverlay,
        ),
        onBackgroundElevated = OutfitPaletteColor(
            default = Palette.blueElegant,
        ),
    )



}