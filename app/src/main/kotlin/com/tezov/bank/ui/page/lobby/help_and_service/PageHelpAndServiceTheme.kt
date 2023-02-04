/*
 *  *********************************************************************************
 *  Created by Tezov on 04/02/2023 18:53
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 04/02/2023 17:43
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.lobby.help_and_service

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
import com.tezov.bank.ui.component.branch.SectionActionRow
import com.tezov.bank.ui.component.leaf.ActionRow
import com.tezov.bank.ui.page.auth.help.colors
import com.tezov.bank.ui.page.auth.help.dimensions
import com.tezov.bank.ui.page.auth.help.typographies
import com.tezov.bank.ui.theme.ThemeColors
import com.tezov.bank.ui.theme.ThemeComponent
import com.tezov.lib_core_android_kotlin.ui.theme.definition.dimensionsSizeExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.shapesExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.typographyExtended

val PageHelpAndServiceTheme.colors: PageHelpAndServiceTheme.Colors
    @Composable
    @ReadOnlyComposable
    get() = localColors.current

infix fun PageHelpAndServiceTheme.provides(value: PageHelpAndServiceTheme.Colors) =
    localColors provides value

val PageHelpAndServiceTheme.dimensions: PageHelpAndServiceTheme.Dimensions
    @Composable
    @ReadOnlyComposable
    get() = localDimensions.current

infix fun PageHelpAndServiceTheme.provides(value: PageHelpAndServiceTheme.Dimensions) =
    localDimensions provides value

val PageHelpAndServiceTheme.shapes: PageHelpAndServiceTheme.Shapes
    @Composable
    @ReadOnlyComposable
    get() = localShapes.current

infix fun PageHelpAndServiceTheme.provides(value: PageHelpAndServiceTheme.Shapes) =
    localShapes provides value

val PageHelpAndServiceTheme.borders: PageHelpAndServiceTheme.Borders
    @Composable
    @ReadOnlyComposable
    get() = localBorders.current

infix fun PageHelpAndServiceTheme.provides(value: PageHelpAndServiceTheme.Borders) =
    localBorders provides value

val PageHelpAndServiceTheme.typographies: PageHelpAndServiceTheme.Typographies
    @Composable
    @ReadOnlyComposable
    get() = localTypographies.current

infix fun PageHelpAndServiceTheme.provides(value: PageHelpAndServiceTheme.Typographies) =
    localTypographies provides value

object PageHelpAndServiceTheme {

    data class Colors(
        val background: Color,
        val backgroundSection: Color,
        val onBackgroundLight: Color,
        val onBackgroundDark: Color,
        val icon: Color,
        val divider: Color,
    )

    @Composable
    fun provideColors() = Colors(
        background = MaterialTheme.colors.background,
        backgroundSection = ThemeColors.Data.whiteDark.copy(alpha = 0.10f),
        onBackgroundLight = MaterialTheme.colors.primary,
        onBackgroundDark = MaterialTheme.colors.onSecondary,
        icon = MaterialTheme.colors.primary,
        divider = ThemeColors.Data.grayOverlay,
    )

    internal val localColors: ProvidableCompositionLocal<Colors> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Dimensions(
        val iconCloseSize: Dp,
        val iconCardSize: Dp,
        val iconRowSize: Dp,
        val iconChevronSize: Dp,
        val divider: Dp,
    )

    @Composable
    fun provideDimensions() = Dimensions(
        iconCloseSize = MaterialTheme.dimensionsSizeExtended.iconModal,
        iconCardSize = 48.dp,
        iconRowSize = 32.dp,
        iconChevronSize = 16.dp,
        divider = 2.dp,
    )

    internal val localDimensions: ProvidableCompositionLocal<Dimensions> =
        staticCompositionLocalOf {
            error("not provided")
        }

    data class Shapes(
        val card: Shape,
    )

    @Composable
    fun provideShapes() = Shapes(
        card = MaterialTheme.shapesExtended.cardBig,
    )

    internal val localShapes: ProvidableCompositionLocal<Shapes> = staticCompositionLocalOf {
        error("not provided")
    }


    data class Borders(
        val card: BorderStroke,

        )

    @Composable
    fun provideBorders() = Borders(
        card = BorderStroke(
            1.5.dp,
            ThemeColors.Data.grayOverlay
        ),
    )

    internal val localBorders: ProvidableCompositionLocal<Borders> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Typographies(
        val titleBig: TextStyle,
        val titleNormal: TextStyle,
        val textCard: TextStyle,
        val textRow: TextStyle,
    )

    @Composable
    fun provideTypographies() = Typographies(
        titleBig = MaterialTheme.typographyExtended.textHuge.copy(
            color = colors.onBackgroundDark,
            fontWeight = FontWeight.Bold
        ),
        titleNormal = MaterialTheme.typographyExtended.textNormal.copy(
            color = ThemeColors.Data.grayDark,
            fontWeight = FontWeight.SemiBold
        ),
        textCard = MaterialTheme.typographyExtended.textNormal.copy(
            color = colors.onBackgroundDark,
            fontWeight = FontWeight.Bold
        ),
        textRow = MaterialTheme.typographyExtended.textBig.copy(
            color = colors.onBackgroundDark,
        ),
    )

    internal val localTypographies: ProvidableCompositionLocal<Typographies> =
        staticCompositionLocalOf {
            error("not provided")
        }

    @Composable
    fun provideSectionRowStyle() = ThemeComponent.provideSectionRowStyle()

    @Composable
    fun provideActionRowStyle() = ThemeComponent.provideActionRowStyle()

    @Composable
    fun provideSectionCardStyle() = ThemeComponent.provideSectionCardStyle()

    @Composable
    fun provideActionCardStyle() = ThemeComponent.provideActionCardStyle()

}