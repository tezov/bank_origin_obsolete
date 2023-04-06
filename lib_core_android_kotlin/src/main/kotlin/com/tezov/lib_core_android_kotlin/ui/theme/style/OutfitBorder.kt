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

package com.tezov.lib_core_android_kotlin.ui.theme.style

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack
import androidx.compose.ui.graphics.Color as ColorImport

fun Modifier.border(
    style: OutfitBorder.StateColor.Style,
    selector: Any? = null,
    sketch: OutfitShape.Sketch? = null
) = style.resolve(selector)?.let { border ->
    return sketch?.let {
        border(border, sketch.shape).clip(sketch.shape)
    } ?: kotlin.run {
        border(border)
    }
} ?: this

typealias OutfitBorderStateColor = OutfitBorder.StateColor.Style

object OutfitBorder {

    enum class Template {
        Fill;

        fun get(size: Dp?, color: ColorImport) = size?.let {
            when (this) {
                Fill -> BorderStroke(size, color)
            }
        }

    }

    object StateColor {

        class StyleBuilder internal constructor(style: Style) {
            var template = style.template
            var size = style.size
            var outfitState = style.outfitState

            fun get() = Style(
                template = template,
                size = size,
                outfitState = outfitState,
            )
        }

        class Style(
            val template: Template = Template.Fill,
            val size: Dp? = null,
            outfitState: OutfitState.Style<ColorImport>? = null,
        ) {

            val outfitState: OutfitState.Style<ColorImport> by DelegateNullFallBack(
                outfitState,
                lazyFallBackValue = { OutfitStateNull() }
            )

            companion object {

                @Composable
                fun Style.copy(scope: @Composable StyleBuilder.() -> Unit = {}) =
                    StyleBuilder(this).also {
                        it.scope()
                    }.get()

                inline val OutfitBorderStateColor.asBorderPaletteSizeStateColor: OutfitPaletteSize<OutfitBorderStateColor>
                    get() = OutfitPaletteSize(normal = this)

                inline val Dp.asBorderPaletteSizeStateColor: OutfitPaletteSize<OutfitBorderStateColor>
                    get() = this.asBorderStateColor.asBorderPaletteSizeStateColor

                inline val Dp.asBorderStateColor: OutfitBorderStateColor
                    get() = OutfitBorderStateColor(size = this)

            }

            constructor(style: Style) : this(
                template = style.template,
                size = style.size,
                outfitState = style.outfitState,
            )

            fun resolve(selector: Any? = null) =
                outfitState.resolve(selector, ColorImport::class)?.let {
                    template.get(size, it)
                }

        }

    }


}

