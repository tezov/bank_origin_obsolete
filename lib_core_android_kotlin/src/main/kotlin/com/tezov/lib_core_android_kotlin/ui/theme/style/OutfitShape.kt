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

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Dual.background
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Semantic.background

object OutfitShape {

    enum class Template {
        Asymmetric,
        Symmetric,
        Circle;

        fun get(size: Size? = null) = size?.let {
            when (this) {
                Asymmetric -> RoundedCornerShape(
                    topStart = it.topStart,
                    topEnd = it.topEnd,
                    bottomStart = it.bottomStart,
                    bottomEnd = it.bottomEnd
                )
                Symmetric, Circle -> RoundedCornerShape(corner = it.size)
            }
        }
    }

    data class Size private constructor(
        val topStart: CornerSize,
        val topEnd: CornerSize,
        val bottomStart: CornerSize,
        val bottomEnd: CornerSize,
        val isSymmetric: Boolean
    ) {

        constructor(
            topStart: CornerSize,
            topEnd: CornerSize,
            bottomStart: CornerSize,
            bottomEnd: CornerSize
        ) : this(topStart, topEnd, bottomStart, bottomEnd, false)

        constructor(
            topStart: Int = 0,
            topEnd: Int = 0,
            bottomStart: Int = 0,
            bottomEnd: Int = 0
        ) : this(
            CornerSize(topStart),
            CornerSize(topEnd),
            CornerSize(bottomStart),
            CornerSize(bottomEnd)
        )

        constructor(
            topStart: Dp = 0.dp,
            topEnd: Dp = 0.dp,
            bottomStart: Dp = 0.dp,
            bottomEnd: Dp = 0.dp
        ) : this(
            CornerSize(topStart),
            CornerSize(topEnd),
            CornerSize(bottomStart),
            CornerSize(bottomEnd)
        )

        constructor(size: CornerSize) : this(size, size, size, size, true)
        constructor(percent: Int) : this(CornerSize(percent))
        constructor(size: Dp) : this(CornerSize(size))

        val size get() = topStart
    }

    object Sketch {

        open class Style(
            template: Template = Template.Symmetric,
            size: Size? = null,
        ) {
            var template: Template = template
                private set(value) {
                    when (value) {
                        Template.Circle -> size = Size(50)
                        else -> {}
                    }
                    field = value
                }

            var size: Size? = size
                private set

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

            open fun resolve(): RoundedCornerShape? = template.get(size)
            open fun resolveOrDefault() = resolve() ?: RoundedCornerShape(8.dp)
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

        }

        fun Modifier.background(style: Style) =
            style.color?.let { background(it) } ?: this

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
                fun <T, OT : OutfitState.Style<T>> Style<T, OT>.copy(scope: @Composable Builder<T, OT>.() -> Unit = {}) = Builder(this).also {
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
        fun Modifier.background(style: Style<Color, OutfitStateDual<Color>>, enabled: Boolean) =
            style.outfitState?.let { background(it, enabled) } ?: this

        //Semantic
        fun Modifier.background(style: Style<Color, OutfitStateSemantic<Color>>, selector: OutfitState.Semantic.Selector) =
            style.outfitState?.let { background(it, selector) } ?: this

    }

}

