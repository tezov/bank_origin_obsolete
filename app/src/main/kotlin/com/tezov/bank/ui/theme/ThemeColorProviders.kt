/*
 *  *********************************************************************************
 *  Created by Tezov on 23/04/2023 17:27
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 23/04/2023 15:44
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

        val whiteShiny = Color(0xFFFFFFFF)
        val whiteDark = Color(0xFFDDDDDD)
        val whiteShady = Color(0xFFE9E6E6)

        val grayBlack = Color(0xFF111010)
        val grayDark = Color(0xFF3F3F3F)
        val grayLight = Color(0xFF777777)
        val grayLightOverlay = Color(0x20B6B5B5)

        val blueDark = Color(0xFF04282E)
        val blueDarkOverlay = Color(0x99022D52)
        val blueLight = Color(0xFFF1FDFD)
        val blueElegant = Color(0xFF12263F)
        val blueShady = Color(0xFF203550)
        val blueSea = Color(0xFF0FA8C0)
        val blueShadow = Color(0xFF364C53)
        val blueShiny = Color(0xFFD0E9F1)

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
            default = Palette.whiteShiny,
            accent = Palette.blueSea,
            dark = Palette.blackOverlay,
        ),
        onBackground = OutfitPaletteColor(
            default = Palette.blueElegant,
            accent = Palette.whiteShiny,
            dark = Palette.whiteShiny,
        ),
        primary = OutfitPaletteColor(
            default = Palette.blueDark,
            accent = Palette.blueSea,
            fade = Palette.grayLight,
            shiny = Palette.blueShiny,
            shady = Palette.blueShady,
        ),
        onPrimary = OutfitPaletteColor(
            default = Palette.whiteShiny,
            accent = Palette.whiteShiny,
            fade = Palette.whiteShady,
            shiny = Palette.blueElegant,
        ),

        backgroundElevated = OutfitPaletteColor(
            default = Palette.blueLight,
            decor = Palette.blueDarkOverlay,
            overlay = Palette.grayLightOverlay,
        ),
        onBackgroundElevated = OutfitPaletteColor(
            default = Palette.blueElegant,
        ),
        backgroundModal = OutfitPaletteColor(
            default = Palette.whiteShiny,
            accent = Palette.blueSea,
        ),
        onBackgroundModal = OutfitPaletteColor(
            default = Palette.blueElegant,
            accent = Palette.blueElegant,
        ),
    )


}