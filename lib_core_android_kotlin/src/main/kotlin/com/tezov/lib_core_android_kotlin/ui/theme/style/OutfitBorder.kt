/*
 *  *********************************************************************************
 *  Created by Tezov on 13/03/2023 21:14
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 13/03/2023 21:14
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


object OutfitBorder {

    enum class Template {
        Fill;

        fun get(size: Dp?, color: Color) = size?.let {
            when (this) {
                Fill -> BorderStroke(size, color)
            }
        }

    }

    object Sketch {

        open class Style(
            val template: Template = Template.Fill,
            val size: Dp? = null,
        ) {

            companion object {

                open class Builder internal constructor(style: Style) {
                    var template = style.template
                    var size = style.size

                    internal open fun get() = Style(
                        template = template,
                        size = size,
                    )
                }

                @Composable
                fun Style.copy(builder: @Composable Builder.() -> Unit = {}) = Builder(this).also {
                    it.builder()
                }.get()

            }

            constructor(style: Style) : this(
                template = style.template,
                size = style.size,
            )

            open fun resolve(color: Color) = template.get(size, color)

        }

        fun Modifier.border(style: Style, color: Color) =
            style.resolve(color)?.let { border(it) } ?: this

    }

    object Simple {

        open class Style(
            sketch: Sketch.Style = Sketch.Style(),
            val color: Color? = null,
        ) : Sketch.Style(sketch) {

            companion object {

                open class Builder internal constructor(style: Style) :
                    Sketch.Style.Companion.Builder(style) {
                    var color = style.color

                    override fun get() = Style(
                        sketch = super.get(),
                        color = color,
                    )
                }

                @Composable
                fun Style.copy(scope: @Composable Builder.() -> Unit = {}) = Builder(this).also {
                    it.scope()
                }.get()

                @Composable
                fun Sketch.Style.copyToSimpleStyle(scope: @Composable Builder.() -> Unit = {}) =
                    Builder(Style(this)).also { it.scope() }.get()

            }

            constructor(style: Style) : this(
                sketch = style,
                color = style.color,
            )

            fun resolve() = template.get(size, color ?: Color.Transparent)
        }

        fun Modifier.border(style: Style) =
            style.resolve()?.let { border(it) } ?: this

    }

    object State {

        open class Style<T, S:OutfitState.Selector, OT : OutfitState.Style<T, S>>(
            sketch: Sketch.Style = Sketch.Style(),
            val outfitState: OT? = null,
        ) : Sketch.Style(sketch) {

            companion object {

                open class Builder<T, S:OutfitState.Selector, OT : OutfitState.Style<T, S>> internal constructor(style: Style<T, S, OT>) :
                    Sketch.Style.Companion.Builder(style) {
                    var outfitState = style.outfitState

                    override fun get() = Style(
                        sketch = super.get(),
                        outfitState = outfitState,
                    )
                }

                @Composable
                fun <T, S:OutfitState.Selector, OT : OutfitState.Style<T, S>> Style<T, S, OT>.copy(scope: @Composable Builder<T, S, OT>.() -> Unit = {}) =
                    Builder(this).also {
                        it.scope()
                    }.get()

//                @Composable
//                fun Sketch.Style.copyToStateStyle(scope: @Composable Builder.() -> Unit = {}) =
//                    Builder(Style(this)).also { it.scope() }.get()

            }

            constructor(style: Style<T, S, OT>) : this(
                sketch = style,
                outfitState = style.outfitState,
            )

            fun resolve(selector: S) = outfitState?.resolve(selector)?.let {
                when(it){
                    is Color -> template.get(size, it as Color)
                    else -> null
                }
            }

        }

        fun <T, S:OutfitState.Selector, OT : OutfitState.Style<T, S>> Modifier.border(
            style: Style<T, S, OT>,
            selector: S
        ) = style.resolve(selector)?.let { border(it) } ?: this

    }

}

