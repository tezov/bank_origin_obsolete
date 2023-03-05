/*
 *  *********************************************************************************
 *  Created by Tezov on 05/03/2023 14:03
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 04/03/2023 22:50
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.theme.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextSketch


val MaterialTheme.typographiesExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeTypographiesExtended.local.current
infix fun MaterialTheme.provides(value: ThemeTypographiesExtended.Common) = ThemeTypographiesExtended.local provides value

object ThemeTypographiesExtended{

    @Immutable
    data class Common(
        val textTitle: OutfitTextSketch,
        val textSubtitle: OutfitTextSketch,
        val textHelper: OutfitTextSketch,

        val textNormal: OutfitTextSketch,
        val textSupra: OutfitTextSketch,
        val textBig: OutfitTextSketch,
        val textHuge: OutfitTextSketch,
        val textSmall: OutfitTextSketch,
        val textMicro: OutfitTextSketch,

        val textFieldValue: OutfitTextSketch,
        val textFieldLabel: OutfitTextSketch,
        val textLink: OutfitTextSketch,
        val textButton: OutfitTextSketch,
        val textButtonOutline: OutfitTextSketch,

    )
    internal val local: ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }

}