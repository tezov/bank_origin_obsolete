/*
 *  *********************************************************************************
 *  Created by Tezov on 19/02/2023 18:23
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 19/02/2023 17:46
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.dialog.lobby.login.auth

import androidx.compose.foundation.BorderStroke
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.tezov.bank.ui.theme.ThemeColors
import com.tezov.lib_core_android_kotlin.ui.component.branch.KeyBoard
import com.tezov.lib_core_android_kotlin.ui.component.plain.Button
import com.tezov.lib_core_android_kotlin.ui.component.plain.Link
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*

val DialogLoginAuthTheme.colors: DialogLoginAuthTheme.Colors
    @Composable
    @ReadOnlyComposable
    get() = localColors.current

infix fun DialogLoginAuthTheme.provides(value: DialogLoginAuthTheme.Colors) =
    localColors provides value

val DialogLoginAuthTheme.dimensions: DialogLoginAuthTheme.Dimensions
    @Composable
    @ReadOnlyComposable
    get() = localDimensions.current

infix fun DialogLoginAuthTheme.provides(value: DialogLoginAuthTheme.Dimensions) =
    localDimensions provides value

val DialogLoginAuthTheme.shapes: DialogLoginAuthTheme.Shapes
    @Composable
    @ReadOnlyComposable
    get() = localShapes.current

infix fun DialogLoginAuthTheme.provides(value: DialogLoginAuthTheme.Shapes) =
    localShapes provides value

val DialogLoginAuthTheme.borders: DialogLoginAuthTheme.Borders
    @Composable
    @ReadOnlyComposable
    get() = localBorders.current

infix fun DialogLoginAuthTheme.provides(value: DialogLoginAuthTheme.Borders) =
    localBorders provides value

val DialogLoginAuthTheme.typographies: DialogLoginAuthTheme.Typographies
    @Composable
    @ReadOnlyComposable
    get() = localTypographies.current

infix fun DialogLoginAuthTheme.provides(value: DialogLoginAuthTheme.Typographies) =
    localTypographies provides value


val DialogLoginAuthTheme.styles: DialogLoginAuthTheme.Style
    @Composable
    @ReadOnlyComposable
    get() = localStyles.current

infix fun DialogLoginAuthTheme.provides(value: DialogLoginAuthTheme.Style) = localStyles provides value

object DialogLoginAuthTheme {

    data class Colors(
        val background: Color,
        val onBackground: Color,
        val backgroundButtonActive: Color,
        val backgroundButtonInactive: Color,
        val textButtonDark: Color,
    )

    @Composable
    fun provideColors() = Colors(
        background = ThemeColors.Common.blackOverlay,
        onBackground = MaterialTheme.colorsCommonExtended.onPrimaryVariant,
        backgroundButtonActive = MaterialTheme.colors.primary,
        backgroundButtonInactive = MaterialTheme.colorsCommonExtended.backgroundButtonConfirm,
        textButtonDark = MaterialTheme.colorsCommonExtended.onBackgroundButtonConfirm,
    )

    internal val localColors: ProvidableCompositionLocal<Colors> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Dimensions(
        val paddingKeyboard_v: Dp,
        val paddingKeyboard_h: Dp,
        val spacingTopToTitle: Dp,
        val spacingTopFromButton: Dp,
        val paddingTopFromLink: Dp,
        val iconCloseSize: Dp,
        val iconFieldInfoSize: Dp,
        val iconFieldActionSize: Dp,
        val paddingButton_h: Dp,
        val paddingButton_v: Dp,
    )

    @Composable
    fun provideDimensions() = Dimensions(
        paddingKeyboard_v = MaterialTheme.dimensionsPaddingExtended.elementMicro_v,
        paddingKeyboard_h = MaterialTheme.dimensionsPaddingExtended.elementMicro_h,
        spacingTopToTitle = MaterialTheme.dimensionsSpacingExtended.big_v,
        spacingTopFromButton = MaterialTheme.dimensionsSpacingExtended.huge_v,
        paddingTopFromLink = MaterialTheme.dimensionsPaddingExtended.elementNormal_v,
        iconCloseSize = MaterialTheme.dimensionsSizeExtended.iconModal,
        iconFieldInfoSize = MaterialTheme.dimensionsSizeExtended.iconFieldInfo,
        iconFieldActionSize = MaterialTheme.dimensionsSizeExtended.iconFieldAction,
        paddingButton_h = MaterialTheme.dimensionsPaddingExtended.buttonNormal_h,
        paddingButton_v = MaterialTheme.dimensionsPaddingExtended.buttonNormal_v,
    )

    internal val localDimensions: ProvidableCompositionLocal<Dimensions> =
        staticCompositionLocalOf {
            error("not provided")
        }

    data class Shapes(
        val button: Shape,
        val authCard: Shape,
    )

    @Composable
    fun provideShapes() = Shapes(
        button = MaterialTheme.shapesExtended.roundedCornerNormal,
        authCard = MaterialTheme.shapesExtended.roundedCornerSmall,
    )

    internal val localShapes: ProvidableCompositionLocal<Shapes> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Borders(
        val authCard: BorderStroke,
    )

    @Composable
    fun provideBorders() = Borders(
        authCard = MaterialTheme.bordersExtended.strokeNormal.copy(
            brush = SolidColor(colors.onBackground)
        ),
    )

    internal val localBorders: ProvidableCompositionLocal<Borders> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Typographies(
        val title: TextStyle,
        val fieldValue: TextStyle,
        val fieldLabel: TextStyle,
        val button: TextStyle,
        val link: TextStyle,
    )

    @Composable
    fun provideTypographies() = Typographies(
        title = MaterialTheme.typographyExtended.textTitle.copy(
            color = colors.onBackground
        ),
        fieldValue = MaterialTheme.typographyExtended.textFieldValue.copy(
            color = colors.onBackground
        ),
        fieldLabel = MaterialTheme.typographyExtended.textFieldValue.copy(
            color = colors.onBackground
        ),
        button = MaterialTheme.typographyExtended.textButton,
        link = MaterialTheme.typographyExtended.textLink.copy(
            color = colors.onBackground,
        )

    )

    internal val localTypographies: ProvidableCompositionLocal<Typographies> =
        staticCompositionLocalOf {
            error("not provided")
        }

    data class Style(
        val keyBoardGridCube: KeyBoard.GridCube.Style,
        val button: Button.TextFilled.Style,
        val link: Link.Underlined.Style,
    )

    @Composable
    fun provideStyles() = Style(
        keyBoardGridCube = KeyBoard.GridCube.Style(
            colorContent = colors.onBackground,
            colorBackground = Color.Transparent,
            borderOuter = MaterialTheme.bordersExtended.strokeNormal.copy(
                brush = SolidColor(colors.onBackground)
            ),
            borderInner = MaterialTheme.bordersExtended.strokeBig.copy(
                brush = SolidColor(colors.onBackground)
            ),
        ),
        button = Button.TextFilled.Style(
//            outfitShape = shapes.button,
//            backgroundColorActive = colors.backgroundButtonActive,
//            backgroundColorInactive =  colors.backgroundButtonInactive,
//            textStyle = typographies.button,
//            textColorActive = colors.onBackground,
//            textColorInactive = colors.onBackground,
        ),
        link = Link.Underlined.Style(
            textStyle = typographies.link,
        )
    )

    internal val localStyles: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
        error("not provided")
    }


}