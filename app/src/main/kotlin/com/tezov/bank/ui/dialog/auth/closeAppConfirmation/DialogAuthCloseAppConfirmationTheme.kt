/*
 *  *********************************************************************************
 *  Created by Tezov on 26/02/2023 12:51
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 26/02/2023 11:36
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.dialog.auth.closeAppConfirmation

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.tezov.bank.ui.theme.ThemeColors
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*

val DialogAuthCloseAppConfirmationTheme.colors: DialogAuthCloseAppConfirmationTheme.Colors
    @Composable
    @ReadOnlyComposable
    get() = localColors.current

infix fun DialogAuthCloseAppConfirmationTheme.provides(value: DialogAuthCloseAppConfirmationTheme.Colors) =
    localColors provides value

val DialogAuthCloseAppConfirmationTheme.typographies: DialogAuthCloseAppConfirmationTheme.Typographies
    @Composable
    @ReadOnlyComposable
    get() = localTypographies.current

infix fun DialogAuthCloseAppConfirmationTheme.provides(value: DialogAuthCloseAppConfirmationTheme.Typographies) =
    localTypographies provides value

object DialogAuthCloseAppConfirmationTheme {

    data class Colors(
        val background: Color,
        val title: Color,
        val text: Color,
        val button: Color,
    )

    @Composable
    fun provideColors() = Colors(
        background = MaterialTheme.colors.background,
        title = MaterialTheme.colors.onBackground,
        text = ThemeColors.Common.blueShadow,
        button = MaterialTheme.colors.primary,
    )

    internal val localColors: ProvidableCompositionLocal<Colors> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Typographies(
        val title: TextStyle,
        val text: TextStyle,
        val button: TextStyle,
    )

    @Composable
    fun provideTypographies() = Typographies(
        title = MaterialTheme.typographiesSimpleExtended.textTitle.typo.copy(
            color = colors.title,
            fontWeight = FontWeight.Bold
        ),
        text = MaterialTheme.typographiesSimpleExtended.textNormal.typo.copy(
            color = colors.text
        ),
        button = MaterialTheme.typographiesSimpleExtended.textButton.typo.copy(
            color = colors.button,
            fontWeight = FontWeight.Bold
        ),

    )

    internal val localTypographies: ProvidableCompositionLocal<Typographies> =
        staticCompositionLocalOf {
            error("not provided")
        }

}