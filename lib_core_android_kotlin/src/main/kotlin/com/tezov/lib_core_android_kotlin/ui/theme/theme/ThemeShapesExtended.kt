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

val MaterialTheme.shapesCommonExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeShapesExtended.localCommon.current
infix fun MaterialTheme.provides(value: ThemeShapesExtended.Common) = ThemeShapesExtended.localCommon provides value

val MaterialTheme.shapesButtonExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeShapesExtended.localButtons.current
infix fun MaterialTheme.provides(value: ThemeShapesExtended.Buttons) = ThemeShapesExtended.localButtons provides value

object ThemeShapesExtended{

    data class Common(
        val roundedCorner: OutfitPaletteSize<OutfitShapeStateColor>,
    )
    internal val localCommon: ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }

    class Buttons(
        val primary: OutfitShapeStateColor,
        secondary: OutfitShapeStateColor? = null,
        tertiary: OutfitShapeStateColor? = null,
        confirm: OutfitShapeStateColor? = null,
        cancel: OutfitShapeStateColor? = null,
        proceed: OutfitShapeStateColor? = null,
    ) : DelegateNullFallBack.Setter<OutfitShapeStateColor> {

        val secondary: OutfitShapeStateColor by DelegateNullFallBack(secondary)
        val tertiary: OutfitShapeStateColor by DelegateNullFallBack(tertiary)
        val confirm: OutfitShapeStateColor by DelegateNullFallBack(confirm)
        val cancel: OutfitShapeStateColor by DelegateNullFallBack(cancel)
        val proceed: OutfitShapeStateColor by DelegateNullFallBack(proceed)

        override fun refs() = listOf(secondary, tertiary, confirm, cancel, proceed)

        init {
            nullFallback = { primary }
        }
    }

    internal val localButtons: ProvidableCompositionLocal<Buttons> = staticCompositionLocalOf {
        error("not provided")
    }



}