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

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.text.TextStyle


val MaterialTheme.typographyExtended: ThemeTypographyExtended.Common
    @Composable
    @ReadOnlyComposable
    get() = ThemeTypographyExtended.localCommon.current
infix fun MaterialTheme.provides(value: ThemeTypographyExtended.Common) = ThemeTypographyExtended.localCommon provides value

object ThemeTypographyExtended{
    @Immutable
    data class Common(
        val textTitle: TextStyle,
        val textSubtitle: TextStyle,
        val textHelper: TextStyle,
        val textNormal: TextStyle,
        val textSupra: TextStyle,
        val textBig: TextStyle,
        val textHuge: TextStyle,
        val textSmall: TextStyle,
        val textFieldValue: TextStyle,
        val textFieldLabel: TextStyle,
        val textLink: TextStyle,
        val textButton: TextStyle,
        val textButtonOutline: TextStyle,
        val topNavigationTitle: TextStyle,
        val bottomNavigationLabel: TextStyle,
        val snackBarMessage: TextStyle,
        val snackBarAction: TextStyle,
    )
    internal val localCommon: ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }

}