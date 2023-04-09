/*
 *  *********************************************************************************
 *  Created by Tezov on 09/04/2023 22:55
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 09/04/2023 22:29
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.tezov.bank.ui.page.lobby.login.colors
import com.tezov.bank.ui.theme.ThemeColorProviders
import com.tezov.bank.ui.theme.colorsPalette
import com.tezov.lib_core_android_kotlin.ui.component.branch.KeyBoard
import com.tezov.lib_core_android_kotlin.ui.component.plain.Button
import com.tezov.lib_core_android_kotlin.ui.component.plain.Button.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.component.plain.Link
import com.tezov.lib_core_android_kotlin.ui.component.plain.Link.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorder.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitFrame.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*

val DialogLoginAuthTheme.colors: DialogLoginAuthTheme.Colors
    @Composable
    @ReadOnlyComposable
    get() = localColors.current

infix fun DialogLoginAuthTheme.provides(value: DialogLoginAuthTheme.Colors) =
    localColors provides value

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
        val dark: Color,
        val light: Color,
        val fade: Color,
    )

    @Composable
    fun provideColors() = Colors(
        background = ThemeColorProviders.Palette.blackOverlay,
        onBackground = MaterialTheme.colorsExtended.onPrimary.accent,
        dark = MaterialTheme.colorsExtended.primary.fade,
        light = MaterialTheme.colorsExtended.primary.accent,
        fade = MaterialTheme.colorsPalette.grayLight,
    )

    internal val localColors: ProvidableCompositionLocal<Colors> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Typographies(
        val title: TextStyle,
        val fieldValue: TextStyle,
        val fieldLabel: TextStyle,
    )

    @Composable
    fun provideTypographies() = Typographies(
        title = MaterialTheme.typographiesExtended.title.normal.typo.copy(
            color = colors.onBackground
        ),
        fieldValue = MaterialTheme.typographiesExtended.input.normal.typo.copy(
            color = colors.onBackground
        ),
        fieldLabel = MaterialTheme.typographiesExtended.label.normal.typo.copy(
            color = colors.onBackground
        )
    )

    internal val localTypographies: ProvidableCompositionLocal<Typographies> =
        staticCompositionLocalOf {
            error("not provided")
        }

    data class Style(
        val keyBoardGridCube: KeyBoard.GridCube.Style,
        val button: Button.StateColor.Style,
        val link: Link.StateColor.Style,
    )

    @Composable
    fun provideStyles() = Style(
        keyBoardGridCube = KeyBoard.GridCube.Style(
            colorOnBackground = colors.onBackground,
            outfitBorderOuter = MaterialTheme.bordersExtended.block.normal.copy {
                outfitState = colors.onBackground.asStateSimple
            },
            outfitBorderInner = MaterialTheme.bordersExtended.block.small.copy {
                outfitState = colors.onBackground.asStateSimple
            },
        ),
        button = MaterialTheme.componentsButtonExtended.primary.copy {
            outfitFrame = outfitFrame.copy {
                outfitShape = outfitShape.copy {
                    outfitState = OutfitStateDual(
                        active = colors.light,
                        inactive = colors.dark
                    )
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
        }
    )

    internal val localStyles: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
        error("not provided")
    }


}