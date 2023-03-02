/*
 *  *********************************************************************************
 *  Created by Tezov on 02/03/2023 20:30
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 02/03/2023 20:30
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
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextSketch


val MaterialTheme.typographiesSketchExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeTypographiesExtended.localSketch.current
infix fun MaterialTheme.provides(value: ThemeTypographiesExtended.Sketch) = ThemeTypographiesExtended.localSketch provides value

object ThemeTypographiesExtended{

    @Immutable
    data class Sketch(
        val textTitle: OutfitTextSketch,
        val textSubtitle: OutfitTextSketch,
        val textHelper: OutfitTextSketch,
        val textNormal: OutfitTextSketch,
        val textSupra: OutfitTextSketch,
        val textBig: OutfitTextSketch,
        val textHuge: OutfitTextSketch,
        val textSmall: OutfitTextSketch,
        val textFieldValue: OutfitTextSketch,
        val textFieldLabel: OutfitTextSketch,
        val textLink: OutfitTextSketch,
        val textButton: OutfitTextSketch,
        val textButtonOutline: OutfitTextSketch,
        val topNavigationTitle: OutfitTextSketch,
        val bottomNavigationLabel: OutfitTextSketch,
        val snackBarMessage: OutfitTextSketch,
        val snackBarAction: OutfitTextSketch,
    )
    internal val localSketch: ProvidableCompositionLocal<Sketch> = staticCompositionLocalOf {
        error("not provided")
    }

}