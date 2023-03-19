/*
 *  *********************************************************************************
 *  Created by Tezov on 19/03/2023 16:08
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 19/03/2023 14:46
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.theme.style

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

fun Modifier.border(
    style: OutfitFrame.StateColor,
    selector: Any
) = style.outfitBorder?.let {
    border(it, selector, style.outfitShape?.resolve(selector))
} ?: this

fun Modifier.background(
    style: OutfitFrame.StateColor,
    selector: Any
) = style.outfitShape?.let { background(it, selector) } ?: this

object OutfitFrame {

    class StateColor(
        val outfitShape: OutfitShape.StateColor? = null,
        val outfitBorder: OutfitBorder.StateColor? = null,
    ) {

        companion object {

            open class Builder internal constructor(style: StateColor) {
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

    }

}

