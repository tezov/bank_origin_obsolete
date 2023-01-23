package com.tezov.bank.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color
import com.tezov.lib_core_android_kotlin.ui.theme.definition.ThemeColorsExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.ThemeColorsResource

object ThemeColors {
    object Data {
        val blueNight = Color(0xFF01252B)
        val blueElegant = Color(0xFF12263F)
        val blueSea = Color(0xFF11BAD5)
        val blueDark = Color(0xFF08465C)
        val blueShadow= Color(0xFF364C53)
        val blueClear= Color(0xFFD0E9F1)
        val redSalmon = Color(0xFFF0767E)
        val redBlood = Color(0xFFAD1720)

        val whiteShiny = Color(0xFFF0EEEE)
        val whiteDark = Color(0xFFAAA9A9)
        val whiteShady = Color(0xFFDDDADA)

        val grayDark = Color(0xFF3F3F3F)

        val purple = Color(0xFF945AC3)
        val greenFlashy = Color(0xFF2BD695)
        val pinkFlashy = Color(0xFFFF00C7)
        val blueFlashy = Color(0xFF19D9FF)

        val blueOverlay = Color(0x3400DCFF)
        val blackOverlay = Color(0xAA000000)
    }

    val colorsLight = Colors(
        primary = Data.blueSea,
        primaryVariant = Data.blueDark,
        onPrimary = Data.whiteShady,

        secondary = Data.whiteShady,
        secondaryVariant = Data.whiteDark,
        onSecondary = Data.blueNight,

        surface = Data.whiteShady,
        onSurface = Data.blueNight,

        background = Data.whiteShiny,
        onBackground = Data.blueElegant,

        error = Data.redBlood,
        onError = Data.whiteDark,
        isLight = true
    )

    val colorsLightCommonExtended = ThemeColorsExtended.Common(
        onPrimaryLight = Data.whiteShiny,
        onSecondaryLight = Data.blueClear,
        onBackgroundLight = Data.blueShadow,

        backgroundElevated = Data.whiteShady,
        onBackgroundElevated = Data.blueNight,
        onBackgroundElevatedLight = Data.blueElegant,

        backgroundModal = Data.whiteShady,
        onBackgroundModal = Data.blueNight,
        onBackgroundModalLight = Data.blueElegant,

        backgroundInactive = Data.blueClear,
        onBackgroundInactive = Data.grayDark,

        backgroundButtonConfirm = Data.blueElegant,
        backgroundButtonConfirmInactive = Data.whiteDark,
        onBackgroundButtonConfirm = Data.whiteShiny,
        onBackgroundButtonConfirmInactive = Data.grayDark,

        backgroundButtonCancel = Data.blueClear,
        backgroundButtonCancelInactive = Data.whiteDark,
        onBackgroundButtonCancel = Data.blueElegant,
        onBackgroundButtonCancelInactive = Data.grayDark,

        backgroundButtonProceed = Data.whiteShiny,
        backgroundButtonProceedInactive = Data.whiteDark,
        onBackgroundButtonProceed = Data.blueNight,
        onBackgroundButtonProceedInactive = Data.grayDark,

        topAppBarBackground = colorsLight.background,
        topAppBarContentText = colorsLight.primary,
        topAppBarContentIcon = ThemeColorsResource.Data.black,

        bottomNavigationBackground = colorsLight.background,
        bottomNavigationActive = Data.blueSea,
        bottomNavigationInactive = ThemeColorsResource.Data.grayLight,

        snackbarBackground = colorsLight.primaryVariant,
        snackbarMessage = ThemeColorsResource.Data.white,
        snackbarAction = Data.blueSea,
    )
}