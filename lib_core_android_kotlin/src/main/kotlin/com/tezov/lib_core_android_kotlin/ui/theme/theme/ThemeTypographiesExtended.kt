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
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText

val MaterialTheme.typographiesExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeTypographiesExtended.local.current
infix fun MaterialTheme.provides(value: ThemeTypographiesExtended.Common) = ThemeTypographiesExtended.local provides value

object ThemeTypographiesExtended{

    @Immutable
    data class Common(
        val textTitle: OutfitText.StateColor,
        val textSubtitle: OutfitText.StateColor,
        val textHelper: OutfitText.StateColor,

        val textNormal: OutfitText.StateColor,
        val textSupra: OutfitText.StateColor,
        val textBig: OutfitText.StateColor,
        val textHuge: OutfitText.StateColor,
        val textSmall: OutfitText.StateColor,
        val textMicro: OutfitText.StateColor,

        val textFieldValue: OutfitText.StateColor,
        val textFieldLabel: OutfitText.StateColor,
    )

    internal val local: ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }

}