/*
 *  *********************************************************************************
 *  Created by Tezov on 08/04/2023 19:53
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/04/2023 19:49
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tezov.bank.ui.component.branch.SectionActionCard
import com.tezov.bank.ui.theme.ThemeComponentProviders
import com.tezov.lib_core_android_kotlin.ui.component.tree.ColumnCollapsibleHeader
import com.tezov.lib_core_android_kotlin.ui.theme.theme.colorsExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsCommonExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsIconExtended
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
        val textTitle: Color,
        val headerDivider: Color,
    )

    @Composable
    fun provideColors() = Colors(
        background = MaterialTheme.colors.background,
        textTitle = MaterialTheme.colors.primaryVariant,
        headerDivider = MaterialTheme.colorsExtended.backgroundElevated.accent.copy(
            alpha = 0.05f
        ),
    )

    internal val localColors: ProvidableCompositionLocal<Colors> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Dimensions(
        val textTitleMin: TextUnit,
        val textTitleMax: TextUnit,
        val headerDividerSize: Dp,
        val headerHeight: ColumnCollapsibleHeader.Properties,
    )

    @Composable
    fun provideDimensions() = Dimensions(
        textTitleMin = 24.sp,
        textTitleMax = 48.sp,
        headerDividerSize = MaterialTheme.dimensionsCommonExtended.divider.normal,
        headerHeight = ColumnCollapsibleHeader.Properties(48.dp, 150.dp)
    )

    internal val localDimensions: ProvidableCompositionLocal<Dimensions> =
        staticCompositionLocalOf {
            error("not provided")
        }

    data class Typographies(
        val title: TextStyle,
    )

    @Composable
    fun provideTypographies() = Typographies(
        title = MaterialTheme.typographiesExtended.title.normal.typo.copy(
            color = colors.textTitle,
            fontWeight = FontWeight.Bold
        ),
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
        sectionCard = ThemeComponentProviders.provideSectionCardStyle(),
    )

    internal val localStyles: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
        error("not provided")
    }
}