/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 16:15
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 14:21
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.theme.style

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack

fun Modifier.border(
    style: OutfitFrame.StateColor.Style,
    selector: Any? = null
) = border(style.outfitBorder, selector, style.outfitShape.resolve(selector))

fun Modifier.background(
    style: OutfitFrame.StateColor.Style,
    selector: Any? = null
) = background(style.outfitShape, selector)

typealias OutfitFrameStateColor = OutfitFrame.StateColor.Style

object OutfitFrame {

    object StateColor {

        class StyleBuilder internal constructor(style: Style) {
            var outfitShape = style.outfitShape
            var outfitBorder = style.outfitBorder

            internal fun get() = Style(
                outfitShape = outfitShape,
                outfitBorder = outfitBorder,
            )
        }

        class Style(
            outfitShape: OutfitShapeStateColor? = null,
            outfitBorder: OutfitBorderStateColor? = null,
        ) {
            val outfitShape: OutfitShapeStateColor by DelegateNullFallBack.Ref(
                outfitShape,
                fallBackValue = { OutfitShapeStateColor() }
            )
            val outfitBorder: OutfitBorderStateColor by DelegateNullFallBack.Ref(
                outfitBorder,
                fallBackValue = { OutfitBorderStateColor() }
            )

            companion object {

                @Composable
                fun Style.copy(builder: @Composable StyleBuilder.() -> Unit = {}) =
                    StyleBuilder(this).also {
                        it.builder()
                    }.get()

            }

            constructor(style: Style) : this(
                outfitShape = style.outfitShape,
                outfitBorder = style.outfitBorder,
            )

            fun getShape() = outfitShape.getShape()

            fun resolveColorShape(selector: Any? = null) = outfitShape.resolveColor(selector)

            fun resolveShape(selector: Any? = null) = outfitShape.resolve(selector)

            fun resolveColorBorder(selector: Any? = null) = outfitBorder.resolveColor(selector)

            fun resolveBorder(selector: Any? = null) = outfitBorder.resolve(selector)

        }

    }


}

