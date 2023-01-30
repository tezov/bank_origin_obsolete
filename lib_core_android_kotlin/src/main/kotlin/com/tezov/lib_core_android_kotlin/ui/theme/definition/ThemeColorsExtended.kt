/*
 *  *********************************************************************************
 *  Created by Tezov on 30/01/2023 20:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 30/01/2023 20:11
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.theme.definition

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

val MaterialTheme.colorsCommonExtended: ThemeColorsExtended.Common
    @Composable
    @ReadOnlyComposable
    get() = ThemeColorsExtended.localCommon.current
infix fun MaterialTheme.provides(value: ThemeColorsExtended.Common) = ThemeColorsExtended.localCommon provides value

object ThemeColorsExtended {
    @Immutable
    data class Common(
        val onPrimaryLight :Color,
        val onSecondaryLight :Color,
        val onBackgroundLight :Color,

        val backgroundElevated: Color,
        val onBackgroundElevated: Color,
        val onBackgroundElevatedLight:Color,

        val backgroundModal: Color,
        val onBackgroundModal: Color,
        val onBackgroundModalLight:Color,

        val backgroundInactive: Color,
        val onBackgroundInactive: Color,

        val backgroundButtonProceed: Color,
        val backgroundButtonProceedInactive: Color,
        val onBackgroundButtonProceed: Color,
        val onBackgroundButtonProceedInactive: Color,

        val backgroundButtonConfirm: Color,
        val backgroundButtonConfirmInactive: Color,
        val onBackgroundButtonConfirm: Color,
        val onBackgroundButtonConfirmInactive: Color,

        val backgroundButtonCancel: Color,
        val backgroundButtonCancelInactive: Color,
        val onBackgroundButtonCancel: Color,
        val onBackgroundButtonCancelInactive: Color,

        val topAppBarBackground: Color,
        val topAppBarContentText: Color,
        val topAppBarContentIcon: Color,

        val bottomNavigationBackground: Color,
        val bottomNavigationActive: Color,
        val bottomNavigationInactive: Color,

        val snackbarBackground: Color,
        val snackbarMessage: Color,
        val snackbarAction: Color,
    )
    internal val localCommon:ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }

}




