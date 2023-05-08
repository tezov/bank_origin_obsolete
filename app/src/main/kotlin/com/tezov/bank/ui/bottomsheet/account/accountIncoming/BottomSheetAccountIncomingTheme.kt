/*
 *  *********************************************************************************
 *  Created by Tezov on 08/05/2023 14:37
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/05/2023 14:25
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.bottomsheet.account.accountIncoming

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*

val BottomSheetAccountIncomingTheme.colors: BottomSheetAccountIncomingTheme.Colors
    @Composable
    @ReadOnlyComposable
    get() = localColors.current

infix fun BottomSheetAccountIncomingTheme.provides(value: BottomSheetAccountIncomingTheme.Colors) =
    localColors provides value

val BottomSheetAccountIncomingTheme.typographies: BottomSheetAccountIncomingTheme.Typographies
    @Composable
    @ReadOnlyComposable
    get() = localTypographies.current

infix fun BottomSheetAccountIncomingTheme.provides(value: BottomSheetAccountIncomingTheme.Typographies) =
    localTypographies provides value

val BottomSheetAccountIncomingTheme.styles: BottomSheetAccountIncomingTheme.Style
    @Composable
    @ReadOnlyComposable
    get() = localStyles.current

infix fun BottomSheetAccountIncomingTheme.provides(value: BottomSheetAccountIncomingTheme.Style) =
    localStyles provides value

object BottomSheetAccountIncomingTheme {

    data class Colors(
        val onBackground: Color,
        val dark: Color,
        val light: Color,
        val fade: Color,
    )

    @Composable
    fun provideColors() = Colors(
        onBackground = MaterialTheme.colorsExtended.onBackgroundModal.default,
        dark = MaterialTheme.colorsExtended.primary.shady,
        light = MaterialTheme.colorsExtended.primary.accent,
        fade = MaterialTheme.colorsExtended.primary.fade,
    )

    internal val localColors: ProvidableCompositionLocal<Colors> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Typographies(
        val title: OutfitTextStateColor,
    )

    @Composable
    fun provideTypographies() = Typographies(
        title = MaterialTheme.typographiesExtended.title.big.copy {
            outfitState = colors.onBackground.asStateSimple
            typo = typo.copy(textAlign = TextAlign.Center)
        },
    )

    internal val localTypographies: ProvidableCompositionLocal<Typographies> =
        staticCompositionLocalOf {
            error("not provided")
        }

    data class Style(
        val dummy: Any,
    )

    @Composable
    fun provideStyles() = Style(
        dummy = Any()
    )

    internal val localStyles: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
        error("not provided")
    }


}