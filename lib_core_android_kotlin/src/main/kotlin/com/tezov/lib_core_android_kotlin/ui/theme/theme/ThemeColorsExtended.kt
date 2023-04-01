/*
 *  *********************************************************************************
 *  Created by Tezov on 01/04/2023 12:47
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 01/04/2023 12:46
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

val MaterialTheme.colorsExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeColorsExtended.localCommon.current

infix fun MaterialTheme.provides(value: ThemeColorsExtended.Common) =
    ThemeColorsExtended.localCommon provides value

object ThemeColorsExtended {
    @Immutable
    data class Common(
        val primary: OutfitPaletteColor,
        val onPrimary: OutfitPaletteColor,

        val secondary: OutfitPaletteColor,
        val onSecondary: OutfitPaletteColor,

        val semantic: OutfitPaletteColorSemantic,
        val onSemantic: OutfitPaletteColorSemantic,

        val background: OutfitPaletteColor,
        val onBackground: OutfitPaletteColor,

        val backgroundElevated: OutfitPaletteColor,
        val onBackgroundElevated: OutfitPaletteColor,

        val backgroundModal: OutfitPaletteColor,
        val onBackgroundModal: OutfitPaletteColor,
    )

    internal val localCommon: ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }

}




