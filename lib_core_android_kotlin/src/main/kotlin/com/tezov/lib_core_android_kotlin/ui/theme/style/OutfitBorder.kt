/*
 *  *********************************************************************************
 *  Created by Tezov on 17/04/2023 21:26
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 17/04/2023 21:25
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.theme.style

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack
import androidx.compose.ui.graphics.Color as ColorImport

fun Modifier.border(
    style: OutfitBorder.StateColor.Style?,
    selector: Any? = null,
    sketch: OutfitShape.Sketch? = null
) = border(style?.resolve(selector), sketch)

fun Modifier.border(
    styleBorder: OutfitBorder.StateColor.Style?,
    styleShape: OutfitShape.StateColor.Style?,
    selector: Any? = null,
) = border(styleBorder?.resolve(selector), styleShape?.resolve(selector))

fun Modifier.border(
    border: BorderStroke?,
    sketch: OutfitShape.Sketch? = null
) = border?.let {
    sketch?.let {
        clip(sketch.shape).border(border, sketch.shape)
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

            val outfitState: OutfitState.Style<ColorImport> by DelegateNullFallBack.Ref(
                outfitState,
                fallBackValue = { OutfitStateNull() }
            )

            companion object {

                @Composable
                fun Style.copy(scope: @Composable StyleBuilder.() -> Unit = {}) =
                    StyleBuilder(this).also {
                        it.scope()
                    }.get()

                inline val OutfitBorderStateColor.asPaletteSize: OutfitPaletteSize<OutfitBorderStateColor>
                    get() = OutfitPaletteSize(normal = this)

                inline val Dp.asStateColor: OutfitBorderStateColor
                    get() = OutfitBorderStateColor(size = this)

            }

            constructor(style: Style) : this(
                template = style.template,
                size = style.size,
                outfitState = style.outfitState,
            )

            fun resolveColor(selector: Any? = null) =
                outfitState.resolve(selector, ColorImport::class)

            fun resolve(selector: Any? = null) =
                resolveColor(selector)?.let {
                    template.get(size, it)
                }

        }

    }


}

