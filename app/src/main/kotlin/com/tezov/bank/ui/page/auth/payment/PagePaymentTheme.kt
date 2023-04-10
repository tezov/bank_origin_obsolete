/*
 *  *********************************************************************************
 *  Created by Tezov on 10/04/2023 13:55
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 10/04/2023 13:32
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.auth.payment

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tezov.bank.ui.component.branch.SectionActionCard
import com.tezov.bank.ui.component.branch.SectionActionCard.Style.Companion.copy
import com.tezov.bank.ui.component.leaf.ActionCard.Style.Companion.copy
import com.tezov.bank.ui.theme.ThemeComponentProviders
import com.tezov.bank.ui.theme.colorsPalette
import com.tezov.lib_core_android_kotlin.ui.component.plain.Icon.Simple.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.component.tree.ColumnCollapsibleHeader
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitFrame.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.theme.colorsExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsCommonExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.typographiesExtended

val PagePaymentTheme.colors: PagePaymentTheme.Colors
    @Composable
    @ReadOnlyComposable
    get() = localColors.current

infix fun PagePaymentTheme.provides(value: PagePaymentTheme.Colors) = localColors provides value

val PagePaymentTheme.dimensions: PagePaymentTheme.Dimensions
    @Composable
    @ReadOnlyComposable
    get() = localDimensions.current

infix fun PagePaymentTheme.provides(value: PagePaymentTheme.Dimensions) =
    localDimensions provides value

val PagePaymentTheme.typographies: PagePaymentTheme.Typographies
    @Composable
    @ReadOnlyComposable
    get() = localTypographies.current

infix fun PagePaymentTheme.provides(value: PagePaymentTheme.Typographies) =
    localTypographies provides value

val PagePaymentTheme.styles: PagePaymentTheme.Style
    @Composable
    @ReadOnlyComposable
    get() = localStyles.current

infix fun PagePaymentTheme.provides(value: PagePaymentTheme.Style) = localStyles provides value

object PagePaymentTheme {

    data class Colors(
        val background: Color,
        val backgroundElevated: Color,
        val accent: Color,
        val primary: Color,
        val fade: Color,
    )

    @Composable
    fun provideColors() = Colors(
        background = MaterialTheme.colorsExtended.background.default,
        backgroundElevated = MaterialTheme.colorsExtended.backgroundElevated.default,
        accent = MaterialTheme.colorsExtended.primary.accent,
        primary = MaterialTheme.colorsExtended.primary.default,
        fade = MaterialTheme.colorsPalette.grayLight,
    )

    internal val localColors: ProvidableCompositionLocal<Colors> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Dimensions(
        val sizeTitleMin: TextUnit,
        val sizeTitleMax: TextUnit,
        val heightHeaderDivider: Dp,
        val heightHeader: ColumnCollapsibleHeader.Properties,
    )

    @Composable
    fun provideDimensions() = Dimensions(
        sizeTitleMin = 24.sp,
        sizeTitleMax = 48.sp,
        heightHeaderDivider = MaterialTheme.dimensionsCommonExtended.divider.normal,
        heightHeader = ColumnCollapsibleHeader.Properties(48.dp, 150.dp)
    )

    internal val localDimensions: ProvidableCompositionLocal<Dimensions> =
        staticCompositionLocalOf {
            error("not provided")
        }

    data class Typographies(
        val titleHuge: OutfitTextStateColor,
    )

    @Composable
    fun provideTypographies() = Typographies(
        titleHuge = MaterialTheme.typographiesExtended.title.huge.copy {
            outfitState = colors.primary.asStateSimple
        },
    )

    internal val localTypographies: ProvidableCompositionLocal<Typographies> =
        staticCompositionLocalOf {
            error("not provided")
        }

    data class Style(
        val sectionCard: SectionActionCard.Style,

        )

    @Composable
    fun provideStyles() = Style(
        sectionCard = ThemeComponentProviders.provideSectionCardStyle().copy {
            dimensionPaddingBody = MaterialTheme.dimensionsPaddingExtended.page.normal.horizontal
            iconStyle = iconStyle.copy { tint = colors.primary }
            outfitTextHeader = outfitTextHeader?.copy {
                outfitState = colors.primary.asStateSimple
            }
            actionCardStyle = actionCardStyle.copy{
                iconStyle = iconStyle.copy { tint = colors.accent }
                outfitTextTitle = outfitTextTitle?.copy {
                    outfitState = colors.primary.asStateSimple
                }
                outfitTextSubtitle = outfitTextSubtitle?.copy {
                    outfitState = colors.fade.asStateSimple
                }
                outfitFrame = outfitFrame.copy{
                    outfitShape = outfitShape.copy {
                        outfitState = colors.backgroundElevated.asStateSimple
                    }
                }
            }
        }
    )

    internal val localStyles: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
        error("not provided")
    }
}