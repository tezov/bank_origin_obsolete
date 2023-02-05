/*
 *  *********************************************************************************
 *  Created by Tezov on 05/02/2023 13:38
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 05/02/2023 13:30
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
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.bank.ui.theme.ThemeComponent
import com.tezov.lib_core_android_kotlin.ui.theme.definition.colorsCommonExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.shapesExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.typographyExtended

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

val PageProfileTheme.shapes: PageProfileTheme.Shapes
    @Composable
    @ReadOnlyComposable
    get() = localShapes.current

infix fun PageProfileTheme.provides(value: PageProfileTheme.Shapes) = localShapes provides value

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

object PageProfileTheme {

    data class Colors(
        val background: Color,
        val textContent: Color,
    )

    @Composable
    fun provideColors() = Colors(
        background = MaterialTheme.colors.primary,
        textContent = MaterialTheme.colorsCommonExtended.onPrimaryLight,
    )

    internal val localColors: ProvidableCompositionLocal<Colors> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Dimensions(
        val iconSize: Dp,
    )

    @Composable
    fun provideDimensions() = Dimensions(
        iconSize = 24.dp,
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
        card = MaterialTheme.shapesExtended.cardNormal,
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
            2.dp,
            colors.textContent
        )
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
        title = MaterialTheme.typographyExtended.textTitle.copy(
            color = colors.textContent
        ),
        normal = MaterialTheme.typographyExtended.textNormal.copy(
            color = colors.textContent,
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

}