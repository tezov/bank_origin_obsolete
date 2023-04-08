/*
 *  *********************************************************************************
 *  Created by Tezov on 08/04/2023 15:32
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/04/2023 15:29
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
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorder.StateColor.Style.Companion.asStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorder.StateColor.Style.Companion.asPaletteSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorderStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPaletteSize
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack

val MaterialTheme.bordersExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeBordersExtended.localBorders.current

infix fun MaterialTheme.provides(value: ThemeBordersExtended.Common) =
    ThemeBordersExtended.localBorders provides value

object ThemeBordersExtended {

    class Common(
        cluster: OutfitPaletteSize<OutfitBorderStateColor>? = null,
        block: OutfitPaletteSize<OutfitBorderStateColor>? = null,
        chunk: OutfitPaletteSize<OutfitBorderStateColor>? = null,
        button: OutfitPaletteSize<OutfitBorderStateColor>? = null,
        icon: OutfitPaletteSize<OutfitBorderStateColor>? = null,
    ) {

        val cluster: OutfitPaletteSize<OutfitBorderStateColor> by DelegateNullFallBack(
            cluster,
            lazyFallBackValue = { 1.2.dp.asStateColor.asPaletteSize }
        )
        val block: OutfitPaletteSize<OutfitBorderStateColor> by DelegateNullFallBack(
            block,
            lazyFallBackValue = { 1.dp.asStateColor.asPaletteSize }
        )
        val chunk: OutfitPaletteSize<OutfitBorderStateColor> by DelegateNullFallBack(
            chunk,
            lazyFallBackValue = { 0.8.dp.asStateColor.asPaletteSize }
        )
        val button: OutfitPaletteSize<OutfitBorderStateColor> by DelegateNullFallBack(
            button,
            lazyFallBackValue = { 1.5.dp.asStateColor.asPaletteSize }
        )
        val icon: OutfitPaletteSize<OutfitBorderStateColor> by DelegateNullFallBack(
            icon,
            lazyFallBackValue = { 2.2.dp.asStateColor.asPaletteSize }
        )

    }

    internal val localBorders: ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }


}