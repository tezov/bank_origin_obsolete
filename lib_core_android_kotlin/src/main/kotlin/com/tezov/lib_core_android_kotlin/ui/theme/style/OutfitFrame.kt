/*
 *  *********************************************************************************
 *  Created by Tezov on 26/02/2023 16:10
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 26/02/2023 16:09
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.theme.style

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

fun Modifier.border(style: OutfitFrame.Simple.Style):Modifier {
    val shape = style.outfitShape.resolveOrDefault()
    return border(style.outfitBorder.resolveOrDefault(), shape).clip(shape)
}

fun Modifier.background(style: OutfitFrame.Simple.Style) = background(style.outfitShape.color)

fun Modifier.border(style: OutfitFrame.State.Style, enabled:Boolean):Modifier {
    val shape = style.outfitShape.resolveOrDefault()
    return border(style.outfitBorder.resolveOrDefault(enabled), shape).clip(shape)
}

fun Modifier.background(style: OutfitFrame.State.Style, enabled:Boolean) = background(style.outfitShape.outfitColor.resolve(enabled))

object OutfitFrame{
    
    object Simple{

        open class Style(
            val outfitShape: OutfitShapeSimple = OutfitShapeSimple(),
            val outfitBorder: OutfitBorderSimple = OutfitBorderSimple(),
        ) {

            companion object{



                fun Style.copy(
                    shape: OutfitShapeSimple? = null,
                    border: OutfitBorderSimple? = null,
                ) = Style(
                    outfitShape = shape ?: this.outfitShape,
                    outfitBorder = border ?: this.outfitBorder,
                )
            }

            constructor(style: Style) : this(
                outfitShape = style.outfitShape,
                outfitBorder = style.outfitBorder,
            )

        }

    }

    object State{

        open class Style(
            val outfitShape: OutfitShapeState = OutfitShapeState(),
            val outfitBorder: OutfitBorderState = OutfitBorderState(),
        ) {

            companion object{

                fun Style.copy(
                    shape: OutfitShapeState? = null,
                    border: OutfitBorderState? = null,
                ) = Style(
                    outfitShape = shape ?: this.outfitShape,
                    outfitBorder = border ?: this.outfitBorder,
                )
            }

            constructor(style: Style) : this(
                outfitShape = style.outfitShape,
                outfitBorder = style.outfitBorder,
            )

        }

    }
    
}

