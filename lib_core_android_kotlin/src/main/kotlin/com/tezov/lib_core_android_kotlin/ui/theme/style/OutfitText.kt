/*
 *  *********************************************************************************
 *  Created by Tezov on 26/02/2023 21:19
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 26/02/2023 21:08
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */
package com.tezov.lib_core_android_kotlin.ui.theme.style

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.isSpecified
import androidx.compose.ui.text.TextStyle

object OutfitText {

    object Simple {

        open class Style(
            val typo: TextStyle = TextStyle(),
            val color: Color = Color.Unspecified,
        ) {

            companion object {

                open class Scope internal constructor(style:Style) {
                    var typo = style.typo
                    var color = style.color

                    internal fun get() = Style(
                        typo = typo,
                        color = color,
                   )

                }

                @Composable
                fun Style.copy(scope: @Composable Scope.()->Unit) = Scope(this).also {
                    it.scope()
                }.get()

            }

            constructor(style: Style) : this(
                typo = style.typo,
                color = style.color,
            )

            fun resolve() = if (color.isSpecified) typo.copy(color = color) else typo
        }

    }

    object State {

        open class Style(
            val typo: TextStyle = TextStyle(),
            val outfitColor: OutfitColorsSimple = OutfitColorsSimple(
                active = Color.Unspecified,
                inactive = Color.Unspecified
            ),
        ) {

            companion object {

                open class Scope internal constructor(style: Style) {
                    var typo = style.typo
                    var outfitColor = style.outfitColor

                    internal fun get() = Style(
                        typo = typo,
                        outfitColor = outfitColor,
                    )
                }

                @Composable
                fun Style.copy(scope: @Composable Scope.()->Unit) = Scope(this).also {
                    it.scope()
                }.get()

            }

            constructor(style: Style) : this(
                typo = style.typo,
                outfitColor = style.outfitColor,
            )

            fun resolve(enabled: Boolean) = outfitColor.resolve(enabled).takeIf { it.isSpecified }
                ?.let { typo.copy(color = it) } ?: typo

        }

    }


}