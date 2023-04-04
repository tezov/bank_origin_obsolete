/*
 *  *********************************************************************************
 *  Created by Tezov on 04/04/2023 12:05
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 04/04/2023 11:52
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.theme.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.*
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack

val MaterialTheme.bordersCommonExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeBordersExtended.localBorders.current
infix fun MaterialTheme.provides(value: ThemeBordersExtended.Common) = ThemeBordersExtended.localBorders provides value

val MaterialTheme.bordersButtonExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeBordersExtended.localButtons.current
infix fun MaterialTheme.provides(value: ThemeBordersExtended.Buttons) = ThemeBordersExtended.localButtons provides value

object ThemeBordersExtended{

    @Immutable
    data class Common(
        val stroke: OutfitPaletteSize<OutfitBorderStateColor>,
    )
    internal val localBorders: ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }

    class Buttons(
        val primary: OutfitBorderStateColor,
        secondary: OutfitBorderStateColor? = null,
        tertiary: OutfitBorderStateColor? = null,
        confirm: OutfitBorderStateColor? = null,
        cancel: OutfitBorderStateColor? = null,
        proceed: OutfitBorderStateColor? = null,
    ) : DelegateNullFallBack.Setter<OutfitBorderStateColor> {

        val secondary: OutfitBorderStateColor by DelegateNullFallBack(secondary)
        val tertiary: OutfitBorderStateColor by DelegateNullFallBack(tertiary)
        val confirm: OutfitBorderStateColor by DelegateNullFallBack(confirm)
        val cancel: OutfitBorderStateColor by DelegateNullFallBack(cancel)
        val proceed: OutfitBorderStateColor by DelegateNullFallBack(proceed)

        override fun refs() = listOf(secondary, tertiary, confirm, cancel, proceed)

        init {
            nullFallback = { primary }
        }
    }

    internal val localButtons: ProvidableCompositionLocal<Buttons> = staticCompositionLocalOf {
        error("not provided")
    }

}