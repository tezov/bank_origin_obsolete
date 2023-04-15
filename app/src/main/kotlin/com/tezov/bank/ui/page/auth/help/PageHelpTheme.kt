/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 19:41
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 18:51
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.auth.help

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.tezov.bank.ui.component.branch.SectionActionRow
import com.tezov.bank.ui.component.branch.SectionActionRow.Style.Companion.copy
import com.tezov.bank.ui.component.leaf.ActionRow.Style.Companion.copy
import com.tezov.bank.ui.theme.ThemeComponentProviders
import com.tezov.lib_core_android_kotlin.ui.component.plain.Icon.Simple.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.theme.colorsExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.typographiesExtended

val PageHelpTheme.colors: PageHelpTheme.Colors
    @Composable
    @ReadOnlyComposable
    get() = localColors.current

infix fun PageHelpTheme.provides(value: PageHelpTheme.Colors) = localColors provides value

val PageHelpTheme.typographies: PageHelpTheme.Typographies
    @Composable
    @ReadOnlyComposable
    get() = localTypographies.current

infix fun PageHelpTheme.provides(value: PageHelpTheme.Typographies) =
    localTypographies provides value

val PageHelpTheme.styles: PageHelpTheme.Style
    @Composable
    @ReadOnlyComposable
    get() = localStyles.current

infix fun PageHelpTheme.provides(value: PageHelpTheme.Style) = localStyles provides value

object PageHelpTheme {

    data class Colors(
        val background: Color,
        val backgroundElevated: Color,
        val accent: Color,
        val primary: Color,
        val decor: Color,
        val fade: Color,
    )

    @Composable
    fun provideColors() = Colors(
        background = MaterialTheme.colorsExtended.background.default,
        backgroundElevated = MaterialTheme.colorsExtended.backgroundElevated.default,
        accent = MaterialTheme.colorsExtended.primary.accent,
        primary = MaterialTheme.colorsExtended.primary.default,
        decor = MaterialTheme.colorsExtended.backgroundElevated.decor,
        fade = MaterialTheme.colorsExtended.primary.fade,
    )

    internal val localColors: ProvidableCompositionLocal<Colors> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Typographies(
        val headline: OutfitTextStateColor,
        val subHeadline: OutfitTextStateColor,
        val title: OutfitTextStateColor,
        val body: OutfitTextStateColor,
    )

    @Composable
    fun provideTypographies() = Typographies(
        headline = MaterialTheme.typographiesExtended.title.supra.copy {
            outfitState = colors.primary.asStateSimple
        },
        subHeadline = MaterialTheme.typographiesExtended.title.huge.copy {
            outfitState = colors.primary.asStateSimple
        },
        title = MaterialTheme.typographiesExtended.title.normal.copy {
            outfitState = colors.primary.asStateSimple
        },
        body = MaterialTheme.typographiesExtended.body.normal.copy {
            outfitState = colors.primary.asStateSimple
        },
    )

    internal val localTypographies: ProvidableCompositionLocal<Typographies> =
        staticCompositionLocalOf {
            error("not provided")
        }

    data class Style(
        val sectionRow: SectionActionRow.Style,
    )

    @Composable
    fun provideStyles() = Style(
        sectionRow = ThemeComponentProviders.provideSectionRowStyle().copy {
            dimensionPaddingBody = MaterialTheme.dimensionsPaddingExtended.page.normal.horizontal
            iconStyle = iconStyle.copy { tint = colors.accent }
            outfitTextHeader = outfitTextHeader?.copy {
                outfitState = colors.primary.asStateSimple
            }
            colorDivider = colors.fade
            actionRowStyle = actionRowStyle.copy {
                iconInfoStyle = iconInfoStyle.copy { tint = colors.accent }
                iconActionStyle = iconActionStyle.copy { tint = colors.accent }
                outfitText = outfitText?.copy {
                    outfitState = colors.primary.asStateSimple
                }
            }
        },
    )

    internal val localStyles: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
        error("not provided")
    }


}