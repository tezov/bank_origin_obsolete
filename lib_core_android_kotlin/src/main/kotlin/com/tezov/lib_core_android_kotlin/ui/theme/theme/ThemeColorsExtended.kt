/*
 *  *********************************************************************************
 *  Created by Tezov on 29/03/2023 22:26
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 29/03/2023 22:26
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
        val primary: OutfitPaletteColor = NoValue("ThemeColorsExtended:Common:primary"),
        val onPrimary: OutfitPaletteColor = NoValue("ThemeColorsExtended:Common:onPrimary"),

        val secondary: OutfitPaletteColor = NoValue("ThemeColorsExtended:Common:secondary"),
        val onSecondary: OutfitPaletteColor = NoValue("ThemeColorsExtended:Common:onSecondary"),

        val semantic: OutfitPaletteColorSemantic = NoValue("ThemeColorsExtended:Common:semantic"),
        val onSemantic: OutfitPaletteColorSemantic = NoValue("ThemeColorsExtended:Common:onSemantic"),

        val background: OutfitPaletteColor = NoValue("ThemeColorsExtended:Common:background"),
        val onBackground: OutfitPaletteColor = NoValue("ThemeColorsExtended:Common:onBackground"),

        val backgroundElevated: OutfitPaletteColor = NoValue("ThemeColorsExtended:Common:backgroundElevated"),
        val onBackgroundElevated: OutfitPaletteColor = NoValue("ThemeColorsExtended:Common:onBackgroundElevated"),

        val backgroundModal: OutfitPaletteColor = NoValue("ThemeColorsExtended:Common:backgroundModal"),
        val onBackgroundModal: OutfitPaletteColor = NoValue("ThemeColorsExtended:Common:onBackgroundModal"),
    )

    internal val localCommon: ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }

}




