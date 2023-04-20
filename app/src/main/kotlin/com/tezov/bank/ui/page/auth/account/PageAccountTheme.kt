/*
 *  *********************************************************************************
 *  Created by Tezov on 20/04/2023 20:47
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 20/04/2023 20:04
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.auth.account

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tezov.bank.ui.component.block.SectionAccountValueSimpleRow
import com.tezov.bank.ui.component.block.SectionAccountValueSimpleRow.Style.Companion.copy
import com.tezov.bank.ui.component.element.AccountSummaryCard
import com.tezov.bank.ui.component.element.AccountValueSimpleRow.Style.Companion.copy
import com.tezov.bank.ui.theme.ThemeComponentProviders
import com.tezov.lib_core_android_kotlin.ui.component.layout.ColumnCollapsibleHeader
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitFrame
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitFrame.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitFrameStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*

val PageAccountTheme.colors: PageAccountTheme.Colors
    @Composable
    @ReadOnlyComposable
    get() = localColors.current

infix fun PageAccountTheme.provides(value: PageAccountTheme.Colors) = localColors provides value

val PageAccountTheme.dimensions: PageAccountTheme.Dimensions
    @Composable
    @ReadOnlyComposable
    get() = localDimensions.current

infix fun PageAccountTheme.provides(value: PageAccountTheme.Dimensions) =
    localDimensions provides value

val PageAccountTheme.typographies: PageAccountTheme.Typographies
    @Composable
    @ReadOnlyComposable
    get() = localTypographies.current

infix fun PageAccountTheme.provides(value: PageAccountTheme.Typographies) =
    localTypographies provides value

val PageAccountTheme.styles: PageAccountTheme.Style
    @Composable
    @ReadOnlyComposable
    get() = localStyles.current

infix fun PageAccountTheme.provides(value: PageAccountTheme.Style) = localStyles provides value


object PageAccountTheme {

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
        fade = MaterialTheme.colorsExtended.primary.fade,
    )

    internal val localColors: ProvidableCompositionLocal<Colors> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Dimensions(
        val headLineMin: TextUnit,
        val headlineMax: TextUnit,
        val headerProperties: ColumnCollapsibleHeader.Properties,
    )

    @Composable
    fun provideDimensions() = Dimensions(
        headLineMin = 24.sp,
        headlineMax = 54.sp,
        headerProperties = ColumnCollapsibleHeader.Properties(50.dp, 156.dp)
    )

    internal val localDimensions: ProvidableCompositionLocal<Dimensions> =
        staticCompositionLocalOf {
            error("not provided")
        }


    data class Typographies(
        val headline: OutfitTextStateColor,
    )

    @Composable
    fun provideTypographies() = Typographies(
        headline = MaterialTheme.typographiesExtended.title.supra.copy {
            outfitState = colors.primary.asStateSimple
        },
    )

    internal val localTypographies: ProvidableCompositionLocal<Typographies> =
        staticCompositionLocalOf {
            error("not provided")
        }

    data class Style(
        val sectionAccountValue: SectionAccountValueSimpleRow.Style,
        val accountSummary: AccountSummaryCard.Style,

        )

    @Composable
    fun provideStyles() = Style(
        sectionAccountValue = ThemeComponentProviders.sectionAccountValueSimpleRowStyle().copy {
            paddingBody = MaterialTheme.dimensionsPaddingExtended.page.normal.horizontal
            outfitTextTitle = outfitTextTitle?.copy {
                outfitState = colors.primary.asStateSimple
            }
            colorDivider = colors.fade
            rowStyle = rowStyle.copy {
                outfitTextTitle = outfitTextTitle?.copy {
                    outfitState = colors.primary.asStateSimple
                }
                outfitTextSubTitle = outfitTextSubTitle?.copy {
                    outfitState = colors.fade.asStateSimple
                }
                outfitTextAmount = outfitTextAmount?.copy {
                    outfitState = colors.primary.asStateSimple
                }
            }
        },
        accountSummary = AccountSummaryCard.Style(
            outfitFrame = OutfitFrameStateColor(
              outfitShape = MaterialTheme.shapesExtended.element.big.copy{
                  outfitState = colors.backgroundElevated.asStateSimple
              }
            ),
            outfitTextTitle = MaterialTheme.typographiesExtended.body.normal.copy {
                outfitState = colors.primary.asStateSimple
            },
            outfitTextSubTitle = MaterialTheme.typographiesExtended.helper.normal.copy {
                outfitState = colors.fade.asStateSimple
            },
            outfitTextAmount = MaterialTheme.typographiesExtended.body.normal.copy {
                outfitState = colors.primary.asStateSimple
            },
        )
    )

    internal val localStyles: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
        error("not provided")
    }

}