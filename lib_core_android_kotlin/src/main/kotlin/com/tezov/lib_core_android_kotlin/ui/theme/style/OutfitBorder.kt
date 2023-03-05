/*
 *  *********************************************************************************
 *  Created by Tezov on 05/03/2023 20:33
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 05/03/2023 20:16
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
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorder.State.resolve


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
            open fun resolveOrDefault(color: Color) = resolve(color) ?: BorderStroke(1.dp, color)

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
            fun resolveOrDefault() = resolve() ?: BorderStroke(1.dp, color ?: Color.Transparent)

        }

        fun Modifier.border(style: Style) =
            style.resolve()?.let { border(it) } ?: this

    }

    object State {

        open class Style<T, OT : OutfitState.Style<T>>(
            sketch: Sketch.Style = Sketch.Style(),
            val outfitState: OT? = null,
        ) : Sketch.Style(sketch) {

            companion object {

                open class Builder<T, OT : OutfitState.Style<T>> internal constructor(style: Style<T, OT>) :
                    Sketch.Style.Companion.Builder(style) {
                    var outfitState = style.outfitState

                    override fun get() = Style(
                        sketch = super.get(),
                        outfitState = outfitState,
                    )
                }

                @Composable
                fun <T, OT : OutfitState.Style<T>> Style<T, OT>.copy(scope: @Composable Builder<T, OT>.() -> Unit = {}) =
                    Builder(this).also {
                        it.scope()
                    }.get()

//                @Composable
//                fun Sketch.Style.copyToStateStyle(scope: @Composable Builder.() -> Unit = {}) =
//                    Builder(Style(this)).also { it.scope() }.get()

            }

            constructor(style: Style<T, OT>) : this(
                sketch = style,
                outfitState = style.outfitState,
            )
        }

        //Dual
        fun Style<Color, OutfitState.Dual.Style<Color>>.resolve(enabled: Boolean) =
            outfitState?.resolve(enabled)?.let { template.get(size, it) }

        fun Style<Color, OutfitState.Dual.Style<Color>>.resolveOrDefault(enabled: Boolean) =
            resolve(enabled) ?: BorderStroke(1.dp, Color.Black)

        fun Modifier.border(
            style: Style<Color, OutfitState.Dual.Style<Color>>,
            enabled: Boolean
        ) = style.resolve(enabled)?.let { border(it) } ?: this

        //Semantic
        fun Style<Color, OutfitState.Semantic.Style<Color>>.resolve(selector: OutfitState.Semantic.Selector) =
            outfitState?.resolve(selector)?.let { template.get(size, it) }

        fun Style<Color, OutfitState.Semantic.Style<Color>>.resolveOrDefault(selector: OutfitState.Semantic.Selector) =
            resolve(selector) ?: BorderStroke(1.dp, Color.Black)

        fun Modifier.border(
            style: Style<Color, OutfitState.Semantic.Style<Color>>,
            selector: OutfitState.Semantic.Selector
        ) = style.resolve(selector)?.let { border(it) } ?: this

    }

}

