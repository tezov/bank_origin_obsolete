/*
 *  *********************************************************************************
 *  Created by Tezov on 08/05/2023 16:11
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/05/2023 15:59
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.tezov.bank.ui.pageMain.auth.profile.colors
import com.tezov.bank.ui.pageMain.auth.profile.shapes
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Icon
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.StateColor.Style.Companion.asFrameStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.StateColor.Style.Companion.copy
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
        val background: Color, // TODO remove and replace by selector when bottomsheet manage selector
        val onBackground: Color,
        val fade: Color,
    )

    @Composable
    fun provideColors() = Colors(
        background = MaterialTheme.colorsExtended.background.accent,
        onBackground = MaterialTheme.colorsExtended.onBackground.accent,
        fade = MaterialTheme.colorsExtended.primary.fade,
    )

    internal val localColors: ProvidableCompositionLocal<Colors> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Typographies(
        val title: OutfitTextStateColor,
        val body: OutfitTextStateColor,
        val footer: OutfitTextStateColor,
    )

    @Composable
    fun provideTypographies() = Typographies(
        title = MaterialTheme.typographiesExtended.title.huge.copy {
            outfitState = colors.onBackground.asStateSimple
            typo = typo.copy(fontWeight = FontWeight.Bold)
        },
        body = MaterialTheme.typographiesExtended.body.small.copy {
            outfitState = colors.onBackground.asStateSimple
        },
        footer = MaterialTheme.typographiesExtended.body.small.copy {
            outfitState = colors.onBackground.asStateSimple
        },
    )

    internal val localTypographies: ProvidableCompositionLocal<Typographies> =
        staticCompositionLocalOf {
            error("not provided")
        }

    data class Style(
        val iconClose: Icon.StateColor.Style,
    )

    @Composable
    fun provideStyles() = Style(
        iconClose = Icon.StateColor.Style(
            size = MaterialTheme.dimensionsIconExtended.modal.small,
            tint = colors.background,
            outfitFrame = MaterialTheme.shapesExtended.icon.normal.copy {
                outfitState = colors.onBackground.asStateSimple
            }.asFrameStateColor
        ),
    )

    internal val localStyles: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
        error("not provided")
    }


}