/*
 *  *********************************************************************************
 *  Created by Tezov on 03/03/2023 22:33
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 03/03/2023 21:58
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
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitColorsState

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

        val background :Color,
        val backgroundVariant :Color,
        val onBackgroundVariant :Color,

        val backgroundElevated: Color,
        val onBackgroundElevated: Color,
        val onBackgroundElevatedVariant:Color,

        val backgroundModal: Color,
        val onBackgroundModal: Color,
        val onBackgroundModalVariant:Color,

        val backgroundButtonProceed: OutfitColorsState,
        val onBackgroundButtonProceed: OutfitColorsState,

        val backgroundButtonConfirm: OutfitColorsState,
        val onBackgroundButtonConfirm: OutfitColorsState,

        val backgroundButtonCancel: OutfitColorsState,
        val onBackgroundButtonCancel: OutfitColorsState,

        )
    internal val localCommon:ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }

}




