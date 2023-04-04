/*
 *  *********************************************************************************
 *  Created by Tezov on 04/04/2023 13:51
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 04/04/2023 13:51
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
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPaletteSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.StateColor.Style.Companion.asPaletteSizeStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.asSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShapeStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asSimple
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitStateDual
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack

val MaterialTheme.shapesCommonExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeShapesExtended.localCommon.current

infix fun MaterialTheme.provides(value: ThemeShapesExtended.Common) =
    ThemeShapesExtended.localCommon provides value

val MaterialTheme.shapesButtonExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeShapesExtended.localButtons.current

infix fun MaterialTheme.provides(value: ThemeShapesExtended.Buttons) =
    ThemeShapesExtended.localButtons provides value

object ThemeShapesExtended {

    class Common(
        roundedCorner: OutfitPaletteSize<OutfitShapeStateColor>? = null,
    ) {
        val roundedCorner: OutfitPaletteSize<OutfitShapeStateColor> by DelegateNullFallBack(
            roundedCorner,
            OutfitShapeStateColor(
                size = 12.asSize,
                outfitState = Color.Gray.asSimple
            ).asPaletteSizeStateColor
        )
    }

    internal val localCommon: ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }

    class Buttons(
        primary: OutfitShapeStateColor? = null,
        secondary: OutfitShapeStateColor? = null,
        tertiary: OutfitShapeStateColor? = null,
        confirm: OutfitShapeStateColor? = null,
        cancel: OutfitShapeStateColor? = null,
        proceed: OutfitShapeStateColor? = null,
    ) : DelegateNullFallBack.Group<OutfitShapeStateColor> {

        val primary: OutfitShapeStateColor by DelegateNullFallBack(primary)
        val secondary: OutfitShapeStateColor by DelegateNullFallBack(secondary)
        val tertiary: OutfitShapeStateColor by DelegateNullFallBack(tertiary)
        val confirm: OutfitShapeStateColor by DelegateNullFallBack(confirm)
        val cancel: OutfitShapeStateColor by DelegateNullFallBack(cancel)
        val proceed: OutfitShapeStateColor by DelegateNullFallBack(proceed)

        override fun groupFallBackRefs() = listOf(primary, secondary, tertiary, confirm, cancel, proceed)

        init {
            groupFallBackValue = OutfitShapeStateColor(
                size = 12.asSize,
                outfitState = OutfitStateDual(
                    active = Color.Gray,
                    inactive = Color.Gray.copy(alpha = 0.5f)
                )
            )
        }
    }

    internal val localButtons: ProvidableCompositionLocal<Buttons> = staticCompositionLocalOf {
        error("not provided")
    }


}