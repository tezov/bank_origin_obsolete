/*
 *  *********************************************************************************
 *  Created by Tezov on 01/04/2023 21:02
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 01/04/2023 20:46
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
    style: OutfitFrame.StateColor,
    selector: Any?= null
) = border(style.outfitBorder, selector, style.outfitShape.resolve(selector))

fun Modifier.background(
    style: OutfitFrame.StateColor,
    selector: Any?=null
) = background(style.outfitShape, selector)

object OutfitFrame {

    class StateColor(
        val outfitShape: OutfitShape.StateColor = OutfitShape.StateColor(),
        val outfitBorder: OutfitBorder.StateColor = OutfitBorder.StateColor(),
    ) {

        companion object {

            class Builder internal constructor(style: StateColor) {
                var outfitShape = style.outfitShape
                var outfitBorder = style.outfitBorder

                internal fun get() = StateColor(
                    outfitShape = outfitShape,
                    outfitBorder = outfitBorder,
                )
            }

            @Composable
            fun StateColor.copy(builder: @Composable Builder.() -> Unit = {}) =
                Builder(this).also {
                    it.builder()
                }.get()

        }

        constructor(style: StateColor) : this(
            outfitShape = style.outfitShape,
            outfitBorder = style.outfitBorder,
        )

        fun getShape() = outfitShape.getShape()

        fun resolveColor(selector: Any? = null) = outfitShape.resolveColor(selector)

        fun resolveShape(selector: Any? = null) = outfitShape.resolve(selector)

        fun resolveBorder(selector: Any? = null) = outfitBorder.resolve(selector)

    }

}

