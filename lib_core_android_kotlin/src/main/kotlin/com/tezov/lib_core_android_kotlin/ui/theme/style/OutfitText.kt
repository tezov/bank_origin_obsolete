/*
 *  *********************************************************************************
 *  Created by Tezov on 06/04/2023 23:14
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 06/04/2023 23:14
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */
package com.tezov.lib_core_android_kotlin.ui.theme.style

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack
import androidx.compose.ui.graphics.Color as ColorImport

typealias OutfitTextStateColor = OutfitText.StateColor.Style

object OutfitText {

    object StateColor {

        class StyleBuilder internal constructor(
            style: Style
        ) {
            var typo = style.typo
            var outfitState = style.outfitState

            fun get() = Style(
                typo = typo,
                outfitState = outfitState,
            )
        }

        class Style(
            typo: TextStyle? = null,
            outfitState: OutfitState.Style<ColorImport>? = null,
        ) {

            val typo: TextStyle by DelegateNullFallBack(
                typo,
                lazyFallBackValue = { TextStyle() }
            )
            val outfitState: OutfitState.Style<ColorImport> by DelegateNullFallBack(
                outfitState,
                lazyFallBackValue = { OutfitStateNull() }
            )

            companion object {

                @Composable
                fun Style.copy(
                    scope: @Composable StyleBuilder.() -> Unit = {}
                ) = StyleBuilder(this).also {
                    it.scope()
                }.get()

                inline val OutfitTextStateColor.asPaletteSize: OutfitPaletteSize<OutfitTextStateColor>
                    get() = OutfitPaletteSize(normal = this)

                inline val TextStyle.asTextStateColor: OutfitTextStateColor
                    get() = Style(typo = this)

            }

            constructor(style: Style) : this(
                typo = style.typo,
                outfitState = style.outfitState,
            )

            fun resolve(selector: Any? = null) =
                outfitState.resolve(selector, ColorImport::class)?.let {
                    typo.copy(color = it)
                } ?: typo

        }

    }

}