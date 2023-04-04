/*
 *  *********************************************************************************
 *  Created by Tezov on 04/04/2023 13:51
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 04/04/2023 13:03
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
import com.tezov.lib_core_android_kotlin.ui.component.plain.Button.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.component.plain.Icon
import com.tezov.lib_core_android_kotlin.ui.component.plain.Image
import com.tezov.lib_core_android_kotlin.ui.component.plain.Link
import com.tezov.lib_core_android_kotlin.ui.theme.style.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorder.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitFrame.Styl.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Companion.copy
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
        background = MaterialTheme.colorsCommonExtended.background.accent,
        backgroundDropDownMenu = ThemeColors.Resource.whiteDark,
        textContent = MaterialTheme.colorsCommonExtended.onBackground.accent,
        textDropDownMenu = MaterialTheme.colorsCommonExtended.onBackgroundModal.default,
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
        val button: OutfitShape.Style,
        val buttonOutlined: OutfitShape.Style,
        val icon: OutfitShape.Style,
    )

    @Composable
    fun provideShapes() = Shapes(
        button = MaterialTheme.shapesCommonExtended.roundedCornerNormal,
        buttonOutlined = MaterialTheme.shapesCommonExtended.roundedCornerNormal,
        icon = OutfitShape.Style(
            template = OutfitShape.Template.Circle
        )
    )

    internal val localShapes: ProvidableCompositionLocal<Shapes> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Borders(
        val button: OutfitBorder.Style,
        val buttonOutlined: OutfitBorder.Style,
        val icon: OutfitBorder.Style,
    )

    @Composable
    fun provideBorders() = Borders(
        button = MaterialTheme.bordersCommonExtended.strokeMicro,
        buttonOutlined = MaterialTheme.bordersCommonExtended.strokeHuge,
        icon = MaterialTheme.bordersCommonExtended.strokeBig,
    )

    internal val localBorders: ProvidableCompositionLocal<Borders> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Typographies(
        val supra: OutfitText.StateColor,
        val huge: OutfitText.StateColor,
        val body: OutfitText.StateColor,
        val dropDownMenu: OutfitText.StateColor,
    )

    @Composable
    fun provideTypographies() = Typographies(
        supra = MaterialTheme.typographiesTextExtended.textSupra.copy {
            outfitState = OutfitStateSimple(
                colors.textContent
            )
        },
        huge = MaterialTheme.typographiesTextExtended.textHuge.copy {
            outfitState = OutfitStateSimple(
                colors.textContent
            )
        },
        body = MaterialTheme.typographiesTextExtended.textNormal.copy {
            outfitState = OutfitStateSimple(
                colors.textContent
            )
            typo = typo.copy(
                fontWeight = FontWeight.Bold
            )
        },
        dropDownMenu = MaterialTheme.typographiesTextExtended.textNormal.copy {
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
        pager = ThemeComponents.providePagerStyle(),
        buttonDark = Button.StateColor.Style.TextFilled.copy {
            outfitFrame = outfitFrame.copy {
                outfitShape = shapes.button.copy {
//                    outfitState = colors.backgroundButtonDark.asOutfitColorActive
                }
            }
            outfitText = outfitText.copy {
//                outfitState = colors.textButtonDark.asOutfitColorActive
            }
        },
        buttonLight = Button.StateColor.Style.TextFilled.copy {
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
        buttonOutlined = Button.StateColor.Style.TextOutlined.copy {
            outfitFrame = outfitFrame.copy {
                outfitShape = shapes.buttonOutlined
                outfitBorder = borders.buttonOutlined.copy {
                    outfitState = colors.textContent.asOutfitColorActive
                }
            }
            outfitText = outfitText.copy {
                typo = typo.copy(fontWeight = FontWeight.SemiBold)
                outfitState = colors.textContent.asOutfitColorActive

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
            outfitFrame = OutfitFrame.Styl(
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
            outfitFrame = OutfitFrame.Styl(
                outfitShape = shapes.icon
            )
        ),
        iconSmall = Icon.StateColor.Style(
            size = dimensions.sizeIconSmall,
            outfitFrame = OutfitFrame.Styl(
                outfitShape = shapes.icon
            )
        ),
    )

    internal val localStyles: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
        error("not provided")
    }

}