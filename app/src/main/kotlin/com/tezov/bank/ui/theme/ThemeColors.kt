/*
 *  *********************************************************************************
 *  Created by Tezov on 05/03/2023 17:17
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 05/03/2023 14:12
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
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitColorsPalette
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitColorsSemantic
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitColorsState
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
        primary = OutfitColorsPalette(
            default = Common.whiteShady,
            accent = Common.blueDark,
        ),
        onPrimary = OutfitColorsPalette(
            default = Common.blueSea,
            accent = Common.blueDark,
        ),
        secondary = OutfitColorsPalette(
            default = Common.whiteShady,
            light = Common.whiteDark,
        ),
        onSecondary = OutfitColorsPalette(
            default = Common.blueNight,
        ),
        semantic= OutfitColorsSemantic(
            error = Common.redBlood
        ),
        onSemantic= OutfitColorsSemantic(
            error = Common.whiteDark
        ),
        background = OutfitColorsPalette(
            default = Common.whiteShiny,
            accent = Common.blueSea,
        ),
        onBackground = OutfitColorsPalette(
            default = Common.blueElegant,
            accent =  Common.whiteShiny,
        ),
        backgroundElevated = OutfitColorsPalette(
            default = Common.grayOverlay,
        ),
        onBackgroundElevated = OutfitColorsPalette(
            default = Common.blueNight,
            accent = Common.blueElegant,
        ),
        backgroundModal = OutfitColorsPalette(
            default = Common.whiteShady,
            accent = Common.blueElegant,
        ),
        onBackgroundModal = OutfitColorsPalette(
            default = Common.blueNight,
            accent = Common.blueElegant,
        ),
        backgroundButtonProceed = OutfitColorsState(
            active = Common.whiteShiny,
            inactive = Common.whiteDark
        ),
        onBackgroundButtonProceed = OutfitColorsState(
            active = Common.blueNight,
            inactive = Common.grayDark
        ),
        backgroundButtonConfirm = OutfitColorsState(
            active = Common.blueElegant,
            inactive = Common.whiteDark
        ),
        onBackgroundButtonConfirm = OutfitColorsState(
            active = Common.whiteShiny,
            inactive = Common.grayDark
        ),
        backgroundButtonCancel = OutfitColorsState(
            active = Common.blueShadow,
            inactive = Common.whiteDark
        ),
        onBackgroundButtonCancel = OutfitColorsState(
            active = Common.blueElegant,
            inactive = Common.grayDark
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

        error = MaterialTheme.colorsExtended.semantic.error,
        onError = MaterialTheme.colorsExtended.onSemantic.error,

        isLight = true
    )

}