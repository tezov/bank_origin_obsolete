/*
 *  *********************************************************************************
 *  Created by Tezov on 23/04/2023 17:27
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 23/04/2023 17:18
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
import com.tezov.bank.ui.theme.ThemeComponentProviders
import com.tezov.lib_core_android_kotlin.type.primaire.DpSize
import com.tezov.lib_core_android_kotlin.type.primaire.dpSize
import com.tezov.lib_core_android_kotlin.ui.component.block.HorizontalPager
import com.tezov.lib_core_android_kotlin.ui.component.block.HorizontalPager.Page.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Button
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Button.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Icon
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Image
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Link
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Link.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorder.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitFrame.StateColor.Style.Companion.copy
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
        val light: Color,
        val fade: Color,
    )

    @Composable
    fun provideColors() = Colors(
        background = MaterialTheme.colorsExtended.background.accent,
        onBackground = MaterialTheme.colorsExtended.onBackground.accent,
        backgroundDropDownMenu = MaterialTheme.colorsExtended.backgroundModal.default,
        onBackgroundDropDownMenu = MaterialTheme.colorsExtended.onBackgroundModal.default,
        dark = MaterialTheme.colorsExtended.primary.default,
        light = MaterialTheme.colorsExtended.primary.shiny.copy(alpha = 0.65f),
        fade = MaterialTheme.colorsExtended.primary.fade.copy(alpha = 0.35f),
    )

    internal val localColors: ProvidableCompositionLocal<Colors> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Dimensions(
        val spacingTopToTitle: Dp,
        val spacingTopFromLinkService: Dp,
        val logo: DpSize,
        val iconBig: DpSize,
        val paddingStartToIconBig: Dp,
        val iconMedium: DpSize,
        val paddingStartToIconMedium: Dp,
        val iconSmall: DpSize,
    )

    @Composable
    fun provideDimensions() = Dimensions(
        spacingTopToTitle = MaterialTheme.dimensionsPaddingExtended.element.huge.vertical,
        spacingTopFromLinkService = MaterialTheme.dimensionsPaddingExtended.element.supra.vertical,
        logo = 58.dpSize,
        iconBig = 48.dpSize,
        paddingStartToIconBig = MaterialTheme.dimensionsPaddingExtended.element.normal.horizontal,
        iconMedium = 32.dpSize,
        paddingStartToIconMedium = MaterialTheme.dimensionsPaddingExtended.element.normal.horizontal,
        iconSmall = 38.dpSize,
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
            typo = typo.copy(
                fontWeight = FontWeight.Bold
            )
        },
        body = MaterialTheme.typographiesExtended.helper.big.copy {
            outfitState = colors.onBackground.asStateSimple
        },
        dropDownMenu = MaterialTheme.typographiesExtended.menu.normal.copy {
            outfitState = colors.onBackgroundDropDownMenu.asStateSimple
        }
    )

    internal val localTypographies: ProvidableCompositionLocal<Typographies> =
        staticCompositionLocalOf {
            error("not provided")
        }

    data class Style(
        val pager: HorizontalPager.Page.Style,
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
        pager = ThemeComponentProviders.pagerStyle().copy {
            outfitShapeIndicator = OutfitShapeStateColor(
                outfitState = OutfitStateBiStable(
                    active = colors.dark,
                    inactive = colors.dark.copy(alpha = 0.45f),
                )
            )
        },
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
        link = MaterialTheme.componentsLinkExtended.secondary.copy {
            outfitText = outfitText.copy {
                outfitState = colors.onBackground.asStateSimple
            }
        },
        logo = Image.Simple.Style(
            size = dimensions.logo,
            contentScale = ContentScale.Crop
        ),
        iconBig = Image.StateColor.Style(
            size = dimensions.iconBig,
            outfitFrame = OutfitFrameStateColor(
                outfitShape = shapes.icon,
                outfitBorder = borders.icon.copy {
                    outfitState = colors.light.asStateSimple
                }
            )
        ),
        iconMedium = Icon.StateColor.Style(
            size = dimensions.iconMedium,
            tint = colors.background,
            outfitFrame = OutfitFrameStateColor(
                outfitShape = shapes.icon.copy {
                    outfitState = colors.onBackground.asStateSimple
                }
            )
        ),
        iconSmall = Icon.StateColor.Style(
            size = dimensions.iconSmall,
            tint = colors.onBackground,
            outfitFrame = OutfitFrameStateColor(
                outfitShape = shapes.icon.copy {
                    outfitState = colors.dark.asStateSimple
                }
            )
        ),
    )

    internal val localStyles: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
        error("not provided")
    }

}