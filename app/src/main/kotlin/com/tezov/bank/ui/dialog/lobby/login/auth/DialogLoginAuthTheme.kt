/*
 *  *********************************************************************************
 *  Created by Tezov on 14/04/2023 22:46
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 14/04/2023 22:43
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.dialog.lobby.login.auth

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.tezov.lib_core_android_kotlin.ui.component.branch.KeyBoard
import com.tezov.lib_core_android_kotlin.ui.component.plain.Button
import com.tezov.lib_core_android_kotlin.ui.component.plain.Button.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.component.plain.Link
import com.tezov.lib_core_android_kotlin.ui.component.plain.Link.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorder.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitFrame.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitStateDual
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextStateColor
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

infix fun DialogLoginAuthTheme.provides(value: DialogLoginAuthTheme.Style) =
    localStyles provides value

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
        background = MaterialTheme.colorsExtended.background.dark,
        onBackground = MaterialTheme.colorsExtended.onBackground.dark,
        dark = MaterialTheme.colorsExtended.primary.default,
        light = MaterialTheme.colorsExtended.primary.accent,
        fade = MaterialTheme.colorsExtended.primary.fade,
    )

    internal val localColors: ProvidableCompositionLocal<Colors> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Typographies(
        val title: OutfitTextStateColor,
        val input: OutfitTextStateColor,
        val label: OutfitTextStateColor,
    )

    @Composable
    fun provideTypographies() = Typographies(
        title = MaterialTheme.typographiesExtended.title.big.copy {
            outfitState = colors.onBackground.asStateSimple
        },
        input = MaterialTheme.typographiesExtended.input.normal.copy {
            outfitState = colors.onBackground.asStateSimple
        },
        label = MaterialTheme.typographiesExtended.label.normal.copy {
            outfitState = colors.onBackground.asStateSimple
        }
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
        link = MaterialTheme.componentsLinkExtended.primary.copy {
            outfitText = outfitText.copy {
                outfitState = colors.onBackground.asStateSimple
            }
        }
    )

    internal val localStyles: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
        error("not provided")
    }


}