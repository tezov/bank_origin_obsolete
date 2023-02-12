/*
 *  *********************************************************************************
 *  Created by Tezov on 12/02/2023 16:03
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 12/02/2023 15:51
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
import com.tezov.lib_core_android_kotlin.ui.component.tree.ColumnCollapsibleHeader
import com.tezov.bank.ui.theme.ThemeComponent
import com.tezov.lib_core_android_kotlin.ui.theme.definition.colorsCommonExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.dimensionsSizeExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.typographyExtended

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
        headerDivider = MaterialTheme.colorsCommonExtended.backgroundElevated.copy(
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
        headerDividerSize = MaterialTheme.dimensionsSizeExtended.dividerSmall,
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
        title = MaterialTheme.typographyExtended.textTitle.copy(
            color = colors.textTitle,
            fontWeight = FontWeight.Bold
        ),
    )

    internal val localTypographies: ProvidableCompositionLocal<Typographies> =
        staticCompositionLocalOf {
            error("not provided")
        }

    @Composable
    fun provideSectionCardStyle() = ThemeComponent.provideSectionCardStyle()

    @Composable
    fun provideActionCardStyle() = ThemeComponent.provideActionCardStyle()

}