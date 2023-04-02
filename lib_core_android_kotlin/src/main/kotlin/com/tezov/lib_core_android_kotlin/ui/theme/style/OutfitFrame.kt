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

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

fun Modifier.border(
    style: OutfitFrame.StateColor.Style,
    selector: Any?= null
) = border(style.outfitBorder, selector, style.outfitShape.resolve(selector))

fun Modifier.background(
    style: OutfitFrame.StateColor.Style,
    selector: Any?=null
) = background(style.outfitShape, selector)

object OutfitFrame {

    object StateColor{

        class Style(
            val outfitShape: OutfitShape.StateColor.Style = OutfitShape.StateColor.Style(),
            val outfitBorder: OutfitBorder.StateColor.Style = OutfitBorder.StateColor.Style(),
        ) {

            companion object {

                class Nucleus(
                    val outfitShape:OutfitState.Style<Color>,
                    val outfitBorder:OutfitState.Style<Color>,
                )

                class Builder internal constructor(style: Style) {
                    var outfitShape = style.outfitShape
                    var outfitBorder = style.outfitBorder

                    internal fun get() = Style(
                        outfitShape = outfitShape,
                        outfitBorder = outfitBorder,
                    )
                }

                @Composable
                fun Style.copy(builder: @Composable Builder.() -> Unit = {}) =
                    Builder(this).also {
                        it.builder()
                    }.get()

            }

            constructor(style: Style) : this(
                outfitShape = style.outfitShape,
                outfitBorder = style.outfitBorder,
            )

            fun getShape() = outfitShape.getShape()

            fun resolveColor(selector: Any? = null) = outfitShape.resolveColor(selector)

            fun resolveShape(selector: Any? = null) = outfitShape.resolve(selector)

            fun resolveBorder(selector: Any? = null) = outfitBorder.resolve(selector)

        }

    }



}

