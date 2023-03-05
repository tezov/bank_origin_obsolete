/*
 *  *********************************************************************************
 *  Created by Tezov on 05/03/2023 17:17
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 05/03/2023 17:17
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.theme.theme

import androidx.compose.material.*
import androidx.compose.runtime.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitColorsPalette
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitColorsSemantic

val MaterialTheme.colorsExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeColorsExtended.localCommon.current
infix fun MaterialTheme.provides(value: ThemeColorsExtended.Common) = ThemeColorsExtended.localCommon provides value

object ThemeColorsExtended {
    @Immutable
    data class Common(
        val primary :OutfitColorsPalette,
        val onPrimary :OutfitColorsPalette,

        val secondary :OutfitColorsPalette,
        val onSecondary :OutfitColorsPalette,

        val semantic :OutfitColorsSemantic,
        val onSemantic :OutfitColorsSemantic,

        val background :OutfitColorsPalette,
        val onBackground :OutfitColorsPalette,

        val backgroundElevated: OutfitColorsPalette,
        val onBackgroundElevated: OutfitColorsPalette,

        val backgroundModal: OutfitColorsPalette,
        val onBackgroundModal: OutfitColorsPalette,

        val backgroundButtonProceed: OutfitColorsPalette,
        val onBackgroundButtonProceed: OutfitColorsPalette,

        val backgroundButtonConfirm: OutfitColorsPalette,
        val onBackgroundButtonConfirm: OutfitColorsPalette,

        val backgroundButtonCancel: OutfitColorsPalette,
        val onBackgroundButtonCancel: OutfitColorsPalette,
    )
    internal val localCommon:ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }

}




