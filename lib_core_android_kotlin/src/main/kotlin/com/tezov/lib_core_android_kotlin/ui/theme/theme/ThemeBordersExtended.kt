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
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorder.StateColor.Style.Companion.asBorderPaletteSizeStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorder.StateColor.Style.Companion.asBorderStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorderStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPaletteSize
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack

val MaterialTheme.bordersCommonExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeBordersExtended.localBorders.current

infix fun MaterialTheme.provides(value: ThemeBordersExtended.Common) =
    ThemeBordersExtended.localBorders provides value

val MaterialTheme.bordersButtonExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeBordersExtended.localButtons.current

infix fun MaterialTheme.provides(value: ThemeBordersExtended.Buttons) =
    ThemeBordersExtended.localButtons provides value

object ThemeBordersExtended {

    class Common(
        stroke: OutfitPaletteSize<OutfitBorderStateColor>? = null,
    ) {
        val stroke: OutfitPaletteSize<OutfitBorderStateColor> by DelegateNullFallBack(
            stroke,
            lazyFallBackValue = { 1.dp.asBorderPaletteSizeStateColor }
        )

    }

    internal val localBorders: ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }

    class Buttons(
        primary: OutfitBorderStateColor? = null,
        secondary: OutfitBorderStateColor? = null,
        tertiary: OutfitBorderStateColor? = null,
        confirm: OutfitBorderStateColor? = null,
        cancel: OutfitBorderStateColor? = null,
        proceed: OutfitBorderStateColor? = null,
    ) : DelegateNullFallBack.Group<OutfitBorderStateColor> {

        val primary: OutfitBorderStateColor by DelegateNullFallBack(primary)
        val secondary: OutfitBorderStateColor by DelegateNullFallBack(secondary)
        val tertiary: OutfitBorderStateColor by DelegateNullFallBack(tertiary)
        val confirm: OutfitBorderStateColor by DelegateNullFallBack(confirm)
        val cancel: OutfitBorderStateColor by DelegateNullFallBack(cancel)
        val proceed: OutfitBorderStateColor by DelegateNullFallBack(proceed)

        override fun groupFallBackRefs() =
            listOf(primary, secondary, tertiary, confirm, cancel, proceed)

        init {
            groupLazyFallBackValue = { 1.dp.asBorderStateColor }
        }
    }

    internal val localButtons: ProvidableCompositionLocal<Buttons> = staticCompositionLocalOf {
        error("not provided")
    }

}