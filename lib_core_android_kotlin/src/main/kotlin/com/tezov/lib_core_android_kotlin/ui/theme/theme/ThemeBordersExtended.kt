/*
 *  *********************************************************************************
 *  Created by Tezov on 02/04/2023 16:46
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 02/04/2023 16:46
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

val MaterialTheme.bordersExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeBordersExtended.localBorders.current
infix fun MaterialTheme.provides(value: ThemeBordersExtended.Borders) = ThemeBordersExtended.localBorders provides value

val MaterialTheme.bordersButtonExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeBordersExtended.localButtons.current
infix fun MaterialTheme.provides(value: ThemeBordersExtended.Button) = ThemeBordersExtended.localButtons provides value

object ThemeBordersExtended{

    @Immutable
    data class Borders(
        val stroke: OutfitPaletteVariant<OutfitBorderStateColor>,
    )
    internal val localBorders: ProvidableCompositionLocal<Borders> = staticCompositionLocalOf {
        error("not provided")
    }

    class Button(
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

    internal val localButtons: ProvidableCompositionLocal<Button> = staticCompositionLocalOf {
        error("not provided")
    }

}