package com.tezov.bank.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color
import com.tezov.lib_core_android_kotlin.ui.theme.definition.ThemeColorsExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.ThemeColorsResource

object ThemeColors {
    object Data {
        val red: Color = Color(0xFFFF1200)
        val orangeLight: Color = Color(0xFFD37A73)
        val orangeGray: Color = Color(0xFFDF9C86)
        val orangeGrayLight: Color = Color(0xFFE4B8AA)
        val blueLight: Color = Color(0xFF6741BB)
        val blackLight: Color = Color(0xFF191B1B)
        val greenMelon: Color = Color(0xFF52E057)
    }

    val colorsLight = Colors(
        primary = Data.red,
        primaryVariant = Data.orangeLight,
        onPrimary = Data.blackLight,

        secondary = Data.orangeGray,
        secondaryVariant = Data.orangeGrayLight,
        onSecondary = Data.blackLight,

        surface = ThemeColorsResource.Data.white,
        onSurface = Data.blackLight,

        background = ThemeColorsResource.Data.white,
        onBackground = Data.blackLight,

        error = ThemeColorsResource.Data.red,
        onError = ThemeColorsResource.Data.whiteGrayLight,
        isLight = true
    )

    val colorsLightCommonExtended = ThemeColorsExtended.Common(
        onPrimaryLight = ThemeColorsResource.Data.gray,
        onSecondaryLight = ThemeColorsResource.Data.gray,
        onBackgroundLight = ThemeColorsResource.Data.whiteGrayDark,

        backgroundElevated = ThemeColorsResource.Data.grayVeryLight,
        onBackgroundElevated = ThemeColorsResource.Data.black,
        onBackgroundElevatedLight = ThemeColorsResource.Data.whiteGrayDark,

        backgroundModal = ThemeColorsResource.Data.whiteGrayLight,
        onBackgroundModal = ThemeColorsResource.Data.black,
        onBackgroundModalLight = ThemeColorsResource.Data.whiteGrayDark,

        backgroundButton = Data.red,
        onBackgroundButton = ThemeColorsResource.Data.white,
        onBackgroundButtonLight = ThemeColorsResource.Data.whiteGrayDark,

        topAppBarBackground = colorsLight.background,
        topAppBarContentText = colorsLight.primary,
        topAppBarContentIcon = ThemeColorsResource.Data.black,

        bottomNavigationBackground = colorsLight.background,
        bottomNavigationSelected = Data.blueLight,
        bottomNavigationUnselected = Data.blackLight,

        snackbarBackground = colorsLight.primaryVariant,
        snackbarMessage = ThemeColorsResource.Data.white,
        snackbarAction = Data.blueLight,
    )

    val colorsLightWidgetExtended = ThemeColorsExtended.Widget(
        swiperPagerIndicatorActive = ThemeColorsResource.Data.blue,
        swiperPagerIndicatorInactive = ThemeColorsResource.Data.gray,
    )
}