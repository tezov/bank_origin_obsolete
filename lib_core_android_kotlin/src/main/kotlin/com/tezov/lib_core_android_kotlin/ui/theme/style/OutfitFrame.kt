/*
 *  *********************************************************************************
 *  Created by Tezov on 04/04/2023 15:07
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 04/04/2023 15:07
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.theme.style

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color as ColorImport

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
            val outfitShape: OutfitShapeStateColor = OutfitShapeStateColor(),
            val outfitBorder: OutfitBorderStateColor = OutfitBorderStateColor(),
        ) {

            object Nucleus {

                class Color(
                    val nucleusShape: OutfitState.Style<ColorImport> = OutfitStateEmpty(),
                    val nucleusBorder: OutfitState.Style<ColorImport>  = OutfitStateEmpty(),
                )

            }

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

            fun resolveColor(selector: Any? = null) = outfitShape.resolveColor(selector)

            fun resolveShape(selector: Any? = null) = outfitShape.resolve(selector)

            fun resolveBorder(selector: Any? = null) = outfitBorder.resolve(selector)

        }

    }


}

