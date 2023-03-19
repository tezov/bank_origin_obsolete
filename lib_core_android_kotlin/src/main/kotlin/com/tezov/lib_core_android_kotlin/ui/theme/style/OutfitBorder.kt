/*
 *  *********************************************************************************
 *  Created by Tezov on 19/03/2023 12:47
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 19/03/2023 12:47
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

typealias OutfitBorderColorStyle<S> = OutfitBorder.Color.Style<S>
typealias OutfitBorderColor = OutfitBorderColorStyle<OutfitState.Simple.Selector>
typealias OutfitBorderColorDual = OutfitBorderColorStyle<OutfitState.Dual.Selector>
typealias OutfitBorderColorSemantic = OutfitBorderColorStyle<OutfitState.Semantic.Selector>

fun <S:Any> Modifier.border(
    style: OutfitBorder.Color.Style<S>,
    selector: S,
    shape: OutfitShape.Shape? = null
) = style.resolve(selector)?.let { border ->
    shape?.let {
        border(border, shape.value).clip(shape.value)
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

    object Color{

        class Style<in S:Any>(
            val template: Template = Template.Fill,
            val size: Dp? = null,
            val outfitState: OutfitState.Style<androidx.compose.ui.graphics.Color,S>? = null,
        ){

            companion object {

                open class Builder<S:Any> internal constructor(style: Style<S>) {
                    var template = style.template
                    var size = style.size
                    var outfitState = style.outfitState

                    fun get() = Style(
                        template = template,
                        size = size,
                        outfitState = outfitState,
                    )
                }

                @Composable
                fun <S:Any> Style<S>.copy(scope: @Composable Builder<S>.() -> Unit = {}) =
                    Builder(this).also {
                        it.scope()
                    }.get()
            }

            constructor(style: Style<S>) : this(
                template = style.template,
                size = style.size,
                outfitState = style.outfitState,
            )

            fun resolve(selector: S) = outfitState?.resolve(selector, androidx.compose.ui.graphics.Color::class)?.let {
                template.get(size, it)
            }

        }

    }

}

