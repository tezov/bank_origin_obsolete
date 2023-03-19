/*
 *  *********************************************************************************
 *  Created by Tezov on 19/03/2023 12:48
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 19/03/2023 12:47
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.theme.style

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

typealias OutfitFrameColorStyle<S> = OutfitFrame.Color.Style<S>
typealias OutfitFrameColor = OutfitFrameColorStyle<OutfitState.Simple.Selector>
typealias OutfitFrameColorDual = OutfitFrameColorStyle<OutfitState.Dual.Selector>
typealias OutfitFrameColorSemantic = OutfitFrameColorStyle<OutfitState.Semantic.Selector>

fun <S:Any> Modifier.border(
    style: OutfitFrame.Color.Style<S>,
    selector: S
) = style.outfitBorder?.let {
    border(it, selector, style.outfitShape?.resolve(selector))
} ?: this

fun <S:Any> Modifier.background(
    style: OutfitFrame.Color.Style<S>,
    selector: S
) = style.outfitShape?.let { background(it, selector) } ?: this

object OutfitFrame {

    object Color {

        open class Style<in S:Any>(
            val outfitShape: OutfitShapeColorStyle<S>? = null,
            val outfitBorder: OutfitBorderColorStyle<S>? = null,
        ) {

            companion object {

                open class Builder<S:Any> internal constructor(style: Style<S>) {
                    var outfitShape = style.outfitShape
                    var outfitBorder = style.outfitBorder

                    internal fun get() = Style(
                        outfitShape = outfitShape,
                        outfitBorder = outfitBorder,
                    )
                }

                @Composable
                fun <S:Any> Style<S>.copy(builder: @Composable Builder<S>.() -> Unit = {}) =
                    Builder(this).also {
                        it.builder()
                    }.get()

            }

            constructor(style: Style<S>) : this(
                outfitShape = style.outfitShape,
                outfitBorder = style.outfitBorder,
            )

        }
    }

}

