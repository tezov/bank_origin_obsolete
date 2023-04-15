/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 19:41
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 18:51
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.auth.account

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
import com.tezov.lib_core_android_kotlin.ui.theme.theme.colorsExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.shapesExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.typographiesExtended

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

val PageAccountTheme.shapes: PageAccountTheme.Shapes
    @Composable
    @ReadOnlyComposable
    get() = localShapes.current

infix fun PageAccountTheme.provides(value: PageAccountTheme.Shapes) = localShapes provides value

val PageAccountTheme.borders: PageAccountTheme.Borders
    @Composable
    @ReadOnlyComposable
    get() = localBorders.current

infix fun PageAccountTheme.provides(value: PageAccountTheme.Borders) = localBorders provides value

val PageAccountTheme.typographies: PageAccountTheme.Typographies
    @Composable
    @ReadOnlyComposable
    get() = localTypographies.current

infix fun PageAccountTheme.provides(value: PageAccountTheme.Typographies) =
    localTypographies provides value

object PageAccountTheme {

    data class Colors(
        val background: Color,
        val textContent: Color,
    )

    @Composable
    fun provideColors() = Colors(
        background = MaterialTheme.colors.primary,
        textContent = MaterialTheme.colorsExtended.onPrimary.accent,
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
        card = MaterialTheme.shapesExtended.element.normal.getShape() ?: MaterialTheme.shapes.small,
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
        title = MaterialTheme.typographiesExtended.title.normal.typo.copy(
            color = colors.textContent
        ),
        normal = MaterialTheme.typographiesExtended.title.normal.typo.copy(
            color = colors.textContent,
            fontWeight = FontWeight.Bold
        ),

        )

    internal val localTypographies: ProvidableCompositionLocal<Typographies> =
        staticCompositionLocalOf {
            error("not provided")
        }

}