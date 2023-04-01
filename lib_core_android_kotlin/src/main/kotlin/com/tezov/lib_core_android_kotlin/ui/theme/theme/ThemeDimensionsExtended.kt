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
import androidx.compose.ui.unit.Dp
import com.tezov.lib_core_android_kotlin.type.primaire.SizeDp
import com.tezov.lib_core_android_kotlin.ui.theme.style.*

val MaterialTheme.dimensionsPaddingExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeDimensionsExtended.localPaddings.current
infix fun MaterialTheme.provides(value:  ThemeDimensionsExtended.Paddings) = ThemeDimensionsExtended.localPaddings provides value

val MaterialTheme.dimensionsSpacingExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeDimensionsExtended.localSpacings.current
infix fun MaterialTheme.provides(value:  ThemeDimensionsExtended.Spacings) = ThemeDimensionsExtended.localSpacings provides value

val MaterialTheme.dimensionsElevationExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeDimensionsExtended.localElevations.current
infix fun MaterialTheme.provides(value:  ThemeDimensionsExtended.Elevations) = ThemeDimensionsExtended.localElevations provides value

val MaterialTheme.dimensionsSizeExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeDimensionsExtended.localSizes.current
infix fun MaterialTheme.provides(value:  ThemeDimensionsExtended.Sizes) = ThemeDimensionsExtended.localSizes provides value

object ThemeDimensionsExtended{

    @Immutable
    data class Paddings(
        val page: OutfitPalette.Direction<Dp>,
        val block: OutfitPalette.Direction<OutfitPalette.Variant<Dp>>,
        val element: OutfitPalette.Direction<OutfitPalette.Variant<Dp>>,
    )
    internal val localPaddings: ProvidableCompositionLocal<Paddings> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class Spacings(
        val block:OutfitPalette.Direction<OutfitPalette.Variant<Dp>>,
        val element:OutfitPalette.Direction<OutfitPalette.Variant<Dp>>,
    )
    internal val localSpacings: ProvidableCompositionLocal<Spacings> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class Elevations(
        val elevation: OutfitPalette.Variant<Dp>,
    )
    internal val localElevations: ProvidableCompositionLocal<Elevations> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class Sizes(
        val iconModal:SizeDp,
        val iconInfo:SizeDp,
        val iconAction:SizeDp,
        val iconFieldInfo:SizeDp,
        val iconFieldAction:SizeDp,
        val divider:OutfitPalette.Variant<Dp>,
    )
    internal val localSizes: ProvidableCompositionLocal<Sizes> = staticCompositionLocalOf {
        error("not provided")
    }

}


