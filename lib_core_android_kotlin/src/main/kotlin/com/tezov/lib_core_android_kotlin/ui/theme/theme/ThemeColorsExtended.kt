/*
 *  *********************************************************************************
 *  Created by Tezov on 02/03/2023 21:57
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 02/03/2023 21:57
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.theme.theme

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitColorsSimple

val MaterialTheme.colorsCommonExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeColorsExtended.localCommon.current
infix fun MaterialTheme.provides(value: ThemeColorsExtended.Common) = ThemeColorsExtended.localCommon provides value

object ThemeColorsExtended {
    @Immutable
    data class Common(
        val onPrimaryVariant :Color,
        val onSecondaryVariant :Color,

        val backgroundVariant :Color,
        val onBackgroundVariant :Color,

        val backgroundElevated: Color,
        val onBackgroundElevated: Color,
        val onBackgroundElevatedVariant:Color,

        val backgroundModal: Color,
        val onBackgroundModal: Color,
        val onBackgroundModalVariant:Color,

        val background: OutfitColorsSimple,

        val backgroundButtonProceed: OutfitColorsSimple,
        val onBackgroundButtonProceed: OutfitColorsSimple,

        val backgroundButtonConfirm: OutfitColorsSimple,
        val onBackgroundButtonConfirm: OutfitColorsSimple,

        val backgroundButtonCancel: OutfitColorsSimple,
        val onBackgroundButtonCancel: OutfitColorsSimple,

        val topAppBarBackground: Color,
        val topAppBarContentIcon: Color,

        val bottomNavigationBackground: Color,
    )
    internal val localCommon:ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }

}




