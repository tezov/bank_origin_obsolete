/*
 *  *********************************************************************************
 *  Created by Tezov on 01/04/2023 21:02
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 01/04/2023 21:02
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.theme.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.*

val MaterialTheme.typographiesExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeTypographiesExtended.localCommon.current
infix fun MaterialTheme.provides(value: ThemeTypographiesExtended.Common) = ThemeTypographiesExtended.localCommon provides value

object ThemeTypographiesExtended{

    @Immutable
    data class Common(
        val title: OutfitPalette.Variant<OutfitText.StateColor>,
        val body: OutfitPalette.Variant<OutfitText.StateColor>,
        val subtitle: OutfitPalette.Variant<OutfitText.StateColor>,
        val helper: OutfitPalette.Variant<OutfitText.StateColor>,
        val fieldValue: OutfitText.StateColor,
        val fieldLabel: OutfitText.StateColor,
    )

    internal val localCommon: ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }

}