/*
 *  *********************************************************************************
 *  Created by Tezov on 08/04/2023 19:53
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/04/2023 19:44
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
import com.tezov.bank.ui.theme.ThemeColorProviders
import com.tezov.bank.ui.theme.ThemeComponentProviders
import com.tezov.lib_core_android_kotlin.type.primaire.DpSize
import com.tezov.lib_core_android_kotlin.type.primaire.dpSize
import com.tezov.lib_core_android_kotlin.ui.component.branch.HorizontalScrollable
import com.tezov.lib_core_android_kotlin.ui.component.plain.Button
import com.tezov.lib_core_android_kotlin.ui.component.plain.Button.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.component.plain.Icon
import com.tezov.lib_core_android_kotlin.ui.component.plain.Image
import com.tezov.lib_core_android_kotlin.ui.component.plain.Link
import com.tezov.lib_core_android_kotlin.ui.theme.style.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorder.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitFrame.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPalette.Size.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.copy
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
        val backgroundDropDownMenu: Color,
        val textContent: Color,
        val textDropDownMenu: Color,
    )

    @Composable
    fun provideColors() = Colors(
        background = MaterialTheme.colorsExtended.background.accent,
        backgroundDropDownMenu = ThemeColorProviders.Palette.whiteDark,
        textContent = MaterialTheme.colorsExtended.onBackground.accent,
        textDropDownMenu = MaterialTheme.colorsExtended.onBackgroundModal.default,
    )

    internal val localColors: ProvidableCompositionLocal<Colors> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Dimensions(
        val spacingTopToTitle: Dp,
        val spacingTopFromLinkService: Dp,
        val sizeLogo: DpSize,
        val sizeIconBig: DpSize,
        val paddingStartToIconBig: Dp,
        val sizeIconMedium: DpSize,
        val paddingStartToIconMedium: Dp,
        val sizeIconSmall: DpSize,
        val paddingButtonOutlined_h: Dp,
        val paddingButtonOutlined_v: Dp,
        val paddingButton_h: Dp,
        val paddingButton_v: Dp,
    )

    @Composable
    fun provideDimensions() = Dimensions(
        spacingTopToTitle = 24.dp,
        spacingTopFromLinkService = MaterialTheme.dimensionsPaddingExtended.chunk.vertical.big,
        sizeLogo = 64.dpSize,
        sizeIconBig = 52.dpSize,
        paddingStartToIconBig = 28.dp,
        sizeIconMedium = 38.dpSize,
        paddingStartToIconMedium = 12.dp,
        sizeIconSmall = 42.dpSize,
        paddingButtonOutlined_h = 32.dp,
        paddingButtonOutlined_v = MaterialTheme.dimensionsPaddingExtended.button.vertical.normal,
        paddingButton_h = MaterialTheme.dimensionsPaddingExtended.button.vertical.normal,
        paddingButton_v = MaterialTheme.dimensionsPaddingExtended.button.vertical.normal,
    )

    internal val localDimensions: ProvidableCompositionLocal<Dimensions> =
        staticCompositionLocalOf {
            error("not provided")
        }

    data class Shapes(
        val button: OutfitShape.StateColor.Style,
        val buttonOutlined: OutfitShape.StateColor.Style,
        val icon: OutfitShape.StateColor.Style,
    )

    @Composable
    fun provideShapes() = Shapes(
        button = MaterialTheme.shapesExtended.button.normal,
        buttonOutlined = MaterialTheme.shapesExtended.button.normal,
        icon = OutfitShape.StateColor.Style()
    )

    internal val localShapes: ProvidableCompositionLocal<Shapes> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Borders(
        val button: OutfitBorder.StateColor.Style,
        val buttonOutlined: OutfitBorder.StateColor.Style,
        val icon: OutfitBorder.StateColor.Style,
    )

    @Composable
    fun provideBorders() = Borders(
        button = MaterialTheme.bordersExtended.chunk.normal,
        buttonOutlined = MaterialTheme.bordersExtended.chunk.normal,
        icon = MaterialTheme.bordersExtended.chunk.normal,
    )

    internal val localBorders: ProvidableCompositionLocal<Borders> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Typographies(
        val supra: OutfitText.StateColor.Style,
        val huge: OutfitText.StateColor.Style,
        val body: OutfitText.StateColor.Style,
        val dropDownMenu: OutfitText.StateColor.Style,
    )

    @Composable
    fun provideTypographies() = Typographies(
        supra = MaterialTheme.typographiesExtended.title.supra.copy {
            outfitState = OutfitStateSimple(
                colors.textContent
            )
        },
        huge = MaterialTheme.typographiesExtended.title.supra.copy {
            outfitState = OutfitStateSimple(
                colors.textContent
            )
        },
        body = MaterialTheme.typographiesExtended.title.supra.copy {
            outfitState = OutfitStateSimple(
                colors.textContent
            )
            typo = typo.copy(
                fontWeight = FontWeight.Bold
            )
        },
        dropDownMenu = MaterialTheme.typographiesExtended.title.supra.copy {
            outfitState = OutfitStateSimple(
                colors.textDropDownMenu
            )
            typo = typo.copy(fontWeight = FontWeight.SemiBold)
        }
    )

    internal val localTypographies: ProvidableCompositionLocal<Typographies> =
        staticCompositionLocalOf {
            error("not provided")
        }

    data class Style(
        val pager: HorizontalScrollable.Pager.Style,
        val buttonDark: Button.StateColor.Style,
        val buttonLight: Button.StateColor.Style,
        val buttonOutlined: Button.StateColor.Style,
        val link: Link.StateColor.Style,
        val logo: Image.Simple.Style,
        val iconBig: Image.StateColor.Style,
        val iconMedium: Icon.StateColor.Style,
        val iconSmall: Icon.StateColor.Style,
    )

    @Composable
    fun provideStyles() = Style(
        pager = ThemeComponentProviders.providePagerStyle(),
        buttonDark = MaterialTheme.componentsButtonExtended.primary.copy {
            outfitFrame = outfitFrame.copy {
                outfitShape = shapes.button.copy {
//                    outfitState = colors.backgroundButtonDark.asOutfitColorActive
                }
            }
            outfitText = outfitText.copy {
//                outfitState = colors.textButtonDark.asOutfitColorActive
            }
        },
        buttonLight = MaterialTheme.componentsButtonExtended.primary.copy {
            outfitFrame = outfitFrame.copy {
                outfitShape = shapes.button.copy {
//                    outfitState = colors.backgroundButtonLight.asOutfitColorActive
                }
                outfitBorder = borders.button.copy {
//                    outfitState = colors.textButtonDark.asOutfitColorActive
                }
            }
            outfitText = outfitText.copy {
//                outfitState = colors.textButtonLight.asOutfitColorActive

            }
        },
        buttonOutlined = MaterialTheme.componentsButtonExtended.primary.copy {
            outfitFrame = outfitFrame.copy {
                outfitShape = shapes.buttonOutlined
                outfitBorder = borders.buttonOutlined.copy {
//                    outfitState = colors.textContent.asOutfitColorActive
                }
            }
            outfitText = outfitText.copy {
                typo = typo.copy(fontWeight = FontWeight.SemiBold)
//                outfitState = colors.textContent.asOutfitColorActive

            }
        },
        link = Link.StateColor.Style(
//            outfitText = typographies.link,
        ),
        logo = Image.Simple.Style(
            size = dimensions.sizeLogo,
            contentScale = ContentScale.Crop
        ),
        iconBig = Image.StateColor.Style(
            size = dimensions.sizeIconBig,
            outfitFrame = OutfitFrameStateColor(
                outfitShape = shapes.icon,
                outfitBorder = borders.icon.copy {
                    outfitState = OutfitStateSimple(
                        Color.Black
                    )
                }
            )
        ),
        iconMedium = Icon.StateColor.Style(
            size = dimensions.sizeIconMedium,
            outfitFrame = OutfitFrameStateColor(
                outfitShape = shapes.icon
            )
        ),
        iconSmall = Icon.StateColor.Style(
            size = dimensions.sizeIconSmall,
            outfitFrame = OutfitFrameStateColor(
                outfitShape = shapes.icon
            )
        ),
    )

    internal val localStyles: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
        error("not provided")
    }

}