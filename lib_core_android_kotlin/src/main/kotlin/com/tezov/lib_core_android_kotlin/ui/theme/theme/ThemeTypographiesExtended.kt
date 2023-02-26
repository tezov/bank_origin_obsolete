/*
 *  *********************************************************************************
 *  Created by Tezov on 26/02/2023 12:51
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 26/02/2023 11:36
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.theme.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextSimple


val MaterialTheme.typographiesSimpleExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeTypographiesExtended.localSimple.current
infix fun MaterialTheme.provides(value: ThemeTypographiesExtended.Simple) = ThemeTypographiesExtended.localSimple provides value

object ThemeTypographiesExtended{

    @Immutable
    data class Simple(
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
    internal val localSimple: ProvidableCompositionLocal<Simple> = staticCompositionLocalOf {
        error("not provided")
    }

}