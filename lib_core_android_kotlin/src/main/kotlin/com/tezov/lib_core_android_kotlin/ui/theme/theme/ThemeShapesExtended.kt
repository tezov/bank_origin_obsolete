/*
 *  *********************************************************************************
 *  Created by Tezov on 02/04/2023 17:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 02/04/2023 17:18
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

val MaterialTheme.shapesExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeShapesExtended.localShapes.current
infix fun MaterialTheme.provides(value: ThemeShapesExtended.Shapes) = ThemeShapesExtended.localShapes provides value

val MaterialTheme.shapesButtonExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeShapesExtended.localButtons.current
infix fun MaterialTheme.provides(value: ThemeShapesExtended.Button) = ThemeShapesExtended.localButtons provides value

object ThemeShapesExtended{

    data class Shapes(
        val roundedCorner: OutfitPaletteSize<OutfitShapeStateColor>,
    )
    internal val localShapes: ProvidableCompositionLocal<Shapes> = staticCompositionLocalOf {
        error("not provided")
    }

    class Button(
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

    internal val localButtons: ProvidableCompositionLocal<Button> = staticCompositionLocalOf {
        error("not provided")
    }



}