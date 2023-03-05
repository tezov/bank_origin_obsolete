/*
 *  *********************************************************************************
 *  Created by Tezov on 05/03/2023 17:17
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 05/03/2023 15:57
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.lobby.login

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.bank.ui.theme.ThemeColors
import com.tezov.bank.ui.theme.ThemeComponents
import com.tezov.lib_core_android_kotlin.type.primaire.SizeDp
import com.tezov.lib_core_android_kotlin.type.primaire.sizeDp
import com.tezov.lib_core_android_kotlin.ui.component.branch.HorizontalScrollable
import com.tezov.lib_core_android_kotlin.ui.component.plain.Button
import com.tezov.lib_core_android_kotlin.ui.component.plain.Icon
import com.tezov.lib_core_android_kotlin.ui.component.plain.Image
import com.tezov.lib_core_android_kotlin.ui.component.plain.Link
import com.tezov.lib_core_android_kotlin.ui.theme.style.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorder.Simple.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorder.Simple.Style.Companion.copyToSimpleStyle
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorder.State.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorder.State.Style.Companion.copyToStateStyle
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.State.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.State.Style.Companion.copyToStateStyle
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.Simple.Style.Companion.copyToSimpleStyle
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.State.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.State.Style.Companion.copyToStateStyle
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

infix fun PageLoginTheme.provides(value: PageLoginTheme.Typographies) =
    localTypographies provides value

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
        background = MaterialTheme.colorsExtended.background.accent,
        backgroundButtonDark = MaterialTheme.colorsExtended.backgroundButtonConfirm.active,
        backgroundButtonLight = ThemeColors.Common.whiteDark,
        backgroundDropDownMenu = ThemeColors.Common.whiteDark,
        textContent = MaterialTheme.colorsExtended.onBackground.accent,
        textButtonDark = MaterialTheme.colorsExtended.onBackgroundButtonConfirm.active,
        textButtonLight = MaterialTheme.colorsExtended.onBackgroundButtonCancel.active,
        textDropDownMenu = MaterialTheme.colorsExtended.onBackgroundModal.default,
    )

    internal val localColors: ProvidableCompositionLocal<Colors> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Dimensions(
        val spacingTopToTitle: Dp,
        val spacingTopFromLinkService: Dp,
        val sizeLogo: SizeDp,
        val sizeIconBig: SizeDp,
        val paddingStartToIconBig: Dp,
        val sizeIconMedium: SizeDp,
        val paddingStartToIconMedium: Dp,
        val sizeIconSmall: SizeDp,
        val paddingButtonOutlined_h: Dp,
        val paddingButtonOutlined_v: Dp,
        val paddingButton_h: Dp,
        val paddingButton_v: Dp,
    )

    @Composable
    fun provideDimensions() = Dimensions(
        spacingTopToTitle = 24.dp,
        spacingTopFromLinkService = MaterialTheme.dimensionsPaddingExtended.elementBig_v,
        sizeLogo = 64.sizeDp,
        sizeIconBig = 52.sizeDp,
        paddingStartToIconBig = 28.dp,
        sizeIconMedium = 38.sizeDp,
        paddingStartToIconMedium = 12.dp,
        sizeIconSmall = 42.sizeDp,
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
        val buttonOutlined: OutfitShapeState,
        val icon: OutfitShapeSimple,
    )

    @Composable
    fun provideShapes() = Shapes(
        button = MaterialTheme.shapesExtended.roundedCornerNormal.copyToStateStyle(),
        buttonOutlined = MaterialTheme.shapesExtended.roundedCornerNormal.copyToStateStyle(),
        icon = OutfitShapeSimple(sketch = OutfitShapeSketch(template = OutfitShape.Template.Circle)),
    )

    internal val localShapes: ProvidableCompositionLocal<Shapes> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Borders(
        val button: OutfitBorderState,
        val buttonOutlined: OutfitBorderState,
        val icon: OutfitBorderSimple,
    )

    @Composable
    fun provideBorders() = Borders(
        button = MaterialTheme.bordersExtended.strokeMicro.copyToStateStyle(),
        buttonOutlined = MaterialTheme.bordersExtended.strokeHuge.copyToStateStyle(),
        icon = MaterialTheme.bordersExtended.strokeBig.copyToSimpleStyle(),
    )

    internal val localBorders: ProvidableCompositionLocal<Borders> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Typographies(
        val supra: OutfitTextSimple,
        val huge: OutfitTextSimple,
        val body: OutfitTextSimple,
        val buttonFilled: OutfitTextState,
        val buttonOutlined: OutfitTextState,
        val link: OutfitTextState,
        val dropDownMenu: OutfitTextSimple,
    )

    @Composable
    fun provideTypographies() = Typographies(
        supra = MaterialTheme.typographiesExtended.textSupra.copyToSimpleStyle {
            color = colors.textContent
        },
        huge = MaterialTheme.typographiesExtended.textHuge.copyToSimpleStyle {
            color = colors.textContent
        },
        body = MaterialTheme.typographiesExtended.textNormal.copyToSimpleStyle {
            color = colors.textContent
            typo = typo.copy(
                fontWeight = FontWeight.Bold
            )
        },
        buttonFilled = MaterialTheme.typographiesExtended.textButton.copyToStateStyle(),
        buttonOutlined = MaterialTheme.typographiesExtended.textButtonOutline.copyToStateStyle(),
        link = MaterialTheme.typographiesExtended.textLink.copyToStateStyle {
            outfitColor = colors.textContent.outfitColorActive
            typo = typo.copy(fontWeight = FontWeight.Bold)
        },
        dropDownMenu = MaterialTheme.typographiesExtended.textNormal.copyToSimpleStyle {
            color = colors.textDropDownMenu
            typo = typo.copy(fontWeight = FontWeight.SemiBold)
        }
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
        val logo: Image.Simple.Style,
        val iconBig: Image.Frame.Style,
        val iconMedium: Icon.Frame.Style,
        val iconSmall: Icon.Frame.Style,
    )

    @Composable
    fun provideStyles() = Style(
        pager = ThemeComponents.providePagerStyle(),
        buttonDark = Button.TextFilled.Style(
            outfitFrame = OutfitFrameState(
                outfitShape = shapes.button.copy {
                    outfitColor = colors.backgroundButtonDark.outfitColorActive
                },
            ),
            outfitText = typographies.buttonFilled.copy {
                outfitColor = colors.textButtonDark.outfitColorActive
            },
        ),
        buttonLight = Button.TextFilled.Style(
            outfitFrame = OutfitFrameState(
                outfitShape = shapes.button.copy {
                    outfitColor = colors.backgroundButtonLight.outfitColorActive
                },
                outfitBorder = borders.button.copy {
                    outfitColor = colors.textButtonDark.outfitColorActive
                },
            ),
            outfitText = typographies.buttonFilled.copy {
                outfitColor = colors.textButtonLight.outfitColorActive
            }
        ),
        buttonOutlined = Button.TextOutlined.Style(
            outfitFrame = OutfitFrameState(
                outfitShape = shapes.buttonOutlined,
                outfitBorder = borders.buttonOutlined.copy {
                    outfitColor = colors.textContent.outfitColorActive
                },
            ),
            outfitText = typographies.buttonOutlined.copy {
                typo = typo.copy(fontWeight = FontWeight.SemiBold)
                outfitColor = colors.textContent.outfitColorActive
            }
        ),
        link = Link.Underlined.Style(
            outfitText = typographies.link,
        ),
        logo = Image.Simple.Style(
            size = dimensions.sizeLogo,
            contentScale = ContentScale.Crop
        ),
        iconBig = Image.Frame.Style(
            size = dimensions.sizeIconBig,
            outfitFrame = OutfitFrameSimple(
                outfitShape = shapes.icon,
                outfitBorder = borders.icon.copy{
//                    color =
                }
            )
        ),
        iconMedium = Icon.Frame.Style(
            size = dimensions.sizeIconMedium,
            outfitFrame = OutfitFrameSimple(
                outfitShape = shapes.icon,
            )
        ),
        iconSmall = Icon.Frame.Style(
            size = dimensions.sizeIconSmall,
            outfitFrame = OutfitFrameSimple(
                outfitShape = shapes.icon,
            )
        ),
    )

    internal val localStyles: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
        error("not provided")
    }

}