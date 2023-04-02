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
import androidx.compose.ui.text.TextStyle

object OutfitText {

    object StateColor{

        class Style(
            val typo: TextStyle = TextStyle(),
            val outfitState: OutfitState.Style<androidx.compose.ui.graphics.Color> = OutfitStateEmpty(),
        ) {

            companion object {

                class Builder internal constructor(
                    style: Style
                ) {
                    var typo = style.typo
                    var outfitState = style.outfitState

                    fun get() = Style(
                        typo = typo,
                        outfitState = outfitState,
                    )
                }

                @Composable
                fun Style.copy(
                    scope: @Composable Builder.() -> Unit = {}
                ) = Builder(this).also {
                    it.scope()
                }.get()

            }

            constructor(style: Style) : this(
                typo = style.typo,
                outfitState = style.outfitState,
            )

            fun resolve(selector: Any? = null) = outfitState.resolve(selector, androidx.compose.ui.graphics.Color::class)?.let {
                typo.copy(color = it)
            } ?: typo

        }

    }



}