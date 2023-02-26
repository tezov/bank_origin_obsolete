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

package com.tezov.lib_core_android_kotlin.ui.component.plain

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextState

object Link {

    object Underlined{

        open class Style(
            val outfitText: OutfitTextState = OutfitTextState(),
        ){
            companion object{

                open class Scope internal constructor(style: Style) {
                    var outfitText = style.outfitText

                    internal fun get() = Style(
                        outfitText = outfitText,
                    )
                }

                @Composable
                fun Style.copy(scope: @Composable Scope.()->Unit) = Scope(this).also {
                    it.scope()
                }.get()

            }

            constructor(style: Style) : this(
                outfitText = style.outfitText,
            )
        }

        @Composable
        operator fun invoke(
            text:String,
            modifier: Modifier = Modifier,
            enabled: Boolean = true,
            style:Style = Style(),
            onClick: () -> Unit = {},
        ){
            ClickableText(
                modifier = modifier,
                text = AnnotatedString(text),
                style = style.outfitText.resolve(enabled),
            ) {
                onClick()
            }
        }

    }











}