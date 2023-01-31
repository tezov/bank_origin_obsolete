/*
 *  *********************************************************************************
 *  Created by Tezov on 31/01/2023 20:43
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 31/01/2023 20:15
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.lobby.login

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
    get() = localColors.current

infix fun PageLoginTheme.provides(value: PageLoginTheme.Colors) = localColors provides value

val PageLoginTheme.dimensions: PageLoginTheme.Dimensions
    @Composable
    @ReadOnlyComposable
    get() = localDimensions.current

infix fun PageLoginTheme.provides(value: PageLoginTheme.Dimensions) = localDimensions provides value

val PageLoginTheme.shapes: PageLoginTheme.Shapes
    @Composable
    @ReadOnlyComposable
    get() = localShapes.current

infix fun PageLoginTheme.provides(value: PageLoginTheme.Shapes) = localShapes provides value

val PageLoginTheme.borders: PageLoginTheme.Borders
    @Composable
    @ReadOnlyComposable
    get() = localBorders.current

infix fun PageLoginTheme.provides(value: PageLoginTheme.Borders) = localBorders provides value

val PageLoginTheme.typographies: PageLoginTheme.Typographies
    @Composable
    @ReadOnlyComposable
    get() = localTypographies.current

infix fun PageLoginTheme.provides(value: PageLoginTheme.Typographies) =
    localTypographies provides value

object PageLoginTheme {

    data class Colors(
        val background: Color,
        val backgroundButtonDark: Color,
        val backgroundButtonLight: Color,
        val backgroundDropDownMenu: Color,
        val textContent: Color,
        val textButtonDark: Color,
        val textButtonLight: Color,
        val textDropDownMenu: Color,
    )

    @Composable
    fun provideColors() = Colors(
        background = MaterialTheme.colors.primary,
        backgroundButtonDark = MaterialTheme.colorsCommonExtended.backgroundButtonConfirm,
        backgroundButtonLight = MaterialTheme.colorsCommonExtended.backgroundButtonCancel,
        backgroundDropDownMenu = ThemeColors.Data.blueOverlay,
        textContent = MaterialTheme.colorsCommonExtended.onPrimaryLight,
        textButtonDark = MaterialTheme.colorsCommonExtended.onBackgroundButtonConfirm,
        textButtonLight = MaterialTheme.colorsCommonExtended.onBackgroundButtonCancel,
        textDropDownMenu = MaterialTheme.colorsCommonExtended.onBackgroundModal,
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

    internal val localDimensions: ProvidableCompositionLocal<Dimensions> =
        staticCompositionLocalOf {
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
        val dropDownMenu: TextStyle,
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
        ),
        dropDownMenu = MaterialTheme.typographyExtended.textNormal.copy(
            fontSize = MaterialTheme.dimensionsFontExtended.textNormal,
            color = colors.textDropDownMenu,
            fontWeight = FontWeight.SemiBold
        )

    )

    internal val localTypographies: ProvidableCompositionLocal<Typographies> =
        staticCompositionLocalOf {
            error("not provided")
        }

    @Composable
    fun provideSwiperPagerStyle() = Swiper.Pager.Style(
        colorIndicatorActive = colors.backgroundButtonDark,
        colorIndicatorInactive = ThemeColors.Data.blueClear,
        dimensionIndicatorPaddingTop = dimensions.pagerIndicatorPaddingTop,
        dimensionIndicatorSize = dimensions.pagerIndicatorSize,
        dimensionIndicatorSpacing = dimensions.pagerIndicatorSpacing,
        shapeIndicator = CircleShape
    )

}