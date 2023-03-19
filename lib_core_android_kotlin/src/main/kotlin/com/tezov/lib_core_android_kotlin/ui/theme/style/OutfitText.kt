/*
 *  *********************************************************************************
 *  Created by Tezov on 19/03/2023 12:47
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

typealias OutfitTextColorStyle<S> = OutfitText.Color.Style<S>
typealias OutfitTextColor = OutfitTextColorStyle<OutfitState.Simple.Selector>
typealias OutfitTextColorDual = OutfitTextColorStyle<OutfitState.Dual.Selector>
typealias OutfitTextColorSemantic = OutfitTextColorStyle<OutfitState.Semantic.Selector>

object OutfitText {

    object Color {

        class Style<in S:Any>(
            val typo: TextStyle = TextStyle(),
            val outfitState: OutfitState.Style<androidx.compose.ui.graphics.Color,S>? = null,
        ) {

            companion object {

                open class Builder<S:Any> internal constructor(
                    style: Style<S>
                ) {
                    var typo = style.typo
                    var outfitState = style.outfitState

                    fun get() = Style(
                        typo = typo,
                        outfitState = outfitState,
                    )
                }

                @Composable
                fun <S:Any> Style<S>.copy(
                    scope: @Composable Builder<S>.() -> Unit = {}
                ) = Builder(this).also {
                    it.scope()
                }.get()

            }

            constructor(style: Style<S>) : this(
                typo = style.typo,
                outfitState = style.outfitState,
            )

            fun resolve(selector: S) = outfitState?.resolve(selector, androidx.compose.ui.graphics.Color::class)?.let {
                typo.copy(color = it)
            } ?: typo

        }

    }

}