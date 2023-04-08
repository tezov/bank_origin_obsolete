/*
 *  *********************************************************************************
 *  Created by Tezov on 08/04/2023 14:32
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/04/2023 13:44
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.theme.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.tezov.lib_core_android_kotlin.type.primaire.DpSize
import com.tezov.lib_core_android_kotlin.type.primaire.dpSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPalette.Color.Style.Companion.asPaletteColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPalette.Size.Style.Companion.asPaletteSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPaletteColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPaletteColorSemantic
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Semantic.Style.Companion.asStateSemantic
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitStateDual
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitStateSemantic
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack

val MaterialTheme.colorsCommonExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeColorsExtended.localCommon.current

infix fun MaterialTheme.provides(value: ThemeColorsExtended.Common) =
    ThemeColorsExtended.localCommon provides value

object ThemeColorsExtended {

    class Common(
        val background: OutfitPaletteColor,
        val onBackground: OutfitPaletteColor,

        val primary: OutfitPaletteColor,
        val onPrimary: OutfitPaletteColor,

        ribbon: OutfitPaletteColor,

        backgroundElevated: OutfitPaletteColor? = null,
        onBackgroundElevated: OutfitPaletteColor? = null,

        backgroundModal: OutfitPaletteColor? = null,
        onBackgroundModal: OutfitPaletteColor? = null,

        secondary: OutfitPaletteColor? = null,
        onSecondary: OutfitPaletteColor? = null,

        tertiary: OutfitPaletteColor? = null,
        onTertiary: OutfitPaletteColor? = null,

        semantic: OutfitPaletteColorSemantic? = null,
        onSemantic: OutfitPaletteColorSemantic? = null,

        ) {

        val ribbon: OutfitPaletteColor by DelegateNullFallBack(
            ribbon,
            lazyFallBackValue = { primary })

        val backgroundElevated: OutfitPaletteColor by DelegateNullFallBack(
            backgroundElevated,
            lazyFallBackValue = { background })
        val onBackgroundElevated: OutfitPaletteColor by DelegateNullFallBack(
            onBackgroundElevated,
            lazyFallBackValue = { onBackground })

        val backgroundModal: OutfitPaletteColor by DelegateNullFallBack(
            backgroundModal,
            lazyFallBackValue = { background })
        val onBackgroundModal: OutfitPaletteColor by DelegateNullFallBack(
            onBackgroundModal,
            lazyFallBackValue = { onBackground })

        val secondary: OutfitPaletteColor by DelegateNullFallBack(
            secondary,
            lazyFallBackValue = { primary })
        val onSecondary: OutfitPaletteColor by DelegateNullFallBack(
            onSecondary,
            lazyFallBackValue = { onPrimary })
        val tertiary: OutfitPaletteColor by DelegateNullFallBack(
            tertiary,
            lazyFallBackValue = { primary })
        val onTertiary: OutfitPaletteColor by DelegateNullFallBack(
            onTertiary,
            lazyFallBackValue = { onPrimary })

        val semantic: OutfitPaletteColorSemantic by DelegateNullFallBack(
            semantic,
            lazyFallBackValue = { OutfitPaletteColorSemantic(primary) })
        val onSemantic: OutfitPaletteColorSemantic by DelegateNullFallBack(
            onSemantic,
            lazyFallBackValue = { OutfitPaletteColorSemantic(onPrimary) })

    }

    internal val localCommon: ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }

}




