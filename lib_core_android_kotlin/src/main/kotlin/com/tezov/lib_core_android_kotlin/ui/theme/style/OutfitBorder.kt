/*
 *  *********************************************************************************
 *  Created by Tezov on 03/03/2023 22:33
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 03/03/2023 21:58
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

fun Modifier.border(style: OutfitBorder.Sketch.Style, color: Color) =
    style.resolve(color)?.let { border(it) } ?: this

fun Modifier.border(style: OutfitBorder.Simple.Style) =
    style.resolve()?.let { border(it) } ?: this

fun Modifier.border(style: OutfitBorder.State.Style, enabled: Boolean) =
    style.resolve(enabled)?.let { border(it) } ?: this

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

            open fun resolve(color:Color) = template.get(size, color)
            open fun resolveOrDefault(color:Color) = resolve(color) ?: BorderStroke(1.dp, color)

        }

    }

    object Simple {

        open class Style(
            sketch: Sketch.Style = Sketch.Style(),
            val color: Color = Color.Unspecified,
        ):Sketch.Style(sketch) {

            companion object {

                open class Builder internal constructor(style: Style):Sketch.Style.Companion.Builder(style) {
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

                @Composable
                fun State.Style.copyToSimpleStyle(scope: @Composable Builder.() -> Unit = {}) = Builder(
                    Style(
                        sketch = this,
                        color = outfitColor.active
                    )
                ).also { it.scope() }.get()

            }

            constructor(style: Style) : this(
                sketch = style,
                color = style.color,
            )

            fun resolve() = template.get(size, color)
            fun resolveOrDefault() = resolve() ?: BorderStroke(1.dp, color)

        }

    }

    object State {

        open class Style(
            sketch: Sketch.Style = Sketch.Style(),
            val outfitColor: OutfitColorsState = OutfitColorsState(),
        ):Sketch.Style(sketch) {

            companion object {

                open class Builder internal constructor(style: Style):Sketch.Style.Companion.Builder(style) {
                    var outfitColor = style.outfitColor

                    override fun get() = Style(
                        sketch = super.get(),
                        outfitColor = outfitColor,
                    )
                }

                @Composable
                fun Style.copy(scope: @Composable Builder.() -> Unit = {}) = Builder(this).also {
                    it.scope()
                }.get()

                @Composable
                fun Sketch.Style.copyToStateStyle(scope: @Composable Builder.() -> Unit = {}) =
                    Builder(Style(this)).also { it.scope() }.get()

                @Composable
                fun Simple.Style.copyToStateStyle(scope: @Composable Builder.() -> Unit = {}) = Companion.Builder(
                    Style(
                        sketch = this,
                        outfitColor = OutfitColorsState(
                            active = color
                        )
                    )
                ).also { it.scope() }.get()
            }

            constructor(style: Style) : this(
                sketch = style,
                outfitColor = style.outfitColor,
            )

            fun resolve(enabled: Boolean) = template.get(size, outfitColor.resolve(enabled))
            fun resolveOrDefault(enabled: Boolean) =
                resolve(enabled) ?: BorderStroke(1.dp, Color.Black)
        }


    }

}

