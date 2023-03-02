/*
 *  *********************************************************************************
 *  Created by Tezov on 02/03/2023 21:57
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 02/03/2023 21:57
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
import androidx.compose.ui.unit.TextUnit

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
        val page_h: Dp,
        val page_v: Dp,
        val elementHuge_v: Dp,
        val elementBig_v: Dp,
        val elementNormal_v: Dp,
        val elementSmall_v: Dp,
        val elementMicro_v: Dp,
        val elementHuge_h: Dp,
        val elementBig_h: Dp,
        val elementNormal_h: Dp,
        val elementSmall_h: Dp,
        val elementMicro_h: Dp,
        val textBig_v: Dp,
        val textNormal_v: Dp,
        val textSmall_v: Dp,
        val textBig_h: Dp,
        val textNormal_h: Dp,
        val textSmall_h: Dp,
        val buttonBig_v: Dp,
        val buttonNormal_v: Dp,
        val buttonSmall_v: Dp,
        val buttonBig_h: Dp,
        val buttonNormal_h: Dp,
        val buttonSmall_h: Dp,
        val blockBig_v: Dp,
        val blockNormal_v: Dp,
        val blockSmall_v: Dp,
        val blockBig_h: Dp,
        val blockNormal_h: Dp,
        val blockSmall_h: Dp,
        val bottomNavigation: Dp,
        val topNavigation: Dp
    )
    internal val localPaddings: ProvidableCompositionLocal<Paddings> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class Spacings(
        val micro_v:Dp,
        val small_v:Dp,
        val normal_v:Dp,
        val big_v:Dp,
        val huge_v:Dp,
        val micro_h:Dp,
        val small_h:Dp,
        val normal_h:Dp,
        val big_h:Dp,
        val huge_h:Dp,
    )
    internal val localSpacings: ProvidableCompositionLocal<Spacings> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class Elevations(
        val elevationBig: Dp,
        val elevationNormal: Dp,
        val elevationSmall: Dp,
        val dialog: Dp,
        val snackbar: Dp,
        val bottomSheet: Dp,
    )
    internal val localElevations: ProvidableCompositionLocal<Elevations> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class Sizes(
        val iconModal:Dp,
        val iconInfo:Dp,
        val iconAction:Dp,
        val iconFieldInfo:Dp,
        val iconFieldAction:Dp,
        val dividerSmall:Dp,
        val dividerNormal:Dp,
        val dividerBig:Dp,
    )
    internal val localSizes: ProvidableCompositionLocal<Sizes> = staticCompositionLocalOf {
        error("not provided")
    }

}


