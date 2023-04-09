/*
 *  *********************************************************************************
 *  Created by Tezov on 09/04/2023 13:44
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 09/04/2023 13:36
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.theme.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPaletteColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPaletteColorSemantic
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack

val MaterialTheme.colorsResource
    @Composable
    @ReadOnlyComposable
    get() = ThemeColorsExtended.localResources.current

val MaterialTheme.colorsExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeColorsExtended.localCommon.current

infix fun MaterialTheme.provides(value: ThemeColorsExtended.Common) =
    ThemeColorsExtended.localCommon provides value

object ThemeColorsExtended {

    object Resources {
        val transparent: Color = Color.Transparent
        val red: Color = Color(0xFFFF0000)
        val green: Color = Color(0xFF00FF00)
        val blue: Color = Color(0xFF0000FF)
        val yellow: Color = Color(0xFFFFFF00)
        val black: Color = Color(0xFF000000)
        val white: Color = Color(0xFFFFFFFF)
        val cian: Color = Color(0xFF00FFFF)
        val magenta: Color = Color(0xFFFF00FF)
        val gray: Color = Color(0xFF888888)
        val grayLight: Color = Color(0xFF4F5050)
        val whiteGray: Color = Color(0xFF8D8D8D)
        val orange: Color = Color(0xFFD37A73)
        val orangeGray: Color = Color(0xFFDF9C86)
        val orangeLight: Color = Color(0xFFE4B8AA)
        val blueLight: Color = Color(0xFF6741BB)
        val greenMelon: Color = Color(0xFF52E057)
    }

    internal val localResources = staticCompositionLocalOf { Resources }

    class Common(
        val background: OutfitPaletteColor,
        val onBackground: OutfitPaletteColor,

        val primary: OutfitPaletteColor,
        val onPrimary: OutfitPaletteColor,

        ribbon: OutfitPaletteColor? = null,

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

        val ribbon: OutfitPaletteColor by DelegateNullFallBack.Ref(
            ribbon,
            fallBackValue = { primary })

        val backgroundElevated: OutfitPaletteColor by DelegateNullFallBack.Ref(
            backgroundElevated,
            fallBackValue = { background })
        val onBackgroundElevated: OutfitPaletteColor by DelegateNullFallBack.Ref(
            onBackgroundElevated,
            fallBackValue = { onBackground })

        val backgroundModal: OutfitPaletteColor by DelegateNullFallBack.Ref(
            backgroundModal,
            fallBackValue = { background })
        val onBackgroundModal: OutfitPaletteColor by DelegateNullFallBack.Ref(
            onBackgroundModal,
            fallBackValue = { onBackground })

        val secondary: OutfitPaletteColor by DelegateNullFallBack.Ref(
            secondary,
            fallBackValue = { primary })
        val onSecondary: OutfitPaletteColor by DelegateNullFallBack.Ref(
            onSecondary,
            fallBackValue = { onPrimary })
        val tertiary: OutfitPaletteColor by DelegateNullFallBack.Ref(
            tertiary,
            fallBackValue = { primary })
        val onTertiary: OutfitPaletteColor by DelegateNullFallBack.Ref(
            onTertiary,
            fallBackValue = { onPrimary })

        val semantic: OutfitPaletteColorSemantic by DelegateNullFallBack.Ref(
            semantic,
            fallBackValue = { OutfitPaletteColorSemantic(primary) })
        val onSemantic: OutfitPaletteColorSemantic by DelegateNullFallBack.Ref(
            onSemantic,
            fallBackValue = { OutfitPaletteColorSemantic(onPrimary) })

    }

    internal val localCommon: ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }

    @Composable
    fun materialLight() =  Colors(
        primary = MaterialTheme.colorsExtended.primary.default,
        primaryVariant = MaterialTheme.colorsExtended.primary.accent,
        onPrimary = MaterialTheme.colorsExtended.onPrimary.default,

        secondary = MaterialTheme.colorsExtended.secondary.default,
        secondaryVariant = MaterialTheme.colorsExtended.secondary.accent,
        onSecondary = MaterialTheme.colorsExtended.onSecondary.default,

        surface = Color.Transparent,
        onSurface = MaterialTheme.colorsExtended.onBackground.default,

        background = MaterialTheme.colorsExtended.background.default,
        onBackground = MaterialTheme.colorsExtended.onBackground.default,

        error = MaterialTheme.colorsExtended.semantic.error.default,
        onError = MaterialTheme.colorsExtended.onSemantic.error.default,

        isLight = true
    )

}




