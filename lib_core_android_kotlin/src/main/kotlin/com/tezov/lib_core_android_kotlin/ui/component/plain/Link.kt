/*
 *  *********************************************************************************
 *  Created by Tezov on 06/04/2023 11:00
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 06/04/2023 11:00
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.component.plain

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import com.tezov.lib_core_android_kotlin.ui.theme.style.*
import androidx.compose.ui.graphics.Color as ColorImport

object Link {

    object StateColor {

        class StyleBuilder internal constructor(style: Style) {
            var outfitText = style.outfitText

            internal fun get() = Style(
                outfitText = outfitText,
            )
        }

        class Style(
            val outfitText: OutfitText.StateColor.Style = OutfitTextStateColor(),
        ) {

            object Nucleus {

                class Color(
                    val nucleusText: OutfitState.Style<ColorImport>? = null,
                )

                inline val OutfitState.Style<ColorImport>.asLinkNucleus get() = Color(nucleusText = this)

                class Typography(
                    val nucleusText: TextStyle? = null,
                )

                inline val TextStyle.asLinkNucleus get() = Typography(this)

            }

            companion object {

                @Composable
                fun Style.copy(builder: @Composable StyleBuilder.() -> Unit = {}) =
                    StyleBuilder(this).also {
                        it.builder()
                    }.get()

            }

            constructor(style: Style) : this(
                outfitText = style.outfitText,
            )
        }

        @Composable
        operator fun invoke(
            modifier: Modifier = Modifier,
            text: String,
            style: Style = Style(),
            selector: Any? = null,
            onClick: () -> Unit = {},
        ) {
            ClickableText(
                modifier = modifier,
                text = AnnotatedString(text),
                style = style.outfitText.resolve(selector),
            ) {
                onClick()
            }
        }

    }

}