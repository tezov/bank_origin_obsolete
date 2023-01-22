package com.tezov.bank.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color
import com.tezov.lib_core_android_kotlin.ui.theme.definition.ThemeColorsExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.ThemeColorsResource

object ThemeColors {
    object Data {
        val blueNight = Color(0xFF01252B)
        val blueSea = Color(0xFF11BAD5)
        val blueDark = Color(0xFF08465C)
        val blueShadow= Color(0xFF364C53)
        val blueClear= Color(0xFFD0E9F1)
        val redSalmon = Color(0xFFF0767E)
        val redBlood = Color(0xFFAD1720)

        val whiteShady = Color(0xFFDDDADA)
        val whiteDark = Color(0xFFB3B1B1)

        val purple = Color(0xFF945AC3)
        val greenFlashy = Color(0xFF2BD695)
        val pinkFlashy = Color(0xFFFF00C7)
        val blueFlashy = Color(0xFF19D9FF)
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

        background = Data.whiteShady,
        onBackground = Data.blueNight,

        error = Data.redBlood,
        onError = Data.whiteDark,
        isLight = true
    )

    val colorsLightCommonExtended = ThemeColorsExtended.Common(
        onPrimaryLight = ThemeColorsResource.Data.white,
        onSecondaryLight = Data.blueClear,
        onBackgroundLight = Data.blueShadow,

        backgroundElevated = ThemeColorsResource.Data.whiteGray,
        onBackgroundElevated = ThemeColorsResource.Data.black,
        onBackgroundElevatedLight = ThemeColorsResource.Data.black,

        backgroundModal = ThemeColorsResource.Data.white,
        onBackgroundModal = ThemeColorsResource.Data.black,
        onBackgroundModalLight = ThemeColorsResource.Data.gray,

        backgroundButtonConfirm = Data.blueSea,
        onBackgroundButtonConfirm = ThemeColorsResource.Data.white,

        backgroundButtonCancel = Data.blueShadow,
        onBackgroundButtonCancel = Data.blueNight,

        backgroundButtonProceed = ThemeColorsResource.Data.grayLight,
        onBackgroundButtonProceed = ThemeColorsResource.Data.black,

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

    val colorsLightWidgetExtended = ThemeColorsExtended.Widget(
        swiperPagerIndicatorActive = Data.blueDark,
        swiperPagerIndicatorInactive = Data.blueClear,
    )
}