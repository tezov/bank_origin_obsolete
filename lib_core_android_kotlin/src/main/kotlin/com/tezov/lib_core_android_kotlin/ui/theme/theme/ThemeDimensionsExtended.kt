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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import com.tezov.lib_core_android_kotlin.type.primaire.SizeDp
import com.tezov.lib_core_android_kotlin.ui.theme.style.NoValue

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
        val page_h: Dp = NoValue("ThemeDimensionsExtended:Paddings:page_h"),
        val page_v: Dp = NoValue("ThemeDimensionsExtended:Paddings:page_v"),
        val elementHuge_v: Dp = NoValue("ThemeDimensionsExtended:Paddings:elementHuge_v"),
        val elementBig_v: Dp = NoValue("ThemeDimensionsExtended:Paddings:elementBig_v"),
        val elementNormal_v: Dp = NoValue("ThemeDimensionsExtended:Paddings:elementNormal_v"),
        val elementSmall_v: Dp = NoValue("ThemeDimensionsExtended:Paddings:elementSmall_v"),
        val elementMicro_v: Dp = NoValue("ThemeDimensionsExtended:Paddings:elementMicro_v"),
        val elementHuge_h: Dp = NoValue("ThemeDimensionsExtended:Paddings:elementHuge_h"),
        val elementBig_h: Dp = NoValue("ThemeDimensionsExtended:Paddings:elementBig_h"),
        val elementNormal_h: Dp = NoValue("ThemeDimensionsExtended:Paddings:elementNormal_h"),
        val elementSmall_h: Dp = NoValue("ThemeDimensionsExtended:Paddings:elementSmall_h"),
        val elementMicro_h: Dp = NoValue("ThemeDimensionsExtended:Paddings:elementMicro_h"),
        val textBig_v: Dp = NoValue("ThemeDimensionsExtended:Paddings:textBig_v"),
        val textNormal_v: Dp = NoValue("ThemeDimensionsExtended:Paddings:textNormal_v"),
        val textSmall_v: Dp = NoValue("ThemeDimensionsExtended:Paddings:textSmall_v"),
        val textBig_h: Dp = NoValue("ThemeDimensionsExtended:Paddings:textBig_h"),
        val textNormal_h: Dp = NoValue("ThemeDimensionsExtended:Paddings:textNormal_h"),
        val textSmall_h: Dp = NoValue("ThemeDimensionsExtended:Paddings:textSmall_h"),
        val buttonBig_v: Dp = NoValue("ThemeDimensionsExtended:Paddings:buttonBig_v"),
        val buttonNormal_v: Dp = NoValue("ThemeDimensionsExtended:Paddings:buttonNormal_v"),
        val buttonSmall_v: Dp = NoValue("ThemeDimensionsExtended:Paddings:buttonSmall_v"),
        val buttonBig_h: Dp = NoValue("ThemeDimensionsExtended:Paddings:buttonBig_h"),
        val buttonNormal_h: Dp = NoValue("ThemeDimensionsExtended:Paddings:buttonNormal_h"),
        val buttonSmall_h: Dp = NoValue("ThemeDimensionsExtended:Paddings:buttonSmall_h"),
        val blockBig_v: Dp = NoValue("ThemeDimensionsExtended:Paddings:blockBig_v"),
        val blockNormal_v: Dp = NoValue("ThemeDimensionsExtended:Paddings:blockNormal_v"),
        val blockSmall_v: Dp = NoValue("ThemeDimensionsExtended:Paddings:blockSmall_v"),
        val blockBig_h: Dp = NoValue("ThemeDimensionsExtended:Paddings:blockBig_h"),
        val blockNormal_h: Dp = NoValue("ThemeDimensionsExtended:Paddings:blockNormal_h"),
        val blockSmall_h: Dp = NoValue("ThemeDimensionsExtended:Paddings:blockSmall_h"),
    )
    internal val localPaddings: ProvidableCompositionLocal<Paddings> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class Spacings(
        val micro_v:Dp = NoValue("ThemeDimensionsExtended:Spacings:micro_v"),
        val small_v:Dp = NoValue("ThemeDimensionsExtended:Spacings:small_v"),
        val normal_v:Dp = NoValue("ThemeDimensionsExtended:Spacings:normal_v"),
        val big_v:Dp = NoValue("ThemeDimensionsExtended:Spacings:big_v"),
        val huge_v:Dp = NoValue("ThemeDimensionsExtended:Spacings:huge_v"),
        val micro_h:Dp = NoValue("ThemeDimensionsExtended:Spacings:micro_h"),
        val small_h:Dp = NoValue("ThemeDimensionsExtended:Spacings:small_h"),
        val normal_h:Dp = NoValue("ThemeDimensionsExtended:Spacings:normal_h"),
        val big_h:Dp = NoValue("ThemeDimensionsExtended:Spacings:big_h"),
        val huge_h:Dp = NoValue("ThemeDimensionsExtended:Spacings:huge_h"),
    )
    internal val localSpacings: ProvidableCompositionLocal<Spacings> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class Elevations(
        val elevationBig: Dp = NoValue("ThemeDimensionsExtended:Elevations:elevationBig"),
        val elevationNormal: Dp = NoValue("ThemeDimensionsExtended:Elevations:elevationNormal"),
        val elevationSmall: Dp = NoValue("ThemeDimensionsExtended:Elevations:elevationSmall"),
    )
    internal val localElevations: ProvidableCompositionLocal<Elevations> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class Sizes(
        val iconModal:SizeDp = NoValue("ThemeDimensionsExtended:Sizes:iconModal"),
        val iconInfo:SizeDp = NoValue("ThemeDimensionsExtended:Sizes:iconInfo"),
        val iconAction:SizeDp = NoValue("ThemeDimensionsExtended:Sizes:iconAction"),
        val iconFieldInfo:SizeDp = NoValue("ThemeDimensionsExtended:Sizes:iconFieldInfo"),
        val iconFieldAction:SizeDp = NoValue("ThemeDimensionsExtended:Sizes:iconFieldAction"),
        val dividerSmall:Dp = NoValue("ThemeDimensionsExtended:Sizes:dividerSmall"),
        val dividerNormal:Dp = NoValue("ThemeDimensionsExtended:Sizes:dividerNormal"),
        val dividerBig:Dp = NoValue("ThemeDimensionsExtended:Sizes:dividerBig"),
    )
    internal val localSizes: ProvidableCompositionLocal<Sizes> = staticCompositionLocalOf {
        error("not provided")
    }

}


