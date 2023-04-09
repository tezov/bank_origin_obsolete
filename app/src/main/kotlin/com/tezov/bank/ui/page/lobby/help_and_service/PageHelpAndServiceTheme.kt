/*
 *  *********************************************************************************
 *  Created by Tezov on 10/04/2023 00:50
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 10/04/2023 00:45
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.lobby.help_and_service

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.tezov.bank.ui.component.branch.SectionActionCard
import com.tezov.bank.ui.component.branch.SectionActionCard.Style.Companion.copy
import com.tezov.bank.ui.component.branch.SectionActionRow
import com.tezov.bank.ui.component.branch.SectionActionRow.Style.Companion.copy
import com.tezov.bank.ui.component.leaf.ActionCard.Style.Companion.copy
import com.tezov.bank.ui.component.leaf.ActionRow.Style.Companion.copy
import com.tezov.bank.ui.theme.ThemeComponentProviders
import com.tezov.lib_core_android_kotlin.ui.component.plain.Icon.Simple.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorder.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitFrame.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*

val PageHelpAndServiceTheme.colors: PageHelpAndServiceTheme.Colors
    @Composable
    @ReadOnlyComposable
    get() = localColors.current

infix fun PageHelpAndServiceTheme.provides(value: PageHelpAndServiceTheme.Colors) =
    localColors provides value

val PageHelpAndServiceTheme.typographies: PageHelpAndServiceTheme.Typographies
    @Composable
    @ReadOnlyComposable
    get() = localTypographies.current

infix fun PageHelpAndServiceTheme.provides(value: PageHelpAndServiceTheme.Typographies) =
    localTypographies provides value

val PageHelpAndServiceTheme.styles: PageHelpAndServiceTheme.Style
    @Composable
    @ReadOnlyComposable
    get() = localStyles.current

infix fun PageHelpAndServiceTheme.provides(value: PageHelpAndServiceTheme.Style) =
    localStyles provides value

object PageHelpAndServiceTheme {

    data class Colors(
        val background: Color,
        val onBackgroundAccent: Color,
        val onBackgroundPrimary: Color,
        val backgroundElevated: Color,
        val onBackgroundElevated: Color,
        val fade: Color,
    )

    @Composable
    fun provideColors() = Colors(
        background = MaterialTheme.colorsExtended.background.default,
        onBackgroundAccent = MaterialTheme.colorsExtended.primary.accent,
        onBackgroundPrimary = MaterialTheme.colorsExtended.onBackground.default,
        backgroundElevated = MaterialTheme.colorsExtended.backgroundElevated.default,
        onBackgroundElevated = MaterialTheme.colorsExtended.onBackgroundElevated.default,
        fade = MaterialTheme.colorsExtended.backgroundElevated.default,
    )

    internal val localColors: ProvidableCompositionLocal<Colors> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Typographies(
        val titleBig: TextStyle,
    )

    @Composable
    fun provideTypographies() = Typographies(
        titleBig = MaterialTheme.typographiesExtended.title.normal.typo.copy(
            color = colors.onBackgroundPrimary,
            fontWeight = FontWeight.Bold
        ),
    )

    internal val localTypographies: ProvidableCompositionLocal<Typographies> =
        staticCompositionLocalOf {
            error("not provided")
        }


    data class Style(
        val sectionRow: SectionActionRow.Style,
        val sectionCard: SectionActionCard.Style,
    )

    @Composable
    fun provideStyles() = Style(
        sectionRow = ThemeComponentProviders.provideSectionRowStyle().copy {
            dimensionPaddingBody = MaterialTheme.dimensionsPaddingExtended.page.normal.horizontal
            iconStyle = iconStyle.copy {
                tint = colors.onBackgroundPrimary
            }
            outfitTextHeader = outfitTextHeader?.copy {
                outfitState = colors.onBackgroundPrimary.asStateSimple
            }
            colorDivider = colors.fade
            actionRowStyle = actionRowStyle.copy{
                iconInfoStyle = iconInfoStyle.copy {
                    tint = colors.onBackgroundAccent
                }
                iconActionStyle = iconActionStyle.copy {
                    tint = colors.onBackgroundAccent
                }
                outfitText = outfitText?.copy {
                    outfitState = colors.onBackgroundPrimary.asStateSimple
                }
            }
        },
        sectionCard = ThemeComponentProviders.provideSectionCardStyle().copy {
            dimensionPaddingBody = MaterialTheme.dimensionsPaddingExtended.page.normal.horizontal
            iconStyle = iconStyle.copy {
                tint = colors.onBackgroundPrimary
            }
            outfitTextHeader = outfitTextHeader?.copy {
                outfitState = colors.onBackgroundPrimary.asStateSimple
            }
            actionCardStyle = actionCardStyle.copy{
                iconStyle = iconStyle.copy {
                    tint = colors.onBackgroundAccent
                }
                outfitTextTitle = outfitTextTitle?.copy {
                    outfitState = colors.onBackgroundPrimary.asStateSimple
                }
                outfitFrame = outfitFrame.copy{
                    outfitBorder = outfitBorder.copy {
                        outfitState = colors.fade.asStateSimple
                    }
                }
            }
        },
    )

    internal val localStyles: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
        error("not provided")
    }

}