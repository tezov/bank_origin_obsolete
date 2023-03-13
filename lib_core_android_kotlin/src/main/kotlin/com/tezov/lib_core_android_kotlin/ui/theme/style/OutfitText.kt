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

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

object OutfitText {

    object Sketch {

        open class Style(
            val typo: TextStyle = TextStyle(),
        ) {

            companion object {

                open class Builder internal constructor(style: Style) {
                    var typo = style.typo

                    open internal fun get() = Style(
                        typo = typo,
                    )

                }

                @Composable
                fun Style.copy(builder: @Composable Builder.() -> Unit = {}) = Builder(this).also {
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

            override fun resolve() = color?.let { typo.copy(color = it) } ?: typo
        }

    }

    object State {

        open class Style<T, S : OutfitState.Selector, OT : OutfitState.Style<T, S>>(
            sketch: Sketch.Style = Sketch.Style(),
            val outfitState: OT? = null,
        ) : Sketch.Style(sketch) {

            companion object {

                open class Builder<T, S : OutfitState.Selector, OT : OutfitState.Style<T, S>> internal constructor(
                    style: Style<T, S, OT>
                ) : Sketch.Style.Companion.Builder(style) {
                    var outfitState = style.outfitState

                    override fun get() = Style(
                        sketch = super.get(),
                        outfitState = outfitState,
                    )
                }

                @Composable
                fun <T, S : OutfitState.Selector, OT : OutfitState.Style<T, S>> Style<T, S, OT>.copy(
                    scope: @Composable Builder<T, S, OT>.() -> Unit = {}
                ) = Builder(this).also {
                    it.scope()
                }.get()

//                @Composable
//                fun Sketch.Style.copyToStateStyle(scope: @Composable Builder.() -> Unit = {}) =
//                    Builder(State.Style(this)).also { it.scope() }.get()

            }

            constructor(style: Style<T, S, OT>) : this(
                sketch = style,
                outfitState = style.outfitState,
            )

        }

        //Dual
        fun Style<Color, OutfitStateDualSelector, OutfitStateDual<Color>>.resolve(selector: OutfitStateDualSelector) =
            outfitState?.resolve(selector)?.let { typo.copy(color = it) } ?: typo

        //Semantic
        fun Style<Color, OutfitStateSemanticSelector, OutfitStateSemantic<Color>>.resolve(selector: OutfitStateSemanticSelector) =
            outfitState?.resolve(selector)?.let { typo.copy(color = it) } ?: typo

    }

}