/*
 *  *********************************************************************************
 *  Created by Tezov on 01/03/2023 22:00
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 01/03/2023 22:00
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.lobby.login

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.bank.ui.theme.ThemeColors
import com.tezov.bank.ui.theme.ThemeComponent
import com.tezov.lib_core_android_kotlin.ui.component.branch.HorizontalScrollable
import com.tezov.lib_core_android_kotlin.ui.component.plain.Button
import com.tezov.lib_core_android_kotlin.ui.component.plain.Link
import com.tezov.lib_core_android_kotlin.ui.theme.style.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitColorsState.Simple.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.Simple.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.State.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.State.Style.Companion.copyToStateStyle
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*

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

infix fun PageLoginTheme.provides(value: PageLoginTheme.Typographies) = localTypographies provides value

val PageLoginTheme.styles: PageLoginTheme.Style
    @Composable
    @ReadOnlyComposable
    get() = localStyles.current

infix fun PageLoginTheme.provides(value: PageLoginTheme.Style) = localStyles provides value

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
        backgroundButtonDark = MaterialTheme.colorsCommonExtended.backgroundButtonConfirm.active,
        backgroundButtonLight = MaterialTheme.colorsCommonExtended.onSecondaryVariant,
        backgroundDropDownMenu = ThemeColors.Common.whiteDark,
        textContent = MaterialTheme.colorsCommonExtended.onPrimaryVariant,
        textButtonDark = MaterialTheme.colorsCommonExtended.onBackgroundButtonConfirm.active,
        textButtonLight = MaterialTheme.colorsCommonExtended.onBackgroundButtonCancel.active,
        textDropDownMenu = MaterialTheme.colorsCommonExtended.onBackgroundModal,
    )

    internal val localColors: ProvidableCompositionLocal<Colors> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Dimensions(
        val spacingTopToTitle: Dp,
        val spacingTopFromLinkService: Dp,
        val logoSize: Dp,
        val iconBigSize: Dp,
        val paddingStartToIconBig: Dp,
        val iconMediumSize: Dp,
        val paddingStartToIconMedium: Dp,
        val iconSmallSize: Dp,
        val paddingButtonOutlined_h: Dp,
        val paddingButtonOutlined_v: Dp,
        val paddingButton_h: Dp,
        val paddingButton_v: Dp,
    )

    @Composable
    fun provideDimensions() = Dimensions(
        spacingTopToTitle = 24.dp,
        spacingTopFromLinkService = MaterialTheme.dimensionsPaddingExtended.elementBig_v,
        logoSize = 64.dp,
        iconBigSize = 52.dp,
        paddingStartToIconBig = 28.dp,
        iconMediumSize = 38.dp,
        paddingStartToIconMedium = 12.dp,
        iconSmallSize = 42.dp,
        paddingButtonOutlined_h = 32.dp,
        paddingButtonOutlined_v = MaterialTheme.dimensionsPaddingExtended.buttonNormal_v,
        paddingButton_h = MaterialTheme.dimensionsPaddingExtended.buttonNormal_h,
        paddingButton_v = MaterialTheme.dimensionsPaddingExtended.buttonNormal_v,
    )

    internal val localDimensions: ProvidableCompositionLocal<Dimensions> =
        staticCompositionLocalOf {
            error("not provided")
        }

    data class Shapes(
        val button: OutfitShapeState,
    )

    @Composable
    fun provideShapes() = Shapes(
        button = MaterialTheme.shapesSimpleExtended.roundedCornerNormal.copyToStateStyle(),
    )

    internal val localShapes: ProvidableCompositionLocal<Shapes> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Borders(
        val iconBig: BorderStroke,
    )

    @Composable
    fun provideBorders() = Borders(
        iconBig = MaterialTheme.bordersExtended.strokeBig.getOrDefault().copy(
            brush = SolidColor(colors.textContent)
        ),
    )

    internal val localBorders: ProvidableCompositionLocal<Borders> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Typographies(
        val supra: TextStyle,
        val huge: TextStyle,
        val body: TextStyle,
        val buttonFilled: TextStyle,
        val buttonOutlined: TextStyle,
        val link: TextStyle,
        val dropDownMenu: TextStyle,
    )

    @Composable
    fun provideTypographies() = Typographies(
        supra = MaterialTheme.typographiesSimpleExtended.textSupra.typo.copy(
            color = colors.textContent
        ),
        huge = MaterialTheme.typographiesSimpleExtended.textHuge.typo.copy(
            color = colors.textContent
        ),
        body = MaterialTheme.typographiesSimpleExtended.textNormal.typo.copy(
            color = colors.textContent,
            fontWeight = FontWeight.Bold
        ),
        buttonFilled = MaterialTheme.typographiesSimpleExtended.textButton.typo,
        buttonOutlined = MaterialTheme.typographiesSimpleExtended.textButtonOutline.typo.copy(
            fontWeight = FontWeight.Bold
        ),
        link = MaterialTheme.typographiesSimpleExtended.textLink.typo.copy(
            color = colors.textContent,
            fontWeight = FontWeight.Bold
        ),
        dropDownMenu = MaterialTheme.typographiesSimpleExtended.textNormal.typo.copy(
            color = colors.textDropDownMenu,
            fontWeight = FontWeight.SemiBold
        )
    )

    internal val localTypographies: ProvidableCompositionLocal<Typographies> =
        staticCompositionLocalOf {
            error("not provided")
        }

    data class Style(
        val pager: HorizontalScrollable.Pager.Style,
        val buttonDark: Button.TextFilled.Style,
        val buttonLight: Button.TextFilled.Style,
        val buttonOutlined: Button.TextOutlined.Style,
        val link: Link.Underlined.Style,
    )

    @Composable
    fun provideStyles() = Style(
        pager = ThemeComponent.providePagerStyle(),
        buttonDark = Button.TextFilled.Style(
            outfitFrame = OutfitFrameState(
                outfitShape = shapes.button.copy {
                    outfitColor = outfitColor.copy {
                        active = colors.backgroundButtonDark
                    }
                },
            ),


            outfitFrame = OutfitFrameState(
                outfitShape = OutfitShapeState(
                    size = shapes.button,
                    outfitColor = OutfitColorsSimple(
                        active = colors.backgroundButtonDark
                    )
                ),
            ),
            outfitText = OutfitTextState(
                typo = typographies.buttonFilled,
                outfitColor = OutfitColorsSimple(
                    active = colors.textButtonDark
                )
            )
        ),
        buttonLight = Button.TextFilled.Style(
            outfitFrame = OutfitFrameState(
                outfitShape = OutfitShapeState(
                    size = shapes.button,
                    outfitColor = OutfitColorsSimple(
                        active = colors.backgroundButtonLight
                    )
                ),
                outfitBorder = OutfitBorderState(
                    size = MaterialTheme.bordersExtended.strokeSmall.getOrDefault().width,
                    outfitColor = OutfitColorsSimple(
                        active = ThemeColors.Common.blueShadow.copy(alpha = 0.5f)
                    )
                ),
            ),
            outfitText = OutfitTextState(
                typo = typographies.buttonFilled,
                outfitColor = OutfitColorsSimple(
                    active = colors.textButtonLight
                )
            )
        ),
        buttonOutlined = Button.TextOutlined.Style(
            outfitFrame = OutfitFrameState(
                outfitShape = OutfitShapeState(
//                    size = shapes.button
                ),
                outfitBorder = OutfitBorderState(
                    size = MaterialTheme.bordersExtended.strokeBig.getOrDefault().width,
                    outfitColor = OutfitColorsSimple(
                        active = colors.textContent
                    )
                ),
            ),
            outfitText = OutfitTextState(
                typo = typographies.buttonOutlined,
                outfitColor = OutfitColorsSimple(
                    active = colors.textContent
                )
            )
        ),
        link = Link.Underlined.Style(
//            outfitText = typographies.link,
        )
    )

    internal val localStyles: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
        error("not provided")
    }

}