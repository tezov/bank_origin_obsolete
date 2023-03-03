/*
 *  *********************************************************************************
 *  Created by Tezov on 03/03/2023 22:33
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 03/03/2023 22:28
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitColorsState
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeColorsExtended

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

    val colorsLight = Colors(
        primary = Common.blueSea,
        primaryVariant = Common.blueDark,
        onPrimary = Common.whiteShady,

        secondary = Common.whiteShady,
        secondaryVariant = Common.whiteDark,
        onSecondary = Common.blueNight,

        surface = Color.Transparent,
        onSurface = Common.blueElegant,

        background = Common.whiteShiny,
        onBackground = Common.blueElegant,

        error = Common.redBlood,
        onError = Common.whiteDark,
        isLight = true
    )

    val colorsLightCommonExtended = ThemeColorsExtended.Common(
        onPrimaryVariant = Common.whiteShiny,
        onSecondaryVariant = Common.blueClear,

        background = Common.blueClear,
        backgroundVariant = Common.blueSea,
        onBackgroundVariant = Common.whiteShiny,

        backgroundElevated = Common.grayOverlay,
        onBackgroundElevated = Common.blueNight,
        onBackgroundElevatedVariant = Common.blueElegant,

        backgroundModal = Common.whiteShady,
        onBackgroundModal = Common.blueNight,
        onBackgroundModalVariant = Common.blueElegant,

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
        ),
        backgroundButtonProceed = OutfitColorsState(
            active = Common.whiteShiny,
            inactive = Common.whiteDark
        ),
        onBackgroundButtonProceed = OutfitColorsState(
            active = Common.blueNight,
            inactive = Common.grayDark
        ),

    )
}