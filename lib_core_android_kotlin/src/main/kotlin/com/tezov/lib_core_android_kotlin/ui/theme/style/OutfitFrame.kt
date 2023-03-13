/*
 *  *********************************************************************************
 *  Created by Tezov on 13/03/2023 20:43
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 13/03/2023 20:43
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.theme.style

import androidx.compose.foundation.border
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorder.State.resolve
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.Simple.background
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.State.background

object OutfitFrame {

    object Simple {

        open class Style(
            val outfitShape: OutfitShapeSimple? = null,
            val outfitBorder: OutfitBorderSimple? = null,
        ) {

            companion object {

                fun Style.copy(
                    shape: OutfitShapeSimple? = null,
                    border: OutfitBorderSimple? = null,
                ) = Style(
                    outfitShape = shape ?: this.outfitShape,
                    outfitBorder = border ?: this.outfitBorder,
                )

                open class Builder internal constructor(style: Style) {
                    var outfitShape = style.outfitShape
                    var outfitBorder = style.outfitBorder

                    internal fun get() = Style(
                        outfitShape = outfitShape,
                        outfitBorder = outfitBorder,
                    )
                }

                @Composable
                fun Style.copy(builder: @Composable Builder.() -> Unit = {}) = Builder(this).also {
                    it.builder()
                }.get()

            }

            constructor(style: Style) : this(
                outfitShape = style.outfitShape,
                outfitBorder = style.outfitBorder,
            )

        }

        fun Modifier.border(style: OutfitFrame.Simple.Style) =
            style.outfitBorder?.resolve()?.let { border ->
                style.outfitShape?.resolve()?.let { shape ->
                    border(border, shape).clip(shape)
                } ?: kotlin.run {
                    border(border)
                }
            } ?: this

        fun Modifier.background(style: OutfitFrame.Simple.Style) =
            style.outfitShape?.let { background(it) } ?: this

    }

    object State {

        open class Style<T, S:OutfitState.Selector, OT : OutfitState.Style<T, S>>(
            val outfitShape: OutfitShapeState<T, S, OT>? = null,
            val outfitBorder: OutfitBorderState<T, S, OT>? = null,
        ) {

            companion object {

                open class Builder<T, S:OutfitState.Selector, OT : OutfitState.Style<T, S>> internal constructor(style: Style<T, S, OT>) {
                    var outfitShape = style.outfitShape
                    var outfitBorder = style.outfitBorder

                    internal fun get() = Style(
                        outfitShape = outfitShape,
                        outfitBorder = outfitBorder,
                    )
                }

                @Composable
                fun <T, S:OutfitState.Selector, OT : OutfitState.Style<T, S>> Style<T, S, OT>.copy(builder: @Composable Builder<T, S, OT>.() -> Unit = {}) =
                    Builder(this).also {
                        it.builder()
                    }.get()

            }

            constructor(style: Style<T, S, OT>) : this(
                outfitShape = style.outfitShape,
                outfitBorder = style.outfitBorder,
            )

        }

        //Dual
        fun Modifier.border(
            style: Style<Color, OutfitStateDualSelector, OutfitStateDual<Color>>,
            selector: OutfitStateDualSelector
        ) = style.outfitBorder?.resolve(selector)?.let { border ->
                style.outfitShape?.resolve()?.let { shape ->
                    border(border, shape).clip(shape)
                } ?: kotlin.run {
                    border(border)
                }
            } ?: this

        fun Modifier.background(
            style: Style<Color, OutfitStateDualSelector, OutfitStateDual<Color>>,
            selector: OutfitStateDualSelector
        ) = style.outfitShape?.let { shape -> background(shape, selector) } ?: this

        //Semantic
        fun Modifier.border(
            style: Style<Color, OutfitStateSemanticSelector, OutfitStateSemantic<Color>>,
            selector: OutfitStateSemanticSelector
        ) = style.outfitBorder?.resolve(selector)?.let { border ->
            style.outfitShape?.resolve()?.let { shape ->
                border(border, shape).clip(shape)
            } ?: kotlin.run {
                border(border)
            }
        } ?: this

        fun Modifier.background(
            style: Style<Color, OutfitStateSemanticSelector, OutfitStateSemantic<Color>>,
            selector: OutfitStateSemanticSelector
        ) = style.outfitShape?.let { shape -> background(shape, selector) } ?: this

    }

}

