package com.tezov.bank.ui.page.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.CircleShape
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
import com.tezov.lib_core_android_kotlin.ui.component.widget.Swiper
import com.tezov.lib_core_android_kotlin.ui.theme.definition.*

val PageLoginTheme.colors: PageLoginTheme.Colors
    @Composable
    @ReadOnlyComposable
    get() = PageLoginTheme.localColors.current
infix fun PageLoginTheme.provides(value: PageLoginTheme.Colors) = PageLoginTheme.localColors provides value

val PageLoginTheme.dimensions: PageLoginTheme.Dimensions
    @Composable
    @ReadOnlyComposable
    get() = PageLoginTheme.localDimensions.current
infix fun PageLoginTheme.provides(value: PageLoginTheme.Dimensions) = PageLoginTheme.localDimensions provides value

val PageLoginTheme.shapes: PageLoginTheme.Shapes
    @Composable
    @ReadOnlyComposable
    get() = PageLoginTheme.localShapes.current
infix fun PageLoginTheme.provides(value: PageLoginTheme.Shapes) = PageLoginTheme.localShapes provides value

val PageLoginTheme.borders: PageLoginTheme.Borders
    @Composable
    @ReadOnlyComposable
    get() = PageLoginTheme.localBorders.current
infix fun PageLoginTheme.provides(value: PageLoginTheme.Borders) = PageLoginTheme.localBorders provides value

val PageLoginTheme.typographies: PageLoginTheme.Typographies
    @Composable
    @ReadOnlyComposable
    get() = PageLoginTheme.localTypographies.current
infix fun PageLoginTheme.provides(value: PageLoginTheme.Typographies) = PageLoginTheme.localTypographies provides value

object PageLoginTheme {

    data class Colors(
        val background: Color,
        val backgroundButtonDark: Color,
        val backgroundButtonLight: Color,
        val backgroundInactive: Color,
        val textContent: Color,
        val textButtonDark: Color,
        val textButtonLight: Color,
    )

    @Composable
    fun provideColors() = Colors(
        background = MaterialTheme.colors.primary,
        backgroundButtonDark = MaterialTheme.colorsCommonExtended.backgroundButtonConfirm,
        backgroundButtonLight = MaterialTheme.colorsCommonExtended.backgroundButtonCancel,
        backgroundInactive = MaterialTheme.colorsCommonExtended.backgroundInactive,
        textContent = MaterialTheme.colorsCommonExtended.onPrimaryLight,
        textButtonDark = MaterialTheme.colorsCommonExtended.onBackgroundButtonConfirm,
        textButtonLight = MaterialTheme.colorsCommonExtended.onBackgroundButtonCancel,
    )

    internal val localColors: ProvidableCompositionLocal<Colors> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Dimensions(
        val spacingTopToTitle: Dp,
        val spacingTopFromLinkService: Dp,
        val pagerIndicatorPaddingTop: Dp,
        val pagerIndicatorSize: Dp,
        val pagerIndicatorSpacing: Dp,
        val logoSize: Dp,
        val iconBigSize: Dp,
        val paddingStartToIconBig: Dp,
        val iconMediumSize: Dp,
        val paddingStartToIconMedium: Dp,
        val iconSmallSize: Dp,
        val paddingHorizontalButtonOutlined: Dp,
        val paddingVerticalButtonOutlined: Dp,
        val paddingHorizontalButton: Dp,
        val paddingVerticalButton: Dp,
    )

    @Composable
    fun provideDimensions() = Dimensions(
        spacingTopToTitle = 24.dp,
        spacingTopFromLinkService = MaterialTheme.dimensionsPaddingExtended.elementBig_v,
        pagerIndicatorPaddingTop = MaterialTheme.dimensionsPaddingExtended.elementNormal_v,
        pagerIndicatorSize = 12.dp,
        pagerIndicatorSpacing = MaterialTheme.dimensionsSpacingExtended.normal_h,
        logoSize = 64.dp,
        iconBigSize = 52.dp,
        paddingStartToIconBig = 28.dp,
        iconMediumSize = 38.dp,
        paddingStartToIconMedium = 12.dp,
        iconSmallSize = 42.dp,
        paddingHorizontalButtonOutlined = 32.dp,
        paddingVerticalButtonOutlined = MaterialTheme.dimensionsPaddingExtended.buttonNormal_v,
        paddingHorizontalButton = MaterialTheme.dimensionsPaddingExtended.buttonNormal_h,
        paddingVerticalButton = MaterialTheme.dimensionsPaddingExtended.buttonNormal_v,
    )

    internal val localDimensions: ProvidableCompositionLocal<Dimensions> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Shapes(
        val button: Shape,
        val buttonOutline: Shape,
    )

    @Composable
    fun provideShapes() = Shapes(
        button = MaterialTheme.shapesExtended.buttonNormal,
        buttonOutline = MaterialTheme.shapesExtended.buttonOutlinedBig
    )

    internal val localShapes: ProvidableCompositionLocal<Shapes> = staticCompositionLocalOf {
        error("not provided")
    }


    data class Borders(
        val iconBig: BorderStroke,
        val buttonDark: BorderStroke,
        val buttonOutline: BorderStroke,

    )

    @Composable
    fun provideBorders() = Borders(
        iconBig = BorderStroke(
            2.dp,
            colors.textContent
        ),
        buttonDark = BorderStroke(
            1.dp,
            ThemeColors.Data.whiteDark
        ),
        buttonOutline = BorderStroke(
            2.dp,
            colors.textContent
        )
    )

    internal val localBorders: ProvidableCompositionLocal<Borders> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Typographies(
        val supra: TextStyle,
        val huge: TextStyle,
        val body: TextStyle,
        val button: TextStyle,
        val buttonOutlined: TextStyle,
        val link: TextStyle,
    )

    @Composable
    fun provideTypographies() = Typographies(
        supra = MaterialTheme.typographyExtended.textSupra.copy(
            color = colors.textContent
        ),
        huge = MaterialTheme.typographyExtended.textHuge.copy(
            color = colors.textContent
        ),
        body = MaterialTheme.typographyExtended.textNormal.copy(
            color = colors.textContent,
            fontWeight = FontWeight.Bold
        ),
        button = MaterialTheme.typographyExtended.textButton.copy(
            fontSize = MaterialTheme.dimensionsFontExtended.textButton
        ),
        buttonOutlined = MaterialTheme.typographyExtended.textButtonOutline.copy(
            fontSize = MaterialTheme.dimensionsFontExtended.textButtonOutlined,
            color = colors.textContent,
            fontWeight = FontWeight.Bold
        ),
        link = MaterialTheme.typographyExtended.textLink.copy(
            fontSize = MaterialTheme.dimensionsFontExtended.textLink,
            color = colors.textContent,
            fontWeight = FontWeight.Bold
        )

    )

    internal val localTypographies: ProvidableCompositionLocal<Typographies> = staticCompositionLocalOf {
        error("not provided")
    }

    @Composable
    fun provideSwiperPagerStyle() = Swiper.Pager.Style(
        colorIndicatorActive = colors.backgroundButtonDark,
        colorIndicatorInactive = colors.backgroundInactive,
        dimensionIndicatorPaddingTop = dimensions.pagerIndicatorPaddingTop,
        dimensionIndicatorSize = dimensions.pagerIndicatorSize,
        dimensionIndicatorSpacing = dimensions.pagerIndicatorSpacing,
        shapeIndicator = CircleShape
    )

}