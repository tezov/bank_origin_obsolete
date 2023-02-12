/*
 *  *********************************************************************************
 *  Created by Tezov on 12/02/2023 17:12
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 12/02/2023 16:50
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
import com.tezov.bank.ui.theme.ThemeComponent
import com.tezov.lib_core_android_kotlin.ui.theme.definition.*

val PageDiscoverTheme.colors: PageDiscoverTheme.Colors
    @Composable
    @ReadOnlyComposable
    get() = localColors.current

infix fun PageDiscoverTheme.provides(value: PageDiscoverTheme.Colors) = localColors provides value

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



    @Composable
    fun provideSectionRowStyle() = ThemeComponent.provideSectionRowStyle()

    @Composable
    fun provideActionRowStyle() = ThemeComponent.provideActionRowStyle()

    @Composable
    fun provideSectionCardStyle() = ThemeComponent.provideSectionCardStyle()

    @Composable
    fun provideActionCardStyle() = ThemeComponent.provideActionCardStyle()

}