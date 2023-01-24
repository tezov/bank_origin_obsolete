package com.tezov.lib_core_android_kotlin.ui.theme.definition

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit

val MaterialTheme.dimensionsFontExtended: ThemeDimensionsExtended.Fonts
    @Composable
    @ReadOnlyComposable
    get() = ThemeDimensionsExtended.localFonts.current

val MaterialTheme.dimensionsPaddingExtended: ThemeDimensionsExtended.Paddings
    @Composable
    @ReadOnlyComposable
    get() = ThemeDimensionsExtended.localPaddings.current

val MaterialTheme.dimensionsSpacingExtended: ThemeDimensionsExtended.Spacings
    @Composable
    @ReadOnlyComposable
    get() = ThemeDimensionsExtended.localSpacings.current

val MaterialTheme.dimensionsElevationExtended: ThemeDimensionsExtended.Elevations
    @Composable
    @ReadOnlyComposable
    get() = ThemeDimensionsExtended.localElevations.current

object ThemeDimensionsExtended{
    @Immutable
    data class Fonts(
        val textTitle: TextUnit,
        val textSubtitle: TextUnit,
        val textHelper: TextUnit,
        val textSupra: TextUnit,
        val textHuge: TextUnit,
        val textBig: TextUnit,
        val textNormal: TextUnit,
        val textSmall: TextUnit,
        val textMicro: TextUnit,
        val textField: TextUnit,
        val textLink: TextUnit,
        val textButton: TextUnit,
        val textButtonOutlined: TextUnit,
        val bottomNavigation: TextUnit,
        val topNavigation: TextUnit,
        val snackBarMessage: TextUnit,
        val snackBarAction: TextUnit,
    )
    val localFonts: ProvidableCompositionLocal<Fonts> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class Paddings(
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
    val localPaddings: ProvidableCompositionLocal<Paddings> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class Spacings(
        val micro_v:Dp,
        val small_v:Dp,
        val normal_v:Dp,
        val big_v:Dp,
        val huge_v:Dp,
        val micro_h:Dp,
        val small_h:Dp,
        val normal_h:Dp,
        val big_h:Dp,
        val huge_h:Dp,

    )
    val localSpacings: ProvidableCompositionLocal<Spacings> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class Elevations(
        val elevationBig: Dp,
        val elevationNormal: Dp,
        val elevationSmall: Dp,
        )
    val localElevations: ProvidableCompositionLocal<Elevations> = staticCompositionLocalOf {
        error("not provided")
    }

}


