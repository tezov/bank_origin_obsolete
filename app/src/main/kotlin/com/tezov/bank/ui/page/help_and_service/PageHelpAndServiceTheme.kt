package com.tezov.bank.ui.page.help_and_service

import androidx.compose.foundation.BorderStroke
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.bank.ui.theme.ThemeColors
import com.tezov.lib_core_android_kotlin.ui.theme.definition.*

val PageHelpAndServiceTheme.colors: PageHelpAndServiceTheme.Colors
    @Composable
    @ReadOnlyComposable
    get() = PageHelpAndServiceTheme.localColors.current
infix fun PageHelpAndServiceTheme.provides(value: PageHelpAndServiceTheme.Colors) = PageHelpAndServiceTheme.localColors provides value

val PageHelpAndServiceTheme.dimensions: PageHelpAndServiceTheme.Dimensions
    @Composable
    @ReadOnlyComposable
    get() = PageHelpAndServiceTheme.localDimensions.current
infix fun PageHelpAndServiceTheme.provides(value: PageHelpAndServiceTheme.Dimensions) = PageHelpAndServiceTheme.localDimensions provides value

val PageHelpAndServiceTheme.shapes: PageHelpAndServiceTheme.Shapes
    @Composable
    @ReadOnlyComposable
    get() = PageHelpAndServiceTheme.localShapes.current
infix fun PageHelpAndServiceTheme.provides(value: PageHelpAndServiceTheme.Shapes) = PageHelpAndServiceTheme.localShapes provides value

val PageHelpAndServiceTheme.borders: PageHelpAndServiceTheme.Borders
    @Composable
    @ReadOnlyComposable
    get() = PageHelpAndServiceTheme.localBorders.current
infix fun PageHelpAndServiceTheme.provides(value: PageHelpAndServiceTheme.Borders) = PageHelpAndServiceTheme.localBorders provides value

val PageHelpAndServiceTheme.typographies: PageHelpAndServiceTheme.Typographies
    @Composable
    @ReadOnlyComposable
    get() = PageHelpAndServiceTheme.localTypographies.current
infix fun PageHelpAndServiceTheme.provides(value: PageHelpAndServiceTheme.Typographies) = PageHelpAndServiceTheme.localTypographies provides value

object PageHelpAndServiceTheme {

    data class Colors(
        val background: Color,
        val backgroundSection: Color,
        val onBackgroundLight: Color,
        val onBackgroundDark: Color,
        val icon: Color,
    )

    @Composable
    fun provideColors() = Colors(
        background = MaterialTheme.colors.background,
        backgroundSection = ThemeColors.Data.whiteDark,
        onBackgroundLight = MaterialTheme.colors.primary,
        onBackgroundDark = MaterialTheme.colors.onSecondary,
        icon = MaterialTheme.colors.primary,
    )

    internal val localColors: ProvidableCompositionLocal<Colors> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Dimensions(
        val iconCloseSize: Dp,
        val iconCardSize: Dp,
        val iconRowSize: Dp,
        val iconChevronSize: Dp,
    )

    @Composable
    fun provideDimensions() = Dimensions(
        iconCloseSize = MaterialTheme.dimensionsSizeExtended.iconModal,
        iconCardSize = 48.dp,
        iconRowSize = 32.dp,
        iconChevronSize = 24.dp,
    )

    internal val localDimensions: ProvidableCompositionLocal<Dimensions> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Shapes(
        val card: Shape,
    )

    @Composable
    fun provideShapes() = Shapes(
        card = MaterialTheme.shapesExtended.cardNormal,
    )

    internal val localShapes: ProvidableCompositionLocal<Shapes> = staticCompositionLocalOf {
        error("not provided")
    }


    data class Borders(
        val card: BorderStroke,

    )

    @Composable
    fun provideBorders() = Borders(
        card = BorderStroke(
            1.dp,
            ThemeColors.Data.grayDark
        ),
    )

    internal val localBorders: ProvidableCompositionLocal<Borders> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Typographies(
        val titleBig: TextStyle,
        val titleNormal: TextStyle,
        val text: TextStyle,
    )

    @Composable
    fun provideTypographies() = Typographies(
        titleBig = MaterialTheme.typographyExtended.textHuge.copy(
            color = colors.onBackgroundDark,
            fontWeight = FontWeight.Bold
        ),
        titleNormal = MaterialTheme.typographyExtended.textNormal.copy(
            color = ThemeColors.Data.grayDark,
            fontWeight = FontWeight.SemiBold
        ),
        text = MaterialTheme.typographyExtended.textNormal.copy(
            color = colors.onBackgroundDark,
            fontWeight = FontWeight.Bold
        ),
    )

    internal val localTypographies: ProvidableCompositionLocal<Typographies> = staticCompositionLocalOf {
        error("not provided")
    }

}