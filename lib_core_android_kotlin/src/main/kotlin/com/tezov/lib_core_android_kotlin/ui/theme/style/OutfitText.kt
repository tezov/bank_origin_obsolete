/*
 *  *********************************************************************************
 *  Created by Tezov on 21/03/2023 20:53
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 21/03/2023 20:39
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */
package com.tezov.lib_core_android_kotlin.ui.theme.style

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle

object OutfitText {

    class StateColor(
        val typo: TextStyle = TextStyle(),
        val outfitState: OutfitState.Style<androidx.compose.ui.graphics.Color> = OutfitStateEmpty(),
    ) {

        companion object {

            open class Builder internal constructor(
                style: StateColor
            ) {
                var typo = style.typo
                var outfitState = style.outfitState

                fun get() = StateColor(
                    typo = typo,
                    outfitState = outfitState,
                )
            }

            @Composable
            fun StateColor.copy(
                scope: @Composable Builder.() -> Unit = {}
            ) = Builder(this).also {
                it.scope()
            }.get()

        }

        constructor(style: StateColor) : this(
            typo = style.typo,
            outfitState = style.outfitState,
        )

        fun resolve(selector: Any? = null) = outfitState.resolve(selector, androidx.compose.ui.graphics.Color::class)?.let {
            typo.copy(color = it)
        } ?: typo

    }

}