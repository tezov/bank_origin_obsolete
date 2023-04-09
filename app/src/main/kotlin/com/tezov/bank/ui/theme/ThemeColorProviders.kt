/*
 *  *********************************************************************************
 *  Created by Tezov on 10/04/2023 00:50
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 10/04/2023 00:39
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

        val blackOverlay = Color(0xAA000000)

        val whiteShiny = Color(0xFFF0EEEE)
        val whiteDark = Color(0xFFDDDDDD)
        val whiteShady = Color(0xFFDDDADA)

        val grayBlack = Color(0xFF111010)
        val grayDark = Color(0xFF3F3F3F)
        val grayLight = Color(0xFF777777)
        val grayLightOverlay = Color(0x70B6B5B5)

        val blueDark = Color(0xFF011518)
        val blueDarkOverlay = Color(0x34011518)
        val blueElegant = Color(0xFF12263F)
        val blueSea = Color(0xFF0FA8C0)
        val blueShadow= Color(0xFF364C53)
        val blueShiny= Color(0xFFD0E9F1)

        val purple = Color(0xFF945AC3)
        val greenFlashy = Color(0xFF2BD695)
        val pinkFlashy = Color(0xFFFF00C7)
        val blueFlashy = Color(0xFF19D9FF)
        val redSalmon = Color(0xFFF0767E)
        val redBlood = Color(0xFFAD1720)

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
            default = Palette.blueDark,
            accent = Palette.blueSea,
            fade = Palette.grayLight,
            shiny = Palette.blueShiny,
        ),
        onPrimary = OutfitPaletteColor(
            default = Palette.whiteShiny,
            accent = Palette.whiteShiny,
            fade = Palette.grayBlack,
            shiny = Palette.blueElegant,
        ),

        backgroundElevated = OutfitPaletteColor(
            default = Palette.grayLightOverlay,
        ),
        onBackgroundElevated = OutfitPaletteColor(
            default = Palette.blueElegant,
        ),
    )



}