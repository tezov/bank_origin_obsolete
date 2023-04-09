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

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorder.StateColor.Style.Companion.asPaletteSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorderStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPaletteSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
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

        private val delegates = DelegateNullFallBack.Group<OutfitPaletteSize<OutfitBorderStateColor>>()
        val cluster: OutfitPaletteSize<OutfitBorderStateColor> by delegates.ref(cluster)
        val block: OutfitPaletteSize<OutfitBorderStateColor> by delegates.ref(block)
        val chunk: OutfitPaletteSize<OutfitBorderStateColor> by delegates.ref(chunk)
        val button: OutfitPaletteSize<OutfitBorderStateColor> by delegates.ref(button)
        val icon: OutfitPaletteSize<OutfitBorderStateColor> by delegates.ref(icon)

        init {
            delegates.fallBackValue = {
                OutfitBorderStateColor(
                    outfitState = Color.Black.asStateSimple,
                    size = 1.dp
                ).asPaletteSize
            }
        }

    }

    internal val localBorders: ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }


}