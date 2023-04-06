/*
 *  *********************************************************************************
 *  Created by Tezov on 06/04/2023 12:56
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 06/04/2023 12:56
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.type.primaire.SizeDp
import com.tezov.lib_core_android_kotlin.type.primaire.sizeDp
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPalette.Size.Style.Companion.asPaletteSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPaletteDirection
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPaletteSize
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack

val MaterialTheme.dimensionsPaddingExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeDimensionsExtended.localPaddings.current

infix fun MaterialTheme.provides(value: ThemeDimensionsExtended.Paddings) =
    ThemeDimensionsExtended.localPaddings provides value

val MaterialTheme.dimensionsSpacingExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeDimensionsExtended.localSpacings.current

infix fun MaterialTheme.provides(value: ThemeDimensionsExtended.Spacings) =
    ThemeDimensionsExtended.localSpacings provides value

val MaterialTheme.dimensionsSizeExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeDimensionsExtended.localSizes.current

infix fun MaterialTheme.provides(value: ThemeDimensionsExtended.Sizes) =
    ThemeDimensionsExtended.localSizes provides value

object ThemeDimensionsExtended {

    class Paddings(
        val page: OutfitPaletteDirection<Dp>,
        val block: OutfitPaletteDirection<OutfitPaletteSize<Dp>>,
        val element: OutfitPaletteDirection<OutfitPaletteSize<Dp>>,
        val button: OutfitPaletteDirection<OutfitPaletteSize<Dp>>,
    )

    internal val localPaddings: ProvidableCompositionLocal<Paddings> = staticCompositionLocalOf {
        error("not provided")
    }

    class Spacings(
        val elevation: OutfitPaletteSize<Dp>,
        val block: OutfitPaletteDirection<OutfitPaletteSize<Dp>>,
        val element: OutfitPaletteDirection<OutfitPaletteSize<Dp>>,
    )

    internal val localSpacings: ProvidableCompositionLocal<Spacings> = staticCompositionLocalOf {
        error("not provided")
    }

    class Sizes(
        divider: OutfitPaletteSize<Dp>,
        image: OutfitPaletteSize<SizeDp>,
        iconModal: SizeDp,
        iconInfo: SizeDp,
        iconAction: SizeDp,
        iconFieldInfo: SizeDp,
        iconFieldAction: SizeDp,
    ) {

        val divider: OutfitPaletteSize<Dp> by DelegateNullFallBack(
            divider,
            lazyFallBackValue = { 1.dp.asPaletteSize })
        val image: OutfitPaletteSize<SizeDp> by DelegateNullFallBack(
            image,
            lazyFallBackValue = { 24.sizeDp.asPaletteSize })
        val iconModal: SizeDp by DelegateNullFallBack(
            iconModal,
            lazyFallBackValue = { 24.sizeDp })
        val iconAction: SizeDp by DelegateNullFallBack(
            iconModal,
            lazyFallBackValue = { 24.sizeDp })
        val iconFieldInfo: SizeDp by DelegateNullFallBack(
            iconModal,
            lazyFallBackValue = { 24.sizeDp })
        val iconFieldAction: SizeDp by DelegateNullFallBack(
            iconModal,
            lazyFallBackValue = { 24.sizeDp })

    }

    internal val localSizes: ProvidableCompositionLocal<Sizes> = staticCompositionLocalOf {
        error("not provided")
    }

}


