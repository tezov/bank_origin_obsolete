/*
 *  *********************************************************************************
 *  Created by Tezov on 28/03/2023 23:25
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 28/03/2023 22:36
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitStateSimple
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText

object Link {

    object StateColor {

        class Style(
            val outfitText: OutfitText.StateColor = OutfitText.StateColor(),
        ) {
            companion object {

                open class Builder internal constructor(style: Style) {
                    var outfitText = style.outfitText

                    internal fun get() = Style(
                        outfitText = outfitText,
                    )
                }

                @Composable
                fun Style.copy(builder: @Composable Builder.() -> Unit = {}) = Builder(this).also {
                    it.builder()
                }.get()

                val Underlined
                    get() = Style(
                        outfitText = OutfitText.StateColor(
                            outfitState = OutfitStateSimple(
                                value = Color.Black,
                            )
                        ),
                    )

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