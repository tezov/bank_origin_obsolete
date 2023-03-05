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

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
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
            val color: Color? = null,
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

            }

            constructor(style: Style) : this(
                sketch = style,
                color = style.color,
            )

            override fun resolve() = color?.let { typo.copy(color = it) } ?: typo
        }

    }

    object State {

        open class Style<T, OT : OutfitState.Style<T>>(
            sketch: Sketch.Style = Sketch.Style(),
            val outfitState: OT? = null,
        ):Sketch.Style(sketch) {

            companion object {

                open class Builder<T, OT : OutfitState.Style<T>> internal constructor(style: Style<T, OT>): Sketch.Style.Companion.Builder(style) {
                    var outfitState = style.outfitState

                    override fun get() = Style(
                        sketch = super.get(),
                        outfitState = outfitState,
                    )
                }

                @Composable
                fun <T, OT : OutfitState.Style<T>> Style<T, OT>.copy(scope: @Composable Builder<T, OT>.()->Unit = {}) = Builder(this).also {
                    it.scope()
                }.get()

//                @Composable
//                fun Sketch.Style.copyToStateStyle(scope: @Composable Builder.() -> Unit = {}) =
//                    Builder(State.Style(this)).also { it.scope() }.get()

            }

            constructor(style: Style<T, OT>) : this(
                sketch = style,
                outfitState = style.outfitState,
            )

        }

        //Dual
        fun Style<Color, OutfitStateDual<Color>>.resolve(enabled: Boolean) = outfitState?.resolve(enabled)?.let { typo.copy(color = it) } ?: typo

        //Semantic
        fun Style<Color, OutfitStateSemantic<Color>>.resolve(selector: OutfitState.Semantic.Selector) = outfitState?.resolve(selector)?.let { typo.copy(color = it) } ?: typo

    }

}