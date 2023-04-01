/*
 *  *********************************************************************************
 *  Created by Tezov on 01/04/2023 21:02
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 01/04/2023 20:46
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

fun Modifier.border(
    style: OutfitBorder.StateColor,
    selector: Any? = null,
    sketch: OutfitShape.Sketch? = null
) = style.resolve(selector)?.let { border ->
    return sketch?.let {
        border(border, sketch.shape).clip(sketch.shape)
    } ?: kotlin.run {
        border(border)
    }
} ?: this

object OutfitBorder {

    enum class Template {
        Fill;

        fun get(size: Dp?, color: androidx.compose.ui.graphics.Color) = size?.let {
            when (this) {
                Fill -> BorderStroke(size, color)
            }
        }

    }

    class StateColor(
        val template: Template = Template.Fill,
        val size: Dp? = null,
        val outfitState: OutfitState.Style<androidx.compose.ui.graphics.Color> = OutfitStateEmpty(),
    ){

        companion object {

            class Builder internal constructor(style: StateColor) {
                var template = style.template
                var size = style.size
                var outfitState = style.outfitState

                fun get() = StateColor(
                    template = template,
                    size = size,
                    outfitState = outfitState,
                )
            }

            @Composable
            fun StateColor.copy(scope: @Composable Builder.() -> Unit = {}) =
                Builder(this).also {
                    it.scope()
                }.get()
        }

        constructor(style: StateColor) : this(
            template = style.template,
            size = style.size,
            outfitState = style.outfitState,
        )

        fun resolve(selector: Any? = null) = outfitState.resolve(selector, androidx.compose.ui.graphics.Color::class)?.let {
            template.get(size, it)
        }

    }

}

