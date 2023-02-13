/*
 *  *********************************************************************************
 *  Created by Tezov on 13/02/2023 21:35
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 13/02/2023 21:32
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.auth.discover

import androidx.compose.foundation.BorderStroke
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.bank.ui.component.branch.SectionActionCard
import com.tezov.bank.ui.component.branch.SectionActionRow
import com.tezov.bank.ui.component.leaf.CardButton
import com.tezov.bank.ui.page.lobby.login.PageLoginTheme
import com.tezov.bank.ui.page.lobby.login.colors
import com.tezov.bank.ui.page.lobby.login.shapes
import com.tezov.bank.ui.page.lobby.login.typographies
import com.tezov.bank.ui.theme.ThemeComponent
import com.tezov.lib_core_android_kotlin.ui.component.branch.HorizontalScrollable
import com.tezov.lib_core_android_kotlin.ui.component.plain.Button
import com.tezov.lib_core_android_kotlin.ui.theme.definition.*

val PageDiscoverTheme.colors: PageDiscoverTheme.Colors
    @Composable
    @ReadOnlyComposable
    get() = localColors.current

infix fun PageDiscoverTheme.provides(value: PageDiscoverTheme.Colors) = localColors provides value

val PageDiscoverTheme.styles: PageDiscoverTheme.Style
    @Composable
    @ReadOnlyComposable
    get() = localStyles.current

infix fun PageDiscoverTheme.provides(value: PageDiscoverTheme.Style) = localStyles provides value

object PageDiscoverTheme {

    data class Colors(
        val background: Color,
    )

    @Composable
    fun provideColors() = Colors(
        background = MaterialTheme.colors.background,
    )

    internal val localColors: ProvidableCompositionLocal<Colors> = staticCompositionLocalOf {
        error("not provided")
    }


    data class Style(
        val carousel: HorizontalScrollable.Pager.Style,
        val cardButton: CardButton.Style,
        val cardLink: CardButton.Style,
        val sectionRow: SectionActionRow.Style,
        val sectionCard: SectionActionCard.Style,
    )

    @Composable
    fun provideStyles() = Style(
        carousel = ThemeComponent.provideCarouselStyle(),
        cardButton = CardButton.Style(),
        cardLink = CardButton.Style(),
        sectionRow = ThemeComponent.provideSectionRowStyle(),
        sectionCard = ThemeComponent.provideSectionCardStyle(),
    )

    internal val localStyles: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
        error("not provided")
    }

}