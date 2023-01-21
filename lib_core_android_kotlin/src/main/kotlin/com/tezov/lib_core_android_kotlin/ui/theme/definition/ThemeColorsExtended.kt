package com.tezov.lib_core_android_kotlin.ui.theme.definition

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

val MaterialTheme.colorsCommonExtended: ThemeColorsExtended.Common
    @Composable
    @ReadOnlyComposable
    get() = ThemeColorsExtended.localCommon.current

val MaterialTheme.colorsWidgetExtended: ThemeColorsExtended.Widget
    @Composable
    @ReadOnlyComposable
    get() = ThemeColorsExtended.localWidget.current

object ThemeColorsExtended {
    @Immutable
    data class Common(
        val onPrimaryLight :Color,
        val onSecondaryLight :Color,
        val onBackgroundLight :Color,

        val backgroundElevated: Color,
        val onBackgroundElevated: Color,
        val onBackgroundElevatedLight:Color,

        val backgroundModal: Color,
        val onBackgroundModal: Color,
        val onBackgroundModalLight:Color,

        val backgroundButton: Color,
        val onBackgroundButton: Color,
        val onBackgroundButtonLight:Color,

        val topAppBarBackground: Color,
        val topAppBarContentText: Color,
        val topAppBarContentIcon: Color,

        val bottomNavigationBackground: Color,
        val bottomNavigationSelected: Color,
        val bottomNavigationUnselected: Color,

        val snackbarBackground: Color,
        val snackbarMessage: Color,
        val snackbarAction: Color,
    )
    val localCommon:ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class Widget(
        val swiperPagerIndicatorActive: Color,
        val swiperPagerIndicatorInactive: Color,
    )
    val localWidget: ProvidableCompositionLocal<Widget> = staticCompositionLocalOf {
        error("not provided")
    }

}




