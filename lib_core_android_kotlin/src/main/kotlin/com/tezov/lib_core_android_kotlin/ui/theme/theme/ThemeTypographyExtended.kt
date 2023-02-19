/*
 *  *********************************************************************************
 *  Created by Tezov on 19/02/2023 20:50
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 19/02/2023 20:30
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.theme.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.text.TextStyle
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextSimple
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextState


val MaterialTheme.typographyExtended: ThemeTypographyExtended.Common
    @Composable
    @ReadOnlyComposable
    get() = ThemeTypographyExtended.localCommon.current
infix fun MaterialTheme.provides(value: ThemeTypographyExtended.Common) = ThemeTypographyExtended.localCommon provides value

object ThemeTypographyExtended{
    @Immutable
    data class Common(
        val textTitle: OutfitTextSimple,
        val textSubtitle: OutfitTextSimple,
        val textHelper: OutfitTextSimple,
        val textNormal: OutfitTextSimple,
        val textSupra: OutfitTextSimple,
        val textBig: OutfitTextSimple,
        val textHuge: OutfitTextSimple,
        val textSmall: OutfitTextSimple,
        val textFieldValue: OutfitTextSimple,
        val textFieldLabel: OutfitTextSimple,
        val textLink: OutfitTextSimple,
        val textButton: OutfitTextSimple,
        val textButtonOutline: OutfitTextSimple,
        val topNavigationTitle: OutfitTextSimple,
        val bottomNavigationLabel: OutfitTextSimple,
        val snackBarMessage: OutfitTextSimple,
        val snackBarAction: OutfitTextSimple,
    )
    internal val localCommon: ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }

}