/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
 */

/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
 */

package com.tezov.lib_core_android_kotlin.ui.theme.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPaletteSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.Size.Companion.asShapeSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.StateColor.Style.Companion.asPaletteSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShapeStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
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
        element: OutfitPaletteSize<OutfitShapeStateColor>? = null,
        chunk: OutfitPaletteSize<OutfitShapeStateColor>? = null,
        button: OutfitPaletteSize<OutfitShapeStateColor>? = null,
        icon: OutfitPaletteSize<OutfitShapeStateColor>? = null,
        clip: OutfitPaletteSize<Shape>? = null,
    ) {

        private val delegates =
            DelegateNullFallBack.Group<OutfitPaletteSize<OutfitShapeStateColor>>()
        val cluster: OutfitPaletteSize<OutfitShapeStateColor> by delegates.ref(cluster)
        val block: OutfitPaletteSize<OutfitShapeStateColor> by delegates.ref(block)
        val element: OutfitPaletteSize<OutfitShapeStateColor> by delegates.ref(element)
        val chunk: OutfitPaletteSize<OutfitShapeStateColor> by delegates.ref(chunk)
        val button: OutfitPaletteSize<OutfitShapeStateColor> by delegates.ref(button)
        val icon: OutfitPaletteSize<OutfitShapeStateColor> by delegates.ref(icon)
        val clip: OutfitPaletteSize<Shape> by DelegateNullFallBack.Ref(clip, fallBackValue = {
            OutfitPaletteSize(normal = RoundedCornerShape(4.dp))
        })

        init {
            delegates.fallBackValue = {
                ThemeColorsExtended.Dummy.outfitShapeState.asPaletteSize
            }
        }

    }

    internal val localCommon: ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }

}