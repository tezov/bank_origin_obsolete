package com.tezov.bank.ui.page.login

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
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
        textHuge = 14.sp,
        textNormal = 14.sp,
        textButton = 14.sp,
        textLink = 14.sp,

        paddingTopToTextHuge = 14.dp,
        paddingTopToIndicator = 14.dp,
        paddingTopFromLinkService = 14.dp,

        pagerIndicatorPaddingTop = 14.dp,
        pagerIndicatorSize = 14.dp,
        pagerIndicatorSpacing = 18.dp,

        logoSize = 18.dp,
        iconBigSize = 18.dp,
        paddingStartToIconBig = 18.dp,
        iconMediumSize = 18.dp,
        paddingStartToIconMedium = 18.dp,
        iconSmallSize = 18.dp,

        strokeIcon = 2.dp,
        strokeButton = 3.dp,

        paddingHorizontalButtonOutlined = 32.dp,
        paddingVerticalButtonOutlined = 4.dp,
        paddingHorizontalButton = 4.dp,
        paddingVerticalButton = 4.dp,
    )
    val localDimensions: ProvidableCompositionLocal<Dimensions> = staticCompositionLocalOf {
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