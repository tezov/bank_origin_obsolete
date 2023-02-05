/*
 *  *********************************************************************************
 *  Created by Tezov on 05/02/2023 18:22
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 05/02/2023 17:44
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
import com.tezov.bank.ui.theme.ThemeColors
import com.tezov.bank.ui.theme.ThemeComponent
import com.tezov.lib_core_android_kotlin.ui.theme.definition.colorsCommonExtended
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

val PageHelpAndServiceTheme.typographies: PageHelpAndServiceTheme.Typographies
    @Composable
    @ReadOnlyComposable
    get() = localTypographies.current

infix fun PageHelpAndServiceTheme.provides(value: PageHelpAndServiceTheme.Typographies) =
    localTypographies provides value

object PageHelpAndServiceTheme {

    data class Colors(
        val background: Color,
        val backgroundElevated: Color,
        val onBackground: Color,
        val iconClose: Color,
    )

    @Composable
    fun provideColors() = Colors(
        background = MaterialTheme.colors.background,
        backgroundElevated = MaterialTheme.colorsCommonExtended.backgroundElevated,
        onBackground = MaterialTheme.colors.onBackground,
        iconClose = MaterialTheme.colors.primary,
    )

    internal val localColors: ProvidableCompositionLocal<Colors> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Dimensions(
        val iconCloseSize: Dp
    )

    @Composable
    fun provideDimensions() = Dimensions(
        iconCloseSize = MaterialTheme.dimensionsSizeExtended.iconModal,
    )

    internal val localDimensions: ProvidableCompositionLocal<Dimensions> =
        staticCompositionLocalOf {
            error("not provided")
        }

    data class Typographies(
        val titleBig: TextStyle,
    )

    @Composable
    fun provideTypographies() = Typographies(
        titleBig = MaterialTheme.typographyExtended.textHuge.copy(
            color = colors.onBackground,
            fontWeight = FontWeight.Bold
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