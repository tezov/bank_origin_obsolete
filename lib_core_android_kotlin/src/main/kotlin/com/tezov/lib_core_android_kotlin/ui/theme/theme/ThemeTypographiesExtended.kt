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
import com.tezov.lib_core_android_kotlin.ui.theme.style.NoValue
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText

val MaterialTheme.typographiesExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeTypographiesExtended.local.current
infix fun MaterialTheme.provides(value: ThemeTypographiesExtended.Common) = ThemeTypographiesExtended.local provides value

object ThemeTypographiesExtended{

    @Immutable
    data class Common(
        val textTitle: OutfitText.StateColor = NoValue("ThemeTypographiesExtended:Common:textTitle"),
        val textSubtitle: OutfitText.StateColor = NoValue("ThemeTypographiesExtended:Common:textSubtitle"),
        val textHelper: OutfitText.StateColor = NoValue("ThemeTypographiesExtended:Common:textHelper"),

        val textNormal: OutfitText.StateColor = NoValue("ThemeTypographiesExtended:Common:textNormal"),
        val textSupra: OutfitText.StateColor = NoValue("ThemeTypographiesExtended:Common:textSupra"),
        val textBig: OutfitText.StateColor = NoValue("ThemeTypographiesExtended:Common:textBig"),
        val textHuge: OutfitText.StateColor = NoValue("ThemeTypographiesExtended:Common:textHuge"),
        val textSmall: OutfitText.StateColor = NoValue("ThemeTypographiesExtended:Common:textSmall"),
        val textMicro: OutfitText.StateColor = NoValue("ThemeTypographiesExtended:Common:textMicro"),

        val textFieldValue: OutfitText.StateColor = NoValue("ThemeTypographiesExtended:Common:textFieldValue"),
        val textFieldLabel: OutfitText.StateColor = NoValue("ThemeTypographiesExtended:Common:textFieldLabel"),
    )

    internal val local: ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }

}