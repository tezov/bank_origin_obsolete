/*
 *  *********************************************************************************
 *  Created by Tezov on 02/04/2023 14:12
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 02/04/2023 14:12
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.theme.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.tezov.lib_core_android_kotlin.ui.theme.style.*

import com.tezov.lib_core_android_kotlin.ui.component.plain.Button.StateColor.Style.Companion.Nucleus as ButtonNucleus

val MaterialTheme.colorsExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeColorsExtended.localCommon.current

infix fun MaterialTheme.provides(value: ThemeColorsExtended.Common) =
    ThemeColorsExtended.localCommon provides value

object ThemeColorsExtended {
    @Immutable
    data class Common(
        val background: OutfitPaletteColor,
        val onBackground: OutfitPaletteColor,

        val backgroundElevated: OutfitPaletteColor,
        val onBackgroundElevated: OutfitPaletteColor,

        val backgroundModal: OutfitPaletteColor,
        val onBackgroundModal: OutfitPaletteColor,

        val primary: OutfitPaletteColor,
        val onPrimary: OutfitPaletteColor,

        val secondary: OutfitPaletteColor,
        val onSecondary: OutfitPaletteColor,

        val tertiary: OutfitPaletteColor,
        val onTertiary: OutfitPaletteColor,

        val semantic: OutfitPaletteColorSemantic,
        val onSemantic: OutfitPaletteColorSemantic,

    )

    internal val localCommon: ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class Button(
        val confirm: ButtonNucleus,
        val cancel: ButtonNucleus,
        val proceed: ButtonNucleus,
        val primary: ButtonNucleus,
        val secondary: ButtonNucleus,
        val tertiary: ButtonNucleus,
    )

    internal val localButtons: ProvidableCompositionLocal<Button> = staticCompositionLocalOf {
        error("not provided")
    }

}




