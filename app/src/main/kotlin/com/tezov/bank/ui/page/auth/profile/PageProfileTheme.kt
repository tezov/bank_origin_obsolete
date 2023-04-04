/*
 *  *********************************************************************************
 *  Created by Tezov on 04/04/2023 21:22
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 04/04/2023 21:22
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.auth.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.bank.ui.component.branch.SectionActionRow
import com.tezov.bank.ui.theme.ThemeComponentProviders
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*

val PageProfileTheme.colors: PageProfileTheme.Colors
    @Composable
    @ReadOnlyComposable
    get() = localColors.current

infix fun PageProfileTheme.provides(value: PageProfileTheme.Colors) = localColors provides value

val PageProfileTheme.dimensions: PageProfileTheme.Dimensions
    @Composable
    @ReadOnlyComposable
    get() = localDimensions.current

infix fun PageProfileTheme.provides(value: PageProfileTheme.Dimensions) =
    localDimensions provides value

val PageProfileTheme.borders: PageProfileTheme.Borders
    @Composable
    @ReadOnlyComposable
    get() = localBorders.current

infix fun PageProfileTheme.provides(value: PageProfileTheme.Borders) = localBorders provides value

val PageProfileTheme.typographies: PageProfileTheme.Typographies
    @Composable
    @ReadOnlyComposable
    get() = localTypographies.current

infix fun PageProfileTheme.provides(value: PageProfileTheme.Typographies) =
    localTypographies provides value

val PageProfileTheme.styles: PageProfileTheme.Style
    @Composable
    @ReadOnlyComposable
    get() = localStyles.current

infix fun PageProfileTheme.provides(value: PageProfileTheme.Style) = localStyles provides value

object PageProfileTheme {

    data class Colors(
        val background: Color,
        val textContent: Color,
        val iconUser: Color,
        val iconLogout: Color,
    )

    @Composable
    fun provideColors() = Colors(
        background = MaterialTheme.colors.background,
        textContent = MaterialTheme.colors.primaryVariant,
        iconUser = MaterialTheme.colors.primary,
        iconLogout = MaterialTheme.colors.primary,
    )

    internal val localColors: ProvidableCompositionLocal<Colors> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Dimensions(
        val iconCloseSize: Dp,
        val iconUserSize: Dp,
    )

    @Composable
    fun provideDimensions() = Dimensions(
        iconCloseSize = MaterialTheme.dimensionsSizeExtended.iconModal.width,
        iconUserSize = 84.dp,
    )

    internal val localDimensions: ProvidableCompositionLocal<Dimensions> =
        staticCompositionLocalOf {
            error("not provided")
        }

    data class Borders(
        val iconUser: BorderStroke,
    )

    @Composable
    fun provideBorders() = Borders(
//        iconUser = MaterialTheme.bordersExtended.strokeBig.resolveOrDefault(colors.iconUser)
        iconUser = TODO()
    )

    internal val localBorders: ProvidableCompositionLocal<Borders> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Typographies(
        val title: TextStyle,
        val normal: TextStyle,
    )

    @Composable
    fun provideTypographies() = Typographies(
        title = MaterialTheme.typographiesTextExtended.textHuge.typo.copy(
            color = colors.textContent,
            fontWeight = FontWeight.Bold
        ),
        normal = MaterialTheme.typographiesTextExtended.textNormal.typo.copy(
            color = colors.textContent,
            fontWeight = FontWeight.Bold
        ),

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
        sectionRow = ThemeComponentProviders.provideSectionRowStyle(),
    )

    internal val localStyles: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
        error("not provided")
    }

}