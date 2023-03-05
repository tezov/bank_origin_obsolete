/*
 *  *********************************************************************************
 *  Created by Tezov on 05/03/2023 20:33
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 05/03/2023 20:33
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

        open class Style<T, OT : OutfitState.Style<T>>(
            val outfitShape: OutfitShapeState<T, OT>? = null,
            val outfitBorder: OutfitBorderState<T, OT>? = null,
        ) {

            companion object {

                open class Builder<T, OT : OutfitState.Style<T>> internal constructor(style: Style<T, OT>) {
                    var outfitShape = style.outfitShape
                    var outfitBorder = style.outfitBorder

                    internal fun get() = Style<T, OT>(
                        outfitShape = outfitShape,
                        outfitBorder = outfitBorder,
                    )
                }

                @Composable
                fun <T, OT : OutfitState.Style<T>> Style<T, OT>.copy(builder: @Composable Builder<T, OT>.() -> Unit = {}) =
                    Builder(this).also {
                        it.builder()
                    }.get()

            }

            constructor(style: Style<T, OT>) : this(
                outfitShape = style.outfitShape,
                outfitBorder = style.outfitBorder,
            )

        }

        //Dual
        fun Modifier.border(
            style: Style<Color, OutfitStateDual<Color>>,
            enabled: Boolean
        ) = style.outfitBorder?.resolve(enabled)?.let { border ->
                style.outfitShape?.resolve()?.let { shape ->
                    border(border, shape).clip(shape)
                } ?: kotlin.run {
                    border(border)
                }
            } ?: this

        fun Modifier.background(
            style: Style<Color, OutfitStateDual<Color>>,
            enabled: Boolean
        ) = style.outfitShape?.let { shape -> background(shape, enabled) } ?: this

        //Semantic
        //todo

    }

}

