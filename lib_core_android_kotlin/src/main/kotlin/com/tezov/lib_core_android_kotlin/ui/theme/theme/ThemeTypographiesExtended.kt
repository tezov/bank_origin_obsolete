/*
 *  *********************************************************************************
 *  Created by Tezov on 19/03/2023 12:47
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 19/03/2023 10:51
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.theme.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextColor

val MaterialTheme.typographiesExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeTypographiesExtended.local.current
infix fun MaterialTheme.provides(value: ThemeTypographiesExtended.Common) = ThemeTypographiesExtended.local provides value

object ThemeTypographiesExtended{

    @Immutable
    data class Common(
        val textTitle: OutfitTextColor,
        val textSubtitle: OutfitTextColor,
        val textHelper: OutfitTextColor,

        val textNormal: OutfitTextColor,
        val textSupra: OutfitTextColor,
        val textBig: OutfitTextColor,
        val textHuge: OutfitTextColor,
        val textSmall: OutfitTextColor,
        val textMicro: OutfitTextColor,

        val textFieldValue: OutfitTextColor,
        val textFieldLabel: OutfitTextColor,
        val textLink: OutfitTextColor,
        val textButton: OutfitTextColor,
        val textButtonOutline: OutfitTextColor,
    )

    internal val local: ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }

}