/*
 *  *********************************************************************************
 *  Created by Tezov on 02/04/2023 14:12
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 02/04/2023 14:12
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
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color as ColorImport

fun Modifier.background(
    style: OutfitShape.StateColor.Style,
    selector: Any? = null
) = style.resolve(selector)?.takeIf { it.color != null }?.let { background(it.color!!, it.shape) } ?: this

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

        fun get(size: Size? = null, color: ColorImport) = get(size)?.let {
            Sketch(it, color)
        }

    }

    data class Size constructor(
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

    data class Sketch(val shape: Shape, val color: ColorImport? = null)

    object StateColor{

        class Style(
            template: Template = Template.Symmetric,
            size: Size? = null,
            val outfitState: OutfitState.Style<ColorImport> = OutfitStateEmpty(),
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

                class Builder internal constructor(style: Style) {
                    var template = style.template
                    var size = style.size
                    var outfitState = style.outfitState

                    fun get() = Style(
                        template = template,
                        size = size,
                        outfitState = outfitState,
                    )
                }

                @Composable
                fun Style.copy(scope: @Composable Builder.() -> Unit = {}) = Builder(this).also {
                    it.scope()
                }.get()

            }

            constructor(style: Style) : this(
                template = style.template,
                size = style.size,
                outfitState = style.outfitState,
            )

            fun getShape() = template.get(size)

            fun resolveColor(selector: Any? = null) =  outfitState.resolve(selector, ColorImport::class)

            fun resolve(selector: Any? = null) = resolveColor(selector)?.let {
                template.get(size, it)
            }

        }
    }





}

