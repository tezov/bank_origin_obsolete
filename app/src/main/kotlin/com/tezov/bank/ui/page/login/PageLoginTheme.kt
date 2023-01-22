package com.tezov.bank.ui.page.login

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tezov.lib_core_android_kotlin.ui.theme.definition.*

val PageLoginTheme.colors: PageLoginTheme.Colors
    @Composable
    @ReadOnlyComposable
    get() = PageLoginTheme.localColors.current

val PageLoginTheme.dimensions: PageLoginTheme.Dimensions
    @Composable
    @ReadOnlyComposable
    get() = PageLoginTheme.localDimensions.current

val PageLoginTheme.shapes: PageLoginTheme.Shapes
    @Composable
    @ReadOnlyComposable
    get() = PageLoginTheme.localShapes.current

object PageLoginTheme {

    data class Colors(
        val background: Color,
        val backgroundButtonDark: Color,
        val backgroundInactive: Color,
        val backgroundButtonLight: Color,
        val textContent: Color,
        val textButtonDark: Color,
        val textButtonLight: Color,
    )
    @Composable
    fun provideColors() = Colors(
        background = MaterialTheme.colors.primary,
        backgroundButtonDark = MaterialTheme.colorsCommonExtended.backgroundButtonConfirm,
        backgroundInactive = MaterialTheme.colorsCommonExtended.backgroundInactive,
        backgroundButtonLight = MaterialTheme.colorsCommonExtended.backgroundButtonCancel,
        textContent = MaterialTheme.colorsCommonExtended.onPrimaryLight,
        textButtonDark = MaterialTheme.colorsCommonExtended.onBackgroundButtonConfirm,
        textButtonLight = MaterialTheme.colorsCommonExtended.onBackgroundButtonCancel,
    )
    val localColors: ProvidableCompositionLocal<Colors> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Dimensions(
        val textHuge: TextUnit,
        val textNormal:TextUnit,
        val textButton:TextUnit,
        val textLink:TextUnit,
        val paddingTopToTextHuge:Dp,
        val paddingTopToIndicator:Dp,
        val paddingTopFromLinkService:Dp,
        val pagerIndicatorPaddingTop:Dp,
        val pagerIndicatorSize:Dp,
        val pagerIndicatorSpacing:Dp,
        val logoSize:Dp,
        val iconBigSize:Dp,
        val paddingStartToIconBig:Dp,
        val iconMediumSize:Dp,
        val paddingStartToIconMedium:Dp,
        val iconSmallSize:Dp,

        val strokeIcon:Dp,
        val strokeButton:Dp,
        val paddingHorizontalButtonOutlined:Dp,
        val paddingVerticalButtonOutlined:Dp,
        val paddingHorizontalButton:Dp,
        val paddingVerticalButton:Dp,

        )
    @Composable
    fun provideDimensions() = Dimensions(
        textHuge = MaterialTheme.dimensionsFontExtended.textHuge,
        textNormal = MaterialTheme.dimensionsFontExtended.textNormal,
        textButton = MaterialTheme.dimensionsFontExtended.textButton,
        textLink = MaterialTheme.dimensionsFontExtended.textLink,

        paddingTopToTextHuge = 24.dp,
        paddingTopToIndicator = MaterialTheme.dimensionsPaddingExtended.elementBig_v,
        paddingTopFromLinkService = MaterialTheme.dimensionsPaddingExtended.elementBig_v,

        pagerIndicatorPaddingTop = MaterialTheme.dimensionsPaddingExtended.elementNormal_v,
        pagerIndicatorSize = 16.dp,
        pagerIndicatorSpacing = MaterialTheme.dimensionsSpacingExtended.big_h,

        logoSize = 64.dp,
        iconBigSize = 52.dp,
        paddingStartToIconBig = 28.dp,
        iconMediumSize = 38.dp,
        paddingStartToIconMedium = 12.dp,
        iconSmallSize = 42.dp,

        strokeIcon = 2.dp,
        strokeButton = 2.dp,

        paddingHorizontalButtonOutlined = 32.dp,
        paddingVerticalButtonOutlined = MaterialTheme.dimensionsPaddingExtended.buttonNormal_v,
        paddingHorizontalButton = MaterialTheme.dimensionsPaddingExtended.buttonNormal_h,
        paddingVerticalButton = MaterialTheme.dimensionsPaddingExtended.buttonNormal_v,
    )
    val localDimensions: ProvidableCompositionLocal<Dimensions> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Shapes(
        val button: Shape,
        val buttonOutline: Shape,

    )
    @Composable
    fun provideShapes() = Shapes(
        button = RoundedCornerShape(35),
        buttonOutline = RoundedCornerShape(50)
    )
    val localShapes: ProvidableCompositionLocal<Shapes> = staticCompositionLocalOf {
        error("not provided")
    }

    @Composable
    fun provideSwiperPagerStyle() = ThemeWidgetExtended.SwiperPager(
        colorIndicatorActive = colors.backgroundButtonDark,
        colorIndicatorInactive = colors.backgroundInactive,
        dimensionIndicatorPaddingTop = dimensions.pagerIndicatorPaddingTop,
        dimensionIndicatorSize = dimensions.pagerIndicatorSize,
        dimensionIndicatorSpacing = dimensions.pagerIndicatorSpacing,
        shapeIndicator = CircleShape
    )



}