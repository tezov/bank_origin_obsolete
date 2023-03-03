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

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.isSpecified
import androidx.compose.ui.text.TextStyle

object OutfitText {

    object Sketch {

        open class Style(
            val typo: TextStyle = TextStyle(),
        ) {

            companion object {

                open class Builder internal constructor(style:Style) {
                    var typo = style.typo

                    open internal fun get() = Style(
                        typo = typo,
                    )

                }

                @Composable
                fun Style.copy(builder: @Composable Builder.()->Unit = {}) = Builder(this).also {
                    it.builder()
                }.get()

            }

            constructor(style: Style) : this(
                typo = style.typo,
            )

            open fun resolve() = typo
        }

    }
    
    object Simple {

        open class Style(
            sketch: Sketch.Style = Sketch.Style(),
            val color: Color = Color.Unspecified,
        ):Sketch.Style(sketch) {

            companion object {

                open class Builder internal constructor(style:Style): Sketch.Style.Companion.Builder(style) {
                    var color = style.color

                    override fun get() = Style(
                        sketch = super.get(),
                        color = color,
                   )

                }

                @Composable
                fun Style.copy(scope: @Composable Builder.()->Unit = {}) = Builder(this).also {
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

            override fun resolve() = if (color.isSpecified) typo.copy(color = color) else typo
        }

    }

    object State {

        open class Style(
            sketch: Sketch.Style = Sketch.Style(),
            val outfitColor: OutfitColorsState = OutfitColorsState(
                active = Color.Unspecified,
                inactive = Color.Unspecified
            ),
        ):Sketch.Style(sketch) {

            companion object {

                open class Builder internal constructor(style: Style): Sketch.Style.Companion.Builder(style) {
                    var outfitColor = style.outfitColor

                    override fun get() = Style(
                        sketch = super.get(),
                        outfitColor = outfitColor,
                    )
                }

                @Composable
                fun Style.copy(scope: @Composable Builder.()->Unit = {}) = Builder(this).also {
                    it.scope()
                }.get()

                @Composable
                fun Sketch.Style.copyToStateStyle(scope: @Composable Builder.() -> Unit = {}) =
                    Builder(State.Style(this)).also { it.scope() }.get()

                @Composable
                fun Simple.Style.copyToStateStyle(scope: @Composable Builder.() -> Unit = {}) = Builder(
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

            fun resolve(enabled: Boolean) = outfitColor.resolve(enabled).takeIf { it.isSpecified }
                ?.let { typo.copy(color = it) } ?: typo

        }

    }


}