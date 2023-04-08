/*
 *  *********************************************************************************
 *  Created by Tezov on 08/04/2023 22:36
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/04/2023 22:31
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
import com.tezov.bank.ui.theme.ThemeComponentProviders
import com.tezov.lib_core_android_kotlin.type.primaire.DpSize
import com.tezov.lib_core_android_kotlin.type.primaire.dpSize
import com.tezov.lib_core_android_kotlin.ui.component.branch.HorizontalScrollable
import com.tezov.lib_core_android_kotlin.ui.component.plain.Button
import com.tezov.lib_core_android_kotlin.ui.component.plain.Button.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.component.plain.Icon
import com.tezov.lib_core_android_kotlin.ui.component.plain.Image
import com.tezov.lib_core_android_kotlin.ui.component.plain.Link
import com.tezov.lib_core_android_kotlin.ui.component.plain.Link.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorder.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitFrame.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPalette.Size.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
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
        val onBackground: Color,
        val backgroundDropDownMenu: Color,
        val onBackgroundDropDownMenu: Color,
        val dark: Color,
        val fade: Color,
    )

    @Composable
    fun provideColors() = Colors(
        background = MaterialTheme.colorsExtended.background.accent,
        onBackground = MaterialTheme.colorsExtended.onBackground.accent,
        backgroundDropDownMenu = MaterialTheme.colorsExtended.backgroundModal.default,
        onBackgroundDropDownMenu = MaterialTheme.colorsExtended.onBackgroundModal.default,
        dark = MaterialTheme.colorsExtended.primary.dark,
        fade = MaterialTheme.colorsExtended.primary.fade,
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
    )

    @Composable
    fun provideDimensions() = Dimensions(
        spacingTopToTitle = 24.dp,
        spacingTopFromLinkService = MaterialTheme.dimensionsPaddingExtended.chunk.big.vertical,
        sizeLogo = 64.dpSize,
        sizeIconBig = 52.dpSize,
        paddingStartToIconBig = 28.dp,
        sizeIconMedium = 38.dpSize,
        paddingStartToIconMedium = 12.dp,
        sizeIconSmall = 42.dpSize,
    )

    internal val localDimensions: ProvidableCompositionLocal<Dimensions> =
        staticCompositionLocalOf {
            error("not provided")
        }

    data class Shapes(
        val icon: OutfitShapeStateColor,
    )

    @Composable
    fun provideShapes() = Shapes(
        icon = MaterialTheme.shapesExtended.icon.normal
    )

    internal val localShapes: ProvidableCompositionLocal<Shapes> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Borders(
        val icon: OutfitBorderStateColor,
    )

    @Composable
    fun provideBorders() = Borders(
        icon = MaterialTheme.bordersExtended.icon.normal,
    )

    internal val localBorders: ProvidableCompositionLocal<Borders> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Typographies(
        val supra: OutfitTextStateColor,
        val huge: OutfitTextStateColor,
        val body: OutfitTextStateColor,
        val dropDownMenu: OutfitTextStateColor,
    )

    @Composable
    fun provideTypographies() = Typographies(
        supra = MaterialTheme.typographiesExtended.title.supra.copy {
            outfitState = colors.onBackground.asStateSimple
        },
        huge = MaterialTheme.typographiesExtended.title.huge.copy {
            outfitState = colors.onBackground.asStateSimple
        },
        body = MaterialTheme.typographiesExtended.body.normal.copy {
            outfitState = colors.onBackground.asStateSimple
            typo = typo.copy(fontWeight = FontWeight.Bold)
        },
        dropDownMenu = MaterialTheme.typographiesExtended.menu.normal.copy {
            outfitState = colors.onBackgroundDropDownMenu.asStateSimple
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
                outfitShape = outfitShape.copy {
                    outfitState = colors.dark.asStateSimple
                }
            }
            outfitText = outfitText.copy {
                outfitState = colors.onBackground.asStateSimple
            }
        },
        buttonLight = MaterialTheme.componentsButtonExtended.secondary.copy {
            outfitFrame = outfitFrame.copy {
                outfitShape = outfitShape.copy {
                    outfitState = colors.onBackground.asStateSimple
                }
                outfitBorder = outfitBorder.copy {
                    outfitState = colors.fade.asStateSimple
                }
            }
            outfitText = outfitText.copy {
                outfitState = colors.dark.asStateSimple

            }
        },
        buttonOutlined = MaterialTheme.componentsButtonExtended.tertiary.copy {
            outfitFrame = outfitFrame.copy {
                outfitBorder = outfitBorder.copy {
                    outfitState = colors.onBackground.asStateSimple
                }
            }
            outfitText = outfitText.copy {
                outfitState = colors.onBackground.asStateSimple
            }
        },
        link = MaterialTheme.componentsLinkExtended.primary.copy{
            outfitText = outfitText.copy {
                outfitState = colors.dark.asStateSimple
            }
        },
        logo = Image.Simple.Style(
            size = dimensions.sizeLogo,
            contentScale = ContentScale.Crop
        ),
        iconBig = Image.StateColor.Style(
            size = dimensions.sizeIconBig,
//            outfitFrame = OutfitFrameStateColor(
//                outfitShape = shapes.icon,
//                outfitBorder = borders.icon.copy {
//                    outfitState = OutfitStateSimple(
//                        Color.Black
//                    )
//                }
//            )
        ),
        iconMedium = Icon.StateColor.Style(
            size = dimensions.sizeIconMedium,
//            outfitFrame = OutfitFrameStateColor(
//                outfitShape = shapes.icon
//            )
        ),
        iconSmall = Icon.StateColor.Style(
            size = dimensions.sizeIconSmall,
//            outfitFrame = OutfitFrameStateColor(
//                outfitShape = shapes.icon
//            )
        ),
    )

    internal val localStyles: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
        error("not provided")
    }

}