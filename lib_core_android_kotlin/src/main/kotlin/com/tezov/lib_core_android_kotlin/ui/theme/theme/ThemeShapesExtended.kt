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
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPaletteSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.StateColor.Style.Companion.asPaletteSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.StateColor.Style.Companion.asStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShapeStateColor
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack

val MaterialTheme.shapesExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeShapesExtended.localCommon.current

infix fun MaterialTheme.provides(value: ThemeShapesExtended.Common) =
    ThemeShapesExtended.localCommon provides value

object ThemeShapesExtended {

    class Common(
        cluster: OutfitPaletteSize<OutfitShapeStateColor>? = null,
        block: OutfitPaletteSize<OutfitShapeStateColor>? = null,
        chunk: OutfitPaletteSize<OutfitShapeStateColor>? = null,
        button: OutfitPaletteSize<OutfitShapeStateColor>? = null,
        icon: OutfitPaletteSize<OutfitShapeStateColor>? = null,
    ) {
        val cluster: OutfitPaletteSize<OutfitShapeStateColor> by DelegateNullFallBack(
            cluster,
            lazyFallBackValue = { 8.dp.asStateColor.asPaletteSize }
        )
        val block: OutfitPaletteSize<OutfitShapeStateColor> by DelegateNullFallBack(
            block,
            lazyFallBackValue = { 10.dp.asStateColor.asPaletteSize }
        )
        val chunk: OutfitPaletteSize<OutfitShapeStateColor> by DelegateNullFallBack(
            chunk,
            lazyFallBackValue = { 12.dp.asStateColor.asPaletteSize }
        )
        val button: OutfitPaletteSize<OutfitShapeStateColor> by DelegateNullFallBack(
            button,
            lazyFallBackValue = { 16.dp.asStateColor.asPaletteSize }
        )
        val icon: OutfitPaletteSize<OutfitShapeStateColor> by DelegateNullFallBack(
            icon,
            lazyFallBackValue = { 15.asStateColor.asPaletteSize }
        )
    }

    internal val localCommon: ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }

}