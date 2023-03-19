/*
 *  *********************************************************************************
 *  Created by Tezov on 19/03/2023 12:48
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 19/03/2023 12:48
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

typealias OutfitShapeColorStyle<S> = OutfitShape.Color.Style<S>
typealias OutfitShapeColor = OutfitShapeColorStyle<OutfitState.Dual.Selector>
typealias OutfitShapeColorDual = OutfitShapeColorStyle<OutfitState.Dual.Selector>
typealias OutfitShapeColorSemantic = OutfitShapeColorStyle<OutfitState.Semantic.Selector>

fun <S:Any> Modifier.background(
    style: OutfitShape.Color.Style<S>,
    selector: S
) = style.resolve(selector)?.takeIf { it.color != null }?.let { background(it.color!!, it.value) } ?: this

object OutfitShape {

    enum class Template {
        Asymmetric,
        Symmetric,
        Circle;

        fun get(size: Size? = null, color: androidx.compose.ui.graphics.Color) = size?.let {
            Shape(when (this) {
                Asymmetric -> RoundedCornerShape(
                    topStart = it.topStart,
                    topEnd = it.topEnd,
                    bottomStart = it.bottomStart,
                    bottomEnd = it.bottomEnd
                )
                Symmetric, Circle -> RoundedCornerShape(corner = it.size)
            }, color)
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

    data class Shape(val value:androidx.compose.ui.graphics.Shape, val color: androidx.compose.ui.graphics.Color? = null)

    object Color{

        class Style<in S:Any>(
            template: Template = Template.Symmetric,
            size: Size? = null,
            val outfitState: OutfitState.Style<androidx.compose.ui.graphics.Color,S>? = null,
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

                open class Builder<S:Any> internal constructor(style: Style<S>) {
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
                fun <S:Any> Style<S>.copy(scope: @Composable Builder<S>.() -> Unit = {}) = Builder(this).also {
                    it.scope()
                }.get()

            }

            constructor(style: Style<S>) : this(
                template = style.template,
                size = style.size,
                outfitState = style.outfitState,
            )

            fun resolve(selector: S) = outfitState?.resolve(selector, androidx.compose.ui.graphics.Color::class)?.let {
                template.get(size, it)
            }

        }

    }



}

