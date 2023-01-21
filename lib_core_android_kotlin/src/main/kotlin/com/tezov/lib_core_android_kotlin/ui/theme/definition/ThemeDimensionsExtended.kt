package com.tezov.lib_core_android_kotlin.ui.theme.definition

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit

val MaterialTheme.dimensionsFontExtended: ThemeDimensionsExtended.Font
    @Composable
    @ReadOnlyComposable
    get() = ThemeDimensionsExtended.localFont.current

val MaterialTheme.dimensionsPaddingExtended: ThemeDimensionsExtended.Padding
    @Composable
    @ReadOnlyComposable
    get() = ThemeDimensionsExtended.localPadding.current

val MaterialTheme.dimensionsElevationExtended: ThemeDimensionsExtended.Elevation
    @Composable
    @ReadOnlyComposable
    get() = ThemeDimensionsExtended.localElevation.current

val MaterialTheme.dimensionsWidgetExtended: ThemeDimensionsExtended.Widget
    @Composable
    @ReadOnlyComposable
    get() = ThemeDimensionsExtended.localWidget.current

object ThemeDimensionsExtended{
    @Immutable
    data class Font(
        val textTitle: TextUnit,
        val textSubtitle: TextUnit,
        val textHelper: TextUnit,
        val textHuge: TextUnit,
        val textBig: TextUnit,
        val textNormal: TextUnit,
        val textSmall: TextUnit,
        val textMicro: TextUnit,
        val textField: TextUnit,
        val textLink: TextUnit,
        val textButton: TextUnit,
        val textButton_icon: TextUnit,
        val bottomNavigation: TextUnit,
        val topNavigation: TextUnit,
        val snackBarMessage: TextUnit,
        val snackBarAction: TextUnit,
    )
    val localFont: ProvidableCompositionLocal<Font> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class Padding(
        val screen_h: Dp,
        val screen_v: Dp,
        val elementHuge_v: Dp,
        val elementBig_v: Dp,
        val elementNormal_v: Dp,
        val elementSmall_v: Dp,
        val elementMicro_v: Dp,
        val elementHuge_h: Dp,
        val elementBig_h: Dp,
        val elementNormal_h: Dp,
        val elementSmall_h: Dp,
        val elementMicro_h: Dp,
        val textBig_v: Dp,
        val textNormal_v: Dp,
        val textSmall_v: Dp,
        val textBig_h: Dp,
        val textNormal_h: Dp,
        val textSmall_h: Dp,
        val buttonBig_v: Dp,
        val buttonNormal_v: Dp,
        val buttonSmall_v: Dp,
        val buttonBig_h: Dp,
        val buttonNormal_h: Dp,
        val buttonSmall_h: Dp,
        val blockBig_v: Dp,
        val blockNormal_v: Dp,
        val blockSmall_v: Dp,
        val blockBig_h: Dp,
        val blockNormal_h: Dp,
        val blockSmall_h: Dp,
        val bottomNavigation: Dp,
        val topNavigation: Dp
    )
    val localPadding: ProvidableCompositionLocal<Padding> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class Elevation(
        val elevationBig: Dp,
        val elevationNormal: Dp,
        val elevationSmall: Dp,
        )
    val localElevation: ProvidableCompositionLocal<Elevation> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class Widget(
        val swiperPagerIndicatorSizeNormal: Dp,
        val swiperPagerIndicatorSpacingNormal: Dp,
    )
    val localWidget: ProvidableCompositionLocal<Widget> = staticCompositionLocalOf {
        error("not provided")
    }
}


