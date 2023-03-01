/*
 *  *********************************************************************************
 *  Created by Tezov on 01/03/2023 22:00
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 01/03/2023 22:00
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
import androidx.compose.ui.graphics.isSpecified
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.ui.component.branch.HorizontalScrollable

fun Modifier.background(style: OutfitShape.Simple.Style) =
    if (style.color.isSpecified) background(style.color) else this

fun Modifier.background(style: OutfitShape.State.Style, enabled: Boolean) =
    background(style.outfitColor, enabled)

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

                open class Scope internal constructor(style: Style) {
                    var template = style.template
                    var size = style.size

                    open internal fun get() = Style(
                        template = template,
                        size = size,
                    )
                }

                @Composable
                fun Style.copy(scope: @Composable Scope.() -> Unit = {}) = Scope(this).also {
                    it.scope()
                }.get()

            }

            constructor(style: Style) : this(
                template = style.template,
                size = style.size,
            )

            fun resolve(): RoundedCornerShape? = template.get(size)
            fun resolveOrDefault() = resolve() ?: RoundedCornerShape(8.dp)
        }

    }

    object Simple {

        open class Style(
            sketch: Sketch.Style = Sketch.Style(),
            val color: Color = Color.Unspecified,
        ):Sketch.Style(sketch) {

            companion object {

                open class Scope internal constructor(style: Style): Sketch.Style.Companion.Scope(style) {
                    var color = style.color

                    override fun get() = Style(
                        sketch = super.get(),
                        color = color,
                    )
                }

                @Composable
                fun Style.copy(scope: @Composable Scope.() -> Unit = {}) = Scope(this).also {
                    it.scope()
                }.get()

                @Composable
                fun Sketch.Style.copyToSimpleStyle(scope: @Composable Scope.() -> Unit = {}) =
                    Scope(Style(this)).also { it.scope() }.get()

                @Composable
                fun State.Style.copyToSimpleStyle(scope: @Composable Scope.() -> Unit = {}) = Scope(
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

        }

    }

    object State {

        open class Style(
            sketch: Sketch.Style = Sketch.Style(),
            val outfitColor: OutfitColorsSimple = OutfitColorsSimple(),
        ):Sketch.Style(sketch) {

            companion object {

                open class Scope internal constructor(style: Style): Sketch.Style.Companion.Scope(style) {
                    var outfitColor = style.outfitColor

                    override fun get() = Style(
                        sketch = super.get(),
                        outfitColor = outfitColor,
                    )
                }

                @Composable
                fun Style.copy(scope: @Composable Scope.() -> Unit = {}) = Scope(this).also {
                    it.scope()
                }.get()

                @Composable
                fun Sketch.Style.copyToStateStyle(scope: @Composable Scope.() -> Unit = {}) =
                    Scope(Style(this)).also { it.scope() }.get()

                @Composable
                fun Simple.Style.copyToStateStyle(scope: @Composable Scope.() -> Unit = {}) = Scope(
                    Style(
                        sketch = this,
                        outfitColor = OutfitColorsSimple(
                            active = color
                        )
                    )
                ).also { it.scope() }.get()

            }

            constructor(style: Style) : this(
                sketch = style,
                outfitColor = style.outfitColor,
            )

        }

    }

}

