/*
 *  *********************************************************************************
 *  Created by Tezov on 08/04/2023 15:32
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/04/2023 15:29
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.tezov.bank.ui.component.branch.SectionActionRow
import com.tezov.bank.ui.theme.ThemeComponentProviders
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*

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
        val textTitle: Color,
        val textNormal: Color,
    )

    @Composable
    fun provideColors() = Colors(
        background = MaterialTheme.colors.background,
        textTitle = MaterialTheme.colors.primaryVariant,
        textNormal = MaterialTheme.colors.onSecondary,
    )

    internal val localColors: ProvidableCompositionLocal<Colors> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Typographies(
        val titleHuge: TextStyle,
        val titleBig: TextStyle,
        val normal: TextStyle,
    )

    @Composable
    fun provideTypographies() = Typographies(
        titleHuge = MaterialTheme.typographiesExtended.textHuge.typo.copy(
            color = colors.textTitle,
            fontWeight = FontWeight.Bold
        ),
        titleBig = MaterialTheme.typographiesExtended.textBig.typo.copy(
            color = colors.textTitle,
            fontWeight = FontWeight.SemiBold
        ),
        normal = MaterialTheme.typographiesExtended.textNormal.typo.copy(
            color = colors.textNormal
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