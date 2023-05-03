/*
 *  *********************************************************************************
 *  Created by Tezov on 03/05/2023 22:54
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 03/05/2023 22:52
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tezov.bank.ui.component.block.SectionAccountValueSimpleRow
import com.tezov.bank.ui.component.block.SectionAccountValueSimpleRow.Style.Companion.copy
import com.tezov.bank.ui.component.element.AccountSummaryCard
import com.tezov.bank.ui.component.element.AccountSummaryCard.Style.Companion.copy
import com.tezov.bank.ui.theme.ThemeComponentProviders
import com.tezov.lib_core_android_kotlin.ui.component.chunk.DropDownMenu.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Icon
import com.tezov.lib_core_android_kotlin.ui.component.layout.ColumnCollapsibleHeader
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
        val backgroundElevatedOverlay: Color,
        val accent: Color,
        val primary: Color,
        val fade: Color,
    )

    @Composable
    fun provideColors() = Colors(
        background = MaterialTheme.colorsExtended.background.default,
        backgroundElevated = MaterialTheme.colorsExtended.backgroundElevated.default,
        backgroundElevatedOverlay = MaterialTheme.colorsExtended.backgroundElevated.overlay,
        accent = MaterialTheme.colorsExtended.primary.accent,
        primary = MaterialTheme.colorsExtended.primary.default,
        fade = MaterialTheme.colorsExtended.primary.fade,
    )

    internal val localColors: ProvidableCompositionLocal<Colors> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Dimensions(
        val spacingBottomHeaderBackground: Dp,
        val headerProperties: ColumnCollapsibleHeader.Properties,
    )

    @Composable
    fun provideDimensions() = Dimensions(
        spacingBottomHeaderBackground = 56.dp,
        headerProperties = ColumnCollapsibleHeader.Properties(
            min = (MaterialTheme.dimensionsPaddingExtended.element.normal.vertical * 2) + 80.dp,
            max = (MaterialTheme.dimensionsPaddingExtended.element.normal.vertical * 2) + 184.dp
        )
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
        val icon: Icon.StateColor.Style,
        val sectionAccountValue: SectionAccountValueSimpleRow.Style,
        val accountSummary: AccountSummaryCard.Style,

        )

    @Composable
    fun provideStyles() = Style(
        icon = Icon.StateColor.Style(
            size = MaterialTheme.dimensionsIconExtended.action.big,
            tint = colors.background,
            outfitFrame = OutfitFrameStateColor(
                outfitShape = MaterialTheme.shapesExtended.icon.normal.copy {
                    outfitState = colors.primary.asStateSimple
                }
            )
        ),
        sectionAccountValue = ThemeComponentProviders.sectionAccountValueSimpleRowStyle().copy {
            paddingBody = MaterialTheme.dimensionsPaddingExtended.page.normal.horizontal
        },
        accountSummary = ThemeComponentProviders.accountSummaryCard().copy{
            dropDownMenuStyle = dropDownMenuStyle.copy{
                iconStyle = Icon.StateColor.Style(
                    size = MaterialTheme.dimensionsIconExtended.action.normal,
                    tint = MaterialTheme.colorsExtended.onPrimary.default,
                )
            }
        }
    )

    internal val localStyles: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
        error("not provided")
    }

}